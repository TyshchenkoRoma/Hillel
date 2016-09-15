package ua.hillel.tyshenko.carRental.controller.filter;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.model.Administrator;
import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;
import ua.hillel.tyshenko.carRental.utils.StoreAndCookieUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by roman on 15.09.16.
 */
@WebFilter(filterName = "accessFilter")
public class AccessFilter implements Filter {
    static final Logger logger = ApplicationLogger.getLogger(AccessFilter.class);

    public AccessFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Access Filter initialized.");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        logger.info("Access Filter called.");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        logger.info("Getting logined administrator.");
        Administrator loginedAdministrator = StoreAndCookieUtil.getLoginedAdministrator(httpRequest.getSession());
        if (loginedAdministrator == null) {
            logger.info("Request without authentication. Access denied.");
            String errorString;
            if (httpRequest.getServletPath().endsWith("/logout")) {
                errorString = "No logined administrator.";
            } else {
                errorString = "Access denied! Login previously.";
            }
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = httpRequest.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request, response);
        } else {
            logger.info("Permit has been obtained.");
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}
