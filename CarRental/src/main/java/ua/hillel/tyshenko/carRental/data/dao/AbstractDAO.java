package ua.hillel.tyshenko.carRental.data.dao;

import ua.hillel.tyshenko.carRental.data.domain.AbstractDomain;

import java.util.List;

/**
 * Created by roman on 03.08.16.
 */
public interface AbstractDAO <T extends AbstractDomain> {

    List<T> getAll();

    T getById(Long id);

    void add(T model);

    void update(T model);

    void remove(T model);
}
