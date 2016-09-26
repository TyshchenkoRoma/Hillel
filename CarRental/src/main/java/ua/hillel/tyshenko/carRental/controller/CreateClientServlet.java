package ua.hillel.tyshenko.carRental.controller;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.controller.validator.ClientValidator;
import ua.hillel.tyshenko.carRental.controller.validator.Validator;
import ua.hillel.tyshenko.carRental.data.dao.ClientDAO;
import ua.hillel.tyshenko.carRental.data.dao.ClientDAOImpl;
import ua.hillel.tyshenko.carRental.data.domain.ClientDomain;
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

/**
 * Created by roman on 26.09.16.
 */
@WebServlet(urlPatterns = {"/client_list/create"})
public class CreateClientServlet extends HttpServlet {
    static final Logger logger = ApplicationLogger.getLogger(CreateClientServlet.class);

    private static final long serialVersionUID = 770031007379483882L;

    public CreateClientServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Client creating form.");
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createClientView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Client creation procedure started.");
        StringBuffer errorString = new StringBuffer();
        ModelExtractor extractor = new ModelExtractor(request);
        Client client = extractor.getClient();
        if (client != null) {
            Validator<Client> validator = new ClientValidator(client);
            if (validator.isValid()) {
                Connection connection = StoreAndCookieUtil.getStoredConnection(request);
                try {
                    ClientDAO clientDAO = new ClientDAOImpl(connection);
                    ClientDomain controlClient = clientDAO.getByDLNumber(client.getdLNumber());
                    if (controlClient == null) {
                        logger.info("Client data entered correctly.");
                        clientDAO.add(new ClientDomain(client));
                        response.sendRedirect(request.getContextPath() + "/client_list");
                        return;
                    } else {
                        errorString.append("Client with driver's license number \"");
                        errorString.append(client.getdLNumber());
                        errorString.append("\" already exists. It's ID: #");
                        errorString.append(controlClient.getId());
                        errorString.append(".\n");
                    }
                } catch (SQLException ex) {
                    logger.warn("Data base exception.", ex);
                    request.setAttribute("javax.servlet.error.exception", ex);
                    request.setAttribute("javax.servlet.error.status_code", 500);
                    response.setStatus(500);
                }
            }
            errorString.append(validator.getErrorMessage());
            request.setAttribute("client", client);
        } else {
            errorString.append("Sorry, try to fill and submit form again. ");
            request.setAttribute("errorString", errorString.toString());
            doGet(request, response);
            return;
        }
        request.setAttribute("errorString", errorString.toString());
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/createClientView.jsp");
        dispatcher.forward(request, response);
    }

}
