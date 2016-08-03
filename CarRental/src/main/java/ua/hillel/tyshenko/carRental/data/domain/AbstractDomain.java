package ua.hillel.tyshenko.carRental.data.domain;

import java.io.Serializable;

/**
 * Created by roman on 03.08.16.
 */
public abstract   class  AbstractDomain implements Serializable {
    private static final long serialVersionUID = -3235671974350823999L;


    private Long id;

    public AbstractDomain() {
    }

    public AbstractDomain(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
