package ua.hillel.tyshenko.carRental.controller.validator;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.model.Client;
import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by roman on 21.09.16.
 */
public class ClientValidator extends Validator<Client> {
    static final Logger logger = ApplicationLogger.getLogger(ClientValidator.class);

    public ClientValidator(Client client) {
        super(client);
    }

    @Override
    public boolean isValid() {
        boolean error = false;
        errorMessage = new StringBuffer();
        logger.info("Client with ID:" + model.getId() + " prepared to validation.");
        String firstName = model.getFirstName();
        String lastName = model.getLastName();
        if (firstName.isEmpty() && lastName.isEmpty()) {
            errorMessage.append("Client always must have first or last name. Enter at least one of them, please.\n");
            error = true;
        }
        Date birthday = model.getBirthday();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1920, Calendar.JANUARY, 1);
        Date minDate = calendar.getTime();
        if (birthday != null && (birthday.getTime() < minDate.getTime() || birthday.getTime() > (new Date()).getTime())) {
            errorMessage.append("Clients birthday has to be in the range from ");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            errorMessage.append(formatter.format(minDate));
            errorMessage.append(" to ");
            errorMessage.append(formatter.format(new Date()));
            errorMessage.append(". Please, enter it correctly.\n");
            error = true;
        }
        int dLNumber = model.getdLNumber();
        if (dLNumber <= 0) {
            errorMessage.append("Client always must have driver's license number. Enter it, please.\n");
            error = true;
        }
        int lengthOfDrivingExperience = model.getLengthOfDrivingExperience();
        if (lengthOfDrivingExperience < 0) {
            errorMessage.append("Length of driving experience has to be positive value. Please enter it correctly.\n");
            error = true;
        }
        logger.info("Data validation completed.");
        return !error;
    }

}
