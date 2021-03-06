package ua.hillel.tyshenko.carRental.controller;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.data.dao.CarDAO;
import ua.hillel.tyshenko.carRental.data.dao.CarDAOImpl;
import ua.hillel.tyshenko.carRental.data.domain.CarDomain;
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
 * Created by roman on 08.10.16.
 */
@WebServlet(urlPatterns = {"/car_list/display"})
public class DisplayCarServlet extends HttpServlet {

    static final Logger logger = Logger.getLogger(DisplayCarServlet.class);

    private static final long serialVersionUID = -4721004270696506053L;

    public DisplayCarServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Car viewing form.");
        if (request.getParameter("id") == null) {
            response.sendRedirect(request.getContextPath() + "/car_list");
            return;
        }
        long id = Long.valueOf(request.getParameter("id"));
        Connection connection = StoreAndCookieUtil.getStoredConnection(request);
        try {
            CarDAO carDAO = new CarDAOImpl(connection);
            CarDomain car = carDAO.getById(id);
            if (car != null) {
                logger.info("Car data entered correctly.");
                request.setAttribute("car", car.getCar());
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/displayCarView.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("errorString", "Car with ID: #" + id + " does not exists.");
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/car_list");
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
        this.doGet(request, response);
    }
}
