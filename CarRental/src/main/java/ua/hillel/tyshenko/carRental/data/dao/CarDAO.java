package ua.hillel.tyshenko.carRental.data.dao;

import ua.hillel.tyshenko.carRental.data.domain.CarDomain;

import java.sql.SQLException;

/**
 * Created by roman on 03.08.16.
 */
public interface CarDAO  extends AbstractDAO<CarDomain> {

    CarDomain getByModel(String model) throws SQLException;
    CarDomain getByNumberPlate(String numberPlate) throws SQLException;
}
