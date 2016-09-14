package ua.hillel.tyshenko.carRental.data.dao;

import org.apache.log4j.Logger;
import ua.hillel.tyshenko.carRental.data.domain.CarDomain;
import ua.hillel.tyshenko.carRental.data.service.ConnectionFactory;
import ua.hillel.tyshenko.carRental.data.service.DataBaseUtil;
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

    static final Logger logger = ApplicationLogger.getLogger(CarDAO.class);

    private Connection connection;
    private Statement statement;

    public CarDAOImpl() {
    }

    public CarDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private List<CarDomain> getItems(String query, int amount) throws SQLException {
        ResultSet resultSet = null;
        List<CarDomain> cars = new ArrayList<>();
        try {
            if (connection == null) throw new SQLException("No connection to database.");
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet != null) {
                for (int i = 0; i < amount & resultSet.next(); i++) {
                    CarDomain car = new CarDomain(resultSet.getLong("id"),
                            resultSet.getString("number_plate"),
                            resultSet.getString("model"),
                            Car.Color.valueOf(resultSet.getString("color") == null ? "NAN" : resultSet.getString("color")),
                            resultSet.getString("description"),
                            resultSet.getInt("year_of_manufacture"),
                            resultSet.getBigDecimal("rental_price"),
                            resultSet.getBoolean("rented"));
                    cars.add(car);
                }
            }
        } finally {
            DataBaseUtil.closeResultSet(resultSet);
            DataBaseUtil.closeStatement(statement);
            DataBaseUtil.closeConnection(connection);
        }
        logger.info("Get data query occurred.");
        return cars;
    }

    public CarDomain getByModel(String model) throws SQLException {
        String query = "SELECT * FROM car_tb WHERE model='" + model + "'";
        List<CarDomain> cars = getItems(query, ONE);
        return cars.isEmpty() ? null : cars.get(0);
    }
    @Override
    public CarDomain getByNumberPlate(String numberPlate) throws SQLException {
        String query = "SELECT * FROM car_tb WHERE number_plate='" + numberPlate + "'";
        List<CarDomain> cars = getItems(query, ONE);
        return cars.isEmpty() ? null : cars.get(0);
    }

    public List<CarDomain> getAll() throws SQLException {
        String query = "SELECT * FROM car_tb";
        return getItems(query, ALL);
    }

    public CarDomain getById(Long id) throws SQLException {
        String query = "SELECT * FROM car_tb WHERE id=" + id;
        List<CarDomain> cars = getItems(query, ONE);
        return cars.isEmpty() ? null : cars.get(0);
    }

    private void dataChangeQuery(String query) throws SQLException {
        try {
            if (connection == null) throw new SQLException("No connection to database.");
            connection = ConnectionFactory.getInstance().getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } finally {
            DataBaseUtil.closeStatement(statement);
            DataBaseUtil.closeConnection(connection);
        }
        logger.info("Add or change data query occurred.");
    }

    public void add(CarDomain car) throws SQLException {
        String query = "INSERT INTO car_tb(model, color, description, year_of_manufacture, rental_price, rented)" +
                " VALUES ('" + car.getModel() + "', '" + car.getColour() + "', '" + car.getDescription() +
                "', " + car.getYearOfManufacture() + ", " + car.getRentalPrice() + ", " + car.isRented() + ")";
        this.dataChangeQuery(query);
    }

    public void update(CarDomain car) throws SQLException {
        String query = "UPDATE car_tb SET " +
                "model='" + car.getModel() + "', " +
                "color='" + car.getColour() + "', " +
                "description='" + car.getDescription() + "', " +
                "year_of_manufacture=" + car.getYearOfManufacture() + ", " +
                "rental_price=" + car.getRentalPrice() + ", " +
                "rented=" + car.isRented() + " WHERE id=" + car.getId();
        this.dataChangeQuery(query);
    }

    public void remove(CarDomain car) throws SQLException {
        String query = "DELETE FROM car_tb WHERE id=" + car.getId() + " AND " +
                "model='" + car.getModel() + "' AND " +
                "color='" + car.getColour() + "' AND " +
                "description='" + car.getDescription() + "' AND " +
                "year_of_manufacture=" + car.getYearOfManufacture() + " AND " +
                "rental_price=" + car.getRentalPrice() + " AND " +
                "rented=" + car.isRented();
        this.dataChangeQuery(query);
    }
}
