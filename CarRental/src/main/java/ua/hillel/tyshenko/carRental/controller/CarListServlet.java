package ua.hillel.tyshenko.carRental.controller;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.data.dao.CarDAO;
import ua.hillel.tyshenko.carRental.data.dao.CarDAOImpl;
import ua.hillel.tyshenko.carRental.data.domain.CarDomain;
import ua.hillel.tyshenko.carRental.data.service.ConnectionFactory;
import ua.hillel.tyshenko.carRental.model.Car;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by roman on 27.08.16.
 */
@WebServlet(urlPatterns = {"/car_list"})
public class CarListServlet extends HttpServlet {
    private static final long serialVersionUID = -5098121881329935823L;
    static final Logger logger = Logger.getLogger(CarListServlet.class);

    public CarListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Extracting of car list from database.");
        List<Car> cars = null;
        Connection connection = StoreAndCookieUtil.getStoredConnection(request);
        try {
            CarDAO carDAO = new CarDAOImpl(connection);
            cars = carDAO.getAll().stream().map(CarDomain::getCar).collect(Collectors.toList());
            logger.info("Car list extracted.");
        } catch (SQLException ex) {
            logger.warn("Data base exception.", ex);
            request.setAttribute("javax.servlet.error.exception", ex);
            request.setAttribute("javax.servlet.error.status_code", 500);
            response.setStatus(500);
        }
        request.setAttribute("carList", cars);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/carListView.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}