package ua.hillel.tyshenko.carRental.controller.validator;

import ua.hillel.tyshenko.carRental.model.Client;
import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;

/**
 * Created by roman on 21.09.16.
 */
public class ClientValidator extends Validator<Client> {

    static final org.apache.log4j.Logger logger = ApplicationLogger.getLogger(ClientValidator.class);

    private Client client = new Client();

    public ClientValidator(HttpServletRequest request) {
        super(request);
    }

    public ClientValidator(HttpServletRequest request, Client client) {
        super(request);
        this.client = client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean validate() {
        boolean error = false;
        logger.info("Client with ID:" + client.getId() + " prepared to validator.");

        String firstName = request.getParameter("firstName") != null ? request.getParameter("firstName") : "";
        client.setFirstName(firstName);

        String lastName = request.getParameter("lastName") != null ? request.getParameter("lastName") : "";
        client.setFirstName(lastName);

        try {
            Date birthday = request.getParameter("birthday") != null && !request.getParameter("birthday").isEmpty() ? request.getParameter("birthday") : 0;
            client.setBirthday(birthday);
        } catch (IllegalArgumentException ex) {
            message += "Set correct birthday. ";
            error = true;
            logger.warn(ex);
        }
        try {
            int dLNumber = request.getParameter("dLNumber") != null && !request.getParameter("dLNumber").isEmpty() ? Integer.valueOf(request.getParameter("dLNumber")) : 0;
            client.setdLNumber(dLNumber);
        } catch (IllegalArgumentException ex) {
            message += "Set correct dLNumber. ";
            error = true;
            logger.warn(ex);
        }
        try {
            int lengthOfDrivingExperience = request.getParameter("lengthOfDrivingExperience") != null && !request.getParameter("lengthOfDrivingExperience").isEmpty() ? Integer.valueOf(request.getParameter("lengthOfDrivingExperience")) : 0;
            client.setLengthOfDrivingExperience(lengthOfDrivingExperience);
        } catch (IllegalArgumentException ex) {
            message += "Set correct birthday. ";
            error = true;
            logger.warn(ex);
        }
        return !error;
    }


    @Override
    public Client getValue() {
        return client;
    }
}
