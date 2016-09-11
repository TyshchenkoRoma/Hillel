package ua.hillel.tyshenko.carRental.data.dao;

import ua.hillel.tyshenko.carRental.data.domain.AbstractDomain;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by roman on 03.08.16.
 */
public interface AbstractDAO <T extends AbstractDomain> {
    int ONE = 1;
    int ALL = Integer.MAX_VALUE;
    List<T> getAll() throws SQLException;

    T getById(Long id) throws SQLException;

    void add(T model) throws SQLException;

    void update(T model) throws SQLException;

    void remove(T model) throws SQLException;
}
