package ua.hillel.tyshenko.carRental.data.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by roman on 03.08.16.
 */
public class DbUtil {

    static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DbUtil.class);

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Connection didn't close.");
                logger.error(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error("Statement didn't close.");
                logger.error(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                logger.error("Result Set didn't close.");
                logger.error(Arrays.toString(e.getStackTrace()));
            }
        }
    }
}
