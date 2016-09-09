package ua.hillel.tyshenko.carRental.controller;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by roman on 22.08.16.
 */
@WebServlet(urlPatterns = {"/home", "", "/index.html", "/index.htm", "/index.jsp"})
public class HomeServlet extends HttpServlet {
    static final Logger logger = ApplicationLogger.getLogger(HomeServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Request to page: " + request.getServletPath());
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homeView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
