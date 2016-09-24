package ua.hillel.tyshenko.carRental.controller.validator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by roman on 12.09.16.
 */
public abstract class Validator<T> {
    protected T model;
    protected StringBuffer errorMessage;

    public Validator(T model) {
        this.model = model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public StringBuffer getErrorMessage() {
        return errorMessage;
    }

    public abstract boolean isValid();

}
