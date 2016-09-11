package ua.hillel.tyshenko.carRental.model.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by roman on 30.08.16.
 */
public class PasswordHelper {
    // Password encoding sample for filling DB testing items
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException
    {
        String passwordToHash = "mandy#12!d";

        String securePassword = getSecurePassword(passwordToHash);
        System.out.println(securePassword);
    }

    public static String getSecurePassword(String passwordToHash) {
        String generatedPassword = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest(passwordToHash.getBytes());
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                builder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
