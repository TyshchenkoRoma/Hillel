package ua.hillel.tyshenko.carRental.controller;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;
import ua.hillel.tyshenko.carRental.utils.StoreAndCookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by roman on 12.09.16.
 */
@WebServlet(urlPatterns = {"/logout"})
public class DoLogoutServlet extends HttpServlet {
    static final Logger logger = ApplicationLogger.getLogger(DoLogoutServlet.class);
    private static final long serialVersionUID = 8244392699971640663L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Started logout procedure");
        StoreAndCookieUtil.deleteAdminCookie(response);
        StoreAndCookieUtil.storeLoginedAdministrator(request.getSession(), null);
        logger.info("Administrator logouted.");
        response.sendRedirect(request.getHeader("Referer"));
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
