package ua.hillel.tyshenko.carRental.data.dao;

import ua.hillel.tyshenko.carRental.data.domain.AdministratorDomain;

import java.util.List;

/**
 * Created by roman on 15.08.16.
 */
public interface AdministratorDAO extends AbstractDAO<AdministratorDomain> {
   // public interface AdministratorDAO extends AbstractDAO<AdministratorDomain>{

        List<AdministratorDomain> getByFullName(String firsName, String lastName);

       // List<ClientDomain> getAllClients();

        AdministratorDomain getByLoginAndPassword(String login, String password);

    }

