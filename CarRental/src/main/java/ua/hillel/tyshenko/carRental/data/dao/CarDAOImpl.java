package ua.hillel.tyshenko.carRental.data.dao;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.data.domain.CarDomain;
import ua.hillel.tyshenko.carRental.data.service.ConnectionFactory;
import ua.hillel.tyshenko.carRental.data.service.DbUtil;
import ua.hillel.tyshenko.carRental.model.Car;
import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;

/**
 * Created by roman on 04.08.16.
 */
public class CarDAOImpl implements CarDAO {

    static final org.apache.log4j.Logger logger = ApplicationLogger.getLogger(CarDAO.class);

    private static final int ONE = 1;
    private static final int ALL = Integer.MAX_VALUE;

    private Connection connection;
    private Statement statement;

    private List<CarDomain> getItems(String query, int amount) {
        ResultSet resultSet = null;
        List<CarDomain> cars = new ArrayList<>();
        try {
            try {
                connection = ConnectionFactory.getInstance().getConnection();
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
                if (resultSet!= null) {
                    for(int i = 0; i < amount & resultSet.next(); i++) {
                        CarDomain car = new CarDomain(resultSet.getLong("id"),
                                resultSet.getString("model"),
                                Car.Colour.valueOf(resultSet.getString("color")),
                                resultSet.getString("description"),
                                resultSet.getInt("year_of_manufacture"),
                                resultSet.getBigDecimal("rental_price"),
                                resultSet.getBoolean("rented"));
                        cars.add(car);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            DbUtil.close(resultSet);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        logger.info("Get data query occurred.");
        return cars;
    }

    public CarDomain getByModel(String model) {
        String query = "SELECT * FROM car_tb WHERE model='" + model + "'";
        List<CarDomain> cars = getItems(query,ONE);
        return cars.isEmpty() ? null : cars.get(0);
    }

    public List<CarDomain> getAll() {
        String query = "SELECT * FROM car_tb";
        return getItems(query, ALL);
    }

    public CarDomain getById(Long id) {
        String query = "SELECT * FROM car_tb WHERE id=" + id;
        List<CarDomain> cars = getItems(query,ONE);
        return cars.isEmpty() ? null : cars.get(0);
    }

    public void add(CarDomain car) {

    }

    public void update(CarDomain car) {

    }

    public void remove(CarDomain car) {

    }
}
