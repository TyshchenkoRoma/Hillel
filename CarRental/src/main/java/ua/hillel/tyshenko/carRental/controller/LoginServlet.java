package ua.hillel.tyshenko.carRental.controller;

import org.apache.log4j.Logger;
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

/**
 * Created by roman on 30.08.16.
 */

@WebServlet(urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 7410978571600567753L;
    static final Logger logger = ApplicationLogger.getLogger(LoginServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Request to page: " + request.getServletPath());
        Administrator loginedAdministrator = StoreAndCookieUtil.getLoginedAdministrator(request.getSession());
        RequestDispatcher dispatcher;
        if (loginedAdministrator != null) {
            request.setAttribute("errorString", "You need to logout before changing administrator account.");
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adminInfoView.jsp");
        } else {
            dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        }
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
