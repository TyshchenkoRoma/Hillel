package ua.hillel.tyshenko.carRental.data.dao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by roman on 17.08.16.
 */
public class DateUtil {
    public static java.sql.Date getSQLFormatDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public static Date getSimpleFormatDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
