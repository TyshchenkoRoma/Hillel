package ua.hillel.tyshenko.carRental.data.dao;

import ua.hillel.tyshenko.carRental.data.domain.AdministratorDomain;
import ua.hillel.tyshenko.carRental.data.domain.ClientDomain;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by roman on 15.08.16.
 */
public interface AdministratorDAO extends AbstractDAO<AdministratorDomain> {
    List<AdministratorDomain> getByFullName(String firsName, String lastName) throws SQLException;

    List<ClientDomain> getAllClients() throws SQLException;

    AdministratorDomain getByLoginAndPassword(String login, String password) throws SQLException;

    AdministratorDomain getByLogin(String login) throws SQLException;

    }

