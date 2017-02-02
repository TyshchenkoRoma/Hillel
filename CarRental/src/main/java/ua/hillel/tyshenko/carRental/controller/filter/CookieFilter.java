package ua.hillel.tyshenko.carRental.controller.filter;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.model.Administrator;
import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;
import ua.hillel.tyshenko.carRental.utils.StoreAndCookieUtil;
import ua.hillel.tyshenko.carRental.data.dao.*;
import ua.hillel.tyshenko.carRental.data.domain.AdministratorDomain;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by roman on 28.08.16.
 */
@WebFilter(filterName = "CookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter {

    static final Logger logger = Logger.getLogger(CookieFilter.class);

    public CookieFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        logger.info("Cookie Filter initialized.");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Cookie Filter called.");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        Administrator adminInSession = StoreAndCookieUtil.getLoginedAdministrator(session);

        if (adminInSession != null) {
            logger.info("Administrator checked in cookie.");
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }

        // Connection was created in JDBCFilter.
        Connection connection = StoreAndCookieUtil.getStoredConnection(request);

        // Flag check cookie
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null && connection != null) {
            String adminLogin = StoreAndCookieUtil.getAdminLoginInCookie(httpRequest);
            try {
                AdministratorDAO administratorDAO = new AdministratorDAOImpl(connection);
                AdministratorDomain domain = administratorDAO.getByLogin(adminLogin);
                Administrator administrator = (domain == null) ? null : domain.getAdministrator();
                if (administrator == null) {
                    logger.warn("Something wrong with storing administrator data.");
//                    throw new SQLException("Something wrong with storing administrator data.");
                } else {
                    StoreAndCookieUtil.storeLoginedAdministrator(session, administrator);
                    // Mark checked.
                }
            } catch (SQLException ex) {
                logger.warn("Request error!", ex);
//            ex.printStackTrace();
            }
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }

        chain.doFilter(request, response);
    }

}