package ua.hillel.tyshenko.carRental.controller;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.data.dao.AdministratorDAO;
import ua.hillel.tyshenko.carRental.data.dao.AdministratorDAOImpl;
import ua.hillel.tyshenko.carRental.data.domain.AdministratorDomain;
import ua.hillel.tyshenko.carRental.data.service.ConnectionFactory;
import ua.hillel.tyshenko.carRental.model.Administrator;
import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;
import ua.hillel.tyshenko.carRental.utils.StoreAndCookieUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by roman on 29.08.16.
 */
@WebServlet(urlPatterns = "/admin_list", name = "AdministratorListServlet")
public class AdministratorListServlet extends HttpServlet {
    private static final long serialVersionUID = -928176549145443440L;
    static final Logger logger = ApplicationLogger.getLogger(AdministratorListServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //    Administrator loginedAdministrator = StoreAndCookieUtil.getLoginedAdministrator(request.getSession());
      //      if (loginedAdministrator != null) {
                logger.info("Extracting of administrator list from database.");
                List<Administrator> administrators = null;
                Connection connection = StoreAndCookieUtil.getStoredConnection(request);
                try {
                    AdministratorDAO administratorDAO = new AdministratorDAOImpl(connection);
                    administrators = administratorDAO.getAll().stream().map(AdministratorDomain::getAdministrator).collect(Collectors.toList());
                    logger.info("Administrator list extracted.");
                } catch (SQLException ex) {
                    logger.warn("Data base exception.", ex);
                    request.setAttribute("javax.servlet.error.exception", ex);
                    request.setAttribute("javax.servlet.error.status_code", 500);
                    response.setStatus(500);
                }
                request.setAttribute("administratorList", administrators);
                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminListView.jsp");
                dispatcher.forward(request, response);
//            } else {
//                logger.info("Request without authentication. Access denied.");
//                request.setAttribute("errorString", "Access denied! Login previously.");
//                RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
//                dispatcher.forward(request, response);
//            }
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
