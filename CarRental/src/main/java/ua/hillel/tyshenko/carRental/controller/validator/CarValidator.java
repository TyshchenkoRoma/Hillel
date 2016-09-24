package ua.hillel.tyshenko.carRental.controller.validator;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.model.Car;
import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by roman on 12.09.16.
 */
public class CarValidator extends Validator <Car> {
    static final Logger logger = ApplicationLogger.getLogger(CarValidator.class);

    public CarValidator(Car car) {
        super(car);
    }
    @Override
    public boolean isValid() {
        boolean error = false;
        errorMessage = new StringBuffer();
        logger.info("Car with ID:" + model.getId() + " prepared to validation.");
        String numberPlate = model.getNumberPlate();
        if (numberPlate.isEmpty()) {
            errorMessage.append("Car always must have number plate. Enter it, please.\n");
            error = true;
        }
        int yearOfManufacture = model.getYearOfManufacture();
        if (yearOfManufacture != 0 && (yearOfManufacture < 1900 || yearOfManufacture > Calendar.getInstance().get(Calendar.YEAR))) {
            errorMessage.append("Set year of manufacture in the range between 1900 and ");
            errorMessage.append(Calendar.getInstance().get(Calendar.YEAR));
            errorMessage.append(".\n");
            error = true;
        }
        BigDecimal rentalPrice = model.getRentalPrice();
        if (rentalPrice.doubleValue() < 0d) {
            errorMessage.append("Set into rental price positive value.\n");
            error = true;
        }
        logger.info("Data validation completed.");
        return !error;
    }

}
