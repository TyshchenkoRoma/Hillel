package ua.hillel.tyshenko.carRental.data.dao;

import ua.hillel.tyshenko.carRental.data.domain.CarDomain;
import ua.hillel.tyshenko.carRental.data.domain.ClientDomain;
import ua.hillel.tyshenko.carRental.data.domain.OrderDomain;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by roman on 08.10.16.
 */
public interface OrderDAO extends AbstractDAO<OrderDomain> {

    List<OrderDomain> getByClient(ClientDomain client) throws SQLException;

    OrderDomain getByCar(CarDomain car) throws SQLException;

}