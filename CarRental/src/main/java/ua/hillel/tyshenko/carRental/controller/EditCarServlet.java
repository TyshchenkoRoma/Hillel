package ua.hillel.tyshenko.carRental.controller;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.controller.validator.CarValidator;
import ua.hillel.tyshenko.carRental.controller.validator.Validator;
import ua.hillel.tyshenko.carRental.data.dao.CarDAO;
import ua.hillel.tyshenko.carRental.data.dao.CarDAOImpl;
import ua.hillel.tyshenko.carRental.data.domain.CarDomain;
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

/**
 * Created by roman on 14.09.16.
 */
@WebServlet(urlPatterns = {"/car_list/edit"})
public class EditCarServlet extends HttpServlet {
    private static final long serialVersionUID = -6669657844128409978L;

    static final Logger logger = ApplicationLogger.getLogger(EditCarServlet.class);

    public EditCarServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Car editing form.");
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
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
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editCarView.jsp");
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
        logger.info("Car updating procedure started.");
        StringBuffer errorString = new StringBuffer();
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/car_list");
            return;
        }
        ModelExtractor extractor = new ModelExtractor(request);
        Car car = extractor.getCar();
        if (car != null) {
            car.setId(Long.valueOf(request.getParameter("id")));
            Validator<Car> validator = new CarValidator(car);
            if (validator.isValid()) {
                Connection connection = StoreAndCookieUtil.getStoredConnection(request);
                try {
                    CarDAO carDAO = new CarDAOImpl(connection);
                    CarDomain controlCar = carDAO.getByNumberPlate(car.getNumberPlate());
                    if (controlCar == null || controlCar.getId() == car.getId()) {
                        logger.info("Car data entered correctly.");
                        carDAO.update(new CarDomain(car));
                        response.sendRedirect(request.getContextPath() + "/car_list");
                        return;
                    } else {
                        errorString.append("Car with number plate \"");
                        errorString.append(car.getNumberPlate());
                        errorString.append("\" already exists. It's ID: #");
                        errorString.append(controlCar.getId());
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
            request.setAttribute("car", car);
        } else {
            errorString.append("Sorry, try to fill and submit form again. ");
            request.setAttribute("errorString", errorString.toString());
            doGet(request, response);
            return;
        }
        request.setAttribute("errorString", errorString.toString());
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editCarView.jsp");
        dispatcher.forward(request, response);
    }
}