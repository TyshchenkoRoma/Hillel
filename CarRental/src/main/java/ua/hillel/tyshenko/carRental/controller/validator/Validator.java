package ua.hillel.tyshenko.carRental.controller.validator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by roman on 12.09.16.
 */
public abstract class Validator<T> {
    protected HttpServletRequest request;
    protected String message = "";

    public Validator(HttpServletRequest request) {
        this.request = request;
    }

    public String getMessage() {
        return message;
    }

    public void addMessage(String massage) {
        this.message += massage;
    }

    public abstract boolean validate();
    public abstract T getValue();
}
