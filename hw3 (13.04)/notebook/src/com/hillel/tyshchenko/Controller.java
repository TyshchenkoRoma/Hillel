package com.hillel.tyshchenko;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by roman on 18.04.16.
 */
public class Controller {
    // The Regex
    public static final String REGEX_NAME = "[a-zA-Z]+";
    // Ivanov Ivan Ivanivich
    public static final String REGEX_NICK_NAME = ".+";
    // Ivanov Ivan Ivanivich
    public static final String REGEX_HOME_PHONE = "[^([(]{1}[0-9]{3}[)]{1}[ ]{1}[0-9]{3}[-]{1}[0-9]{4})$]";
    // (555) 555-1212
    public static final String REGEX_MOBILE_PHONE = "(\\\\d{3})-(\\\\d{3})-(\\\\d\\\\d)-(\\\\d\\\\d)";
    public static final String REGEX_MAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    // «nick@mail.com»
    public static final String REGEX_INDEX = "[0-9]{5}";
    //07850
    public static final String REGEX_NUMBER = "[0-9]+";

    // Constructor
    Model model;
    View view;
    Group group;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser() {
        Scanner reader = new Scanner(System.in);
        model.setFirstName(chackForRegex(reader, REGEX_NAME, view.FIRST_NAME));
        model.setSecondName(chackForRegex(reader, REGEX_NAME, view.SECOND_NAME));
        model.setLastName(chackForRegex(reader, REGEX_NAME, view.LAST_NAME));
        model.setFIO(model.FIOBuilder(model.getFirstName())
                + model.FIOBuilder(model.getSecondName())
                + model.FIOBuilder(model.getLastName()));
        model.setNickName(chackForRegex(reader, REGEX_NICK_NAME, view.NICK_NAME));
        model.setComents(chackForRegex(reader, REGEX_NICK_NAME, view.COMENTS));
        printGroupsLine();
        model.setGroup(group.values()[reader.nextInt() - 1]);
        view.concatenationAndPrint(view.CHOUSE_GROUP);
        model.setHomePhoe(chackForRegex(reader, REGEX_HOME_PHONE, view.HOME_PHONE));
        model.setMobilePhoe(chackForRegex(reader, REGEX_MOBILE_PHONE, view.MOBILE_PHONE));
        model.setMail(chackForRegex(reader, REGEX_MAIL, view.EMAIL));
        model.setSkype(chackForRegex(reader, REGEX_MAIL, view.SKYPE));
        model.setIndex(chackForRegex(reader, REGEX_INDEX, view.INDEX));
        model.setTown(chackForRegex(reader, REGEX_NAME, view.TOWN));
        model.setStreet(chackForRegex(reader, REGEX_NAME, view.STREET));
        model.setAppartmentNumber(chackForRegex(reader, REGEX_NUMBER, view.APPARTMBER));
        model.setHouseNumber(chackForRegex(reader, REGEX_NUMBER, view.HOUSE_NUMBER));
        cerateAddressForPostOfficeRules();
        createAddressUsualRule();
        Date date = new Date();
        model.setDataInputValues(String.valueOf(date));
        model.setDataChandgeValues(String.valueOf(date));

    }

    private void printGroupsLine() {
        for (int i = 0; i < Group.values().length; i++) {
            System.out.println(i + 1 + " - " + group.values()[i]);
        }
    }

    private void createAddressUsualRule() {
        view.concatenationAndPrint(model.getTown(), model.getStreet(), model.getHouseNumber(), model.getAppartmentNumber());
    }

    private void cerateAddressForPostOfficeRules() {
        view.concatenationAndPrint(model.getFirstName(), model.getSecondName(), model.getLastName(), "\n",
                model.getStreet(), model.getHouseNumber(), model.getAppartmentNumber(), "\n",
                model.getTown(), "\n",
                model.getIndex());
    }

    private String chackForRegex(Scanner reader, String regex, String notebookParametr) {
        String line = null;
        view.concatenationAndPrint(view.INPUT, notebookParametr);
        while (reader.hasNext()) {
            line = reader.nextLine();
            if (line.matches(regex)) {
                break;
            } else {
                view.concatenationAndPrint(view.WRONG_INPUT, notebookParametr);
            }
        }
        return line;
    }
}
