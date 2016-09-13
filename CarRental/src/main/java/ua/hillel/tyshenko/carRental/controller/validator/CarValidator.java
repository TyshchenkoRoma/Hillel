package ua.hillel.tyshenko.carRental.controller.validator;

import ua.hillel.tyshenko.carRental.model.Car;
import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * Created by roman on 12.09.16.
 */
public class CarValidator extends Validator <Car> {

    static final org.apache.log4j.Logger logger = ApplicationLogger.getLogger(CarValidator.class);
    private Car car = new Car();

    public CarValidator(HttpServletRequest request) {
        super(request);
    }

    public CarValidator(HttpServletRequest request, Car car) {
        super(request);
        this.car = car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean validate() {
        boolean error = false;
        logger.info("Car with ID:" + car.getCarId() + " prepared to validator.");
        String numberPlate = request.getParameter("numberPlate") != null ? request.getParameter(" number Plate") : "";
        car.setNumberPlate(numberPlate);
        if (numberPlate.isEmpty()) {
            message += "Car always must have number plate. Entered it, please. ";
            error = true;
        }
        String model = request.getParameter("carModel") != null ? request.getParameter("carModel") : "";
        car.setCarModel(model);
        try {
            ua.hillel.tyshenko.carRental.model.Car.Color color = request.getParameter("color") != null &&!request.getParameter("color").isEmpty() ? ua.hillel.tyshenko.carRental.model.Car.Color.valueOf(request.getParameter("color")) : Car.Color.NAN;
        car.setCarColour(color);
        } catch (IllegalArgumentException ex) {
            message += "Choose correct color. ";
            error = true;
            logger.warn(ex);
        }
        String description = request.getParameter("description") != null ? request.getParameter("description") : "";
        car.setDescription(description);
        try {
            int yearOfManufacture = request.getParameter("yearOfManufacture") != null && !request.getParameter("yearOfManufacture").isEmpty() ? Integer.valueOf(request.getParameter("yearOfManufacture")) : 0;
            car.setYearOfManufacture(yearOfManufacture);
        } catch (IllegalArgumentException ex) {
            message += "Set correct year of manufacture. ";
            error = true;
            logger.warn(ex);
        }
        try {
            BigDecimal rentalPrice = request.getParameter("rentalPrice") != null && !request.getParameter("rentalPrice").isEmpty() ? BigDecimal.valueOf(Double.valueOf(request.getParameter("rentalPrice"))) : BigDecimal.ZERO;
            car.setRentPrice(rentalPrice);
        } catch (IllegalArgumentException ex) {
            message += "Set correct rental price. ";
            error = true;
            logger.warn(ex);
        }
        boolean rented = Boolean.valueOf(request.getParameter("rented"));
        car.setIsRented(rented);
        logger.info("Data validation completed.");
        return !error;


    }

    @Override
    public Car getValue() {
        return car;
    }
}
