package com.hillel.tyshchenko;

/**
 * Created by roman on 18.04.16.
 */
public class View {
    // Text's constants
    public static final String INPUT = "Input  ";
    public static final String WRONG_INPUT = "Wrong input  ";
    public static final String FIRST_NAME = "first name for example (Ivan)  ";
    public static final String SECOND_NAME = "second name for example (Ivanov)  ";
    public static final String LAST_NAME = "last name for example (Ivanovich)  ";
    public static final String NICK_NAME = "nickname  ";
    public static final String COMENTS = "coments   ";
    public static final String CHOUSE_GROUP = "Choice one of group   ";
    public static final String HOME_PHONE = "home phone in format (555) 555-1212  ";
    public static final String MOBILE_PHONE = "mobile phonephone in format 063 747 92 75  ";
    public static final String EMAIL = "email  ";
    public static final String SKYPE = "skype  ";
    public static final String INDEX = "index  ";
    public static final String TOWN = "town  ";
    public static final String STREET = "street ";
    public static final String HOUSE_NUMBER = "number of house ";
    public static final String APPARTMBER = "number of appartments ";


    public void concatenationAndPrint(String... message) {
        StringBuffer concatString = new StringBuffer();
        for (String v : message) {
            concatString = concatString.append(v);
        }
        System.out.println(concatString);
    }


}
