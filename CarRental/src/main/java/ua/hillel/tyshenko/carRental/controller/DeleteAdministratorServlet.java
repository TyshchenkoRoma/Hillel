package ua.hillel.tyshenko.carRental.controller;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by roman on 06.10.16.
 */
@WebServlet(urlPatterns = {"/admin_list/delete"})
public class DeleteAdministratorServlet extends HttpServlet {
    static final Logger logger = Logger.getLogger(DeleteAdministratorServlet.class);
    private static final long serialVersionUID = -8074439330386731495L;

    public DeleteAdministratorServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Administrator deleting form.");
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/admin_list");
            return;
        }
        long id = Long.valueOf(request.getParameter("id"));
        Connection connection = StoreAndCookieUtil.getStoredConnection(request);
        try {
            AdministratorDAO administratorDAO = new AdministratorDAOImpl(connection);
            AdministratorDomain administrator = administratorDAO.getById(id);
            if (administrator != null) {
                logger.info("Administrator data entered correctly.");
                request.setAttribute("administrator", administrator.getAdministrator());
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/deleteAdminView.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorString", "Administrator with ID: #" + id + " does not exists.");
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin_list");
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            logger.warn("Data base exception.", ex);
            request.setAttribute("javax.servlet.error.exception", ex);
            request.setAttribute("javax.servlet.error.status_code", 500);
            response.setStatus(500);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Administrator deletion procedure started.");
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/admin_list");
            return;
        }
        long id = Long.valueOf(request.getParameter("id"));
        Connection connection = StoreAndCookieUtil.getStoredConnection(request);
        try {
            AdministratorDAO administratorDAO = new AdministratorDAOImpl(connection);
            AdministratorDomain controlAdministrator = administratorDAO.getById(id);
            String errorString = "";
            boolean hasError = false;
            if (controlAdministrator != null) {
                if (!controlAdministrator.getAdministrator().equals(StoreAndCookieUtil.getLoginedAdministrator(request.getSession()))) {
                    String password = request.getParameter("password");
                    if (controlAdministrator.getPassword().equals(PasswordHelper.getSecurePassword(password))) {
                        logger.info("Administrator password entered correctly.");
                        administratorDAO.remove(controlAdministrator);
                        logger.info("Administrator deleted.");
                    } else {
                        request.setAttribute("errorString", "Administrator password is incorrect!");
                        this.doGet(request, response);
                    }
                } else {
                    errorString = "Logined administrator won't be removed.";
                    hasError = true;
                }
            } else {
                errorString = "Administrator with with ID: #" + id + " doesn't exist.";
                hasError = true;
            }
            if (hasError) {
                request.setAttribute("errorString", errorString);
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin_list");
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            logger.warn("Data base exception.", ex);
            request.setAttribute("javax.servlet.error.exception", ex);
            request.setAttribute("javax.servlet.error.status_code", 500);
            response.setStatus(500);
        }
        response.sendRedirect(request.getContextPath() + "/admin_list");
    }
}
