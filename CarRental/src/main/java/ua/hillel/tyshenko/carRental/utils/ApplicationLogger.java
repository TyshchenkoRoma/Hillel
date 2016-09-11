package ua.hillel.tyshenko.carRental.utils;

import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Logger;

/**
 * Created by roman on 17.08.16.
 */
public class ApplicationLogger {
    private static final String LOGGER_PROPERTY_FILE = getRootApplicationPath("/WEB-INF/classes/log4j.properties");
    private static boolean init = false;

    public static org.apache.log4j.Logger getLogger(Class clazz) {
        if (!init) {
            System.setProperty("app.root", getRootApplicationPath(""));
            PropertyConfigurator.configure(LOGGER_PROPERTY_FILE);
            org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ApplicationLogger.class);
            logger.info("   ---==   START LOGGER SESSION   ==---");
            logger.info("Logger configured.");
            init = true;
        }
        return org.apache.log4j.Logger.getLogger(clazz);
    }

    private static String getRootApplicationPath(String fileName) {
        String path =  ApplicationLogger.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String fullPath = "";
        try {
            fullPath = URLDecoder.decode(path, "UTF-8");
            String[] pathArr = fullPath.split("/WEB-INF/classes/");
            fullPath = pathArr[0];
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return new File(fullPath).getPath() + fileName;
    }
}
