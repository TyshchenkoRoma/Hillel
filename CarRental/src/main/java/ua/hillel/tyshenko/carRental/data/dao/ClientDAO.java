package ua.hillel.tyshenko.carRental.data.dao;

import ua.hillel.tyshenko.carRental.data.domain.ClientDomain;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by roman on 17.08.16.
 */
public interface ClientDAO extends AbstractDAO<ClientDomain> {
    List<ClientDomain> getByFullName(String firsName, String lastName) throws SQLException;
}
