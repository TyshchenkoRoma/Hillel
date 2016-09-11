package ua.hillel.tyshenko.carRental.controller;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.data.dao.ClientDAO;
import ua.hillel.tyshenko.carRental.data.dao.ClientDAOImpl;
import ua.hillel.tyshenko.carRental.data.domain.ClientDomain;
import ua.hillel.tyshenko.carRental.data.service.ConnectionFactory;
import ua.hillel.tyshenko.carRental.model.Administrator;
import ua.hillel.tyshenko.carRental.model.Client;
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
@WebServlet(urlPatterns = {"/client_list"})
public class ClientListServlet extends HttpServlet {
    private static final long serialVersionUID = -5098121881329935823L;
    static final Logger logger = ApplicationLogger.getLogger(ClientListServlet.class);

    public ClientListServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Administrator loginedAdministrator = StoreAndCookieUtil.getLoginedAdministrator(request.getSession());
        if (loginedAdministrator != null) {
            logger.info("Extracting of client list list from database.");
            List<Client> clientList = null;
            Connection connection = StoreAndCookieUtil.getStoredConnection(request);
            try {
                ClientDAO clientDAO = new ClientDAOImpl(connection);
                clientList = clientDAO.getAll().stream().map(ClientDomain::getClient).collect(Collectors.toList());
                logger.info("Client list list extracted.");
            } catch (SQLException ex) {
                logger.warn("Data base exception.", ex);
                request.setAttribute("javax.servlet.error.exception", ex);
                request.setAttribute("javax.servlet.error.status_code", 500);
                response.setStatus(500);
            }
            request.setAttribute("clientList", clientList);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/clientListView.jsp");
            dispatcher.forward(request, response);
        } else {
            logger.info("Request without authentication. Access denied.");
            request.setAttribute("errorString", "Access denied! Login previously.");
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
