package com.hillel.tyshchenko;


/**
 * Created by roman on 18.04.16.
 */
public class Model {
    private String firstName;
    private String secondName;
    private String lastName;
    private String FIO;
    private String nickName;
    private String coments;
    private String homePhoe;
    private String mobilePhoe;
    private String skype;
    private String index;
    private String town;
    private String street;
    private String houseNumber;
    private String appartmentNumber;
    private String dataInputValues;
    private String dataChandgeValues;
    private String group;
    private String mail;

    public void setDataChandgeValues(String dataChandgeValues) {
        this.dataChandgeValues = dataChandgeValues;
    }

    public void setGroup(Group group) {
        this.group = group.toString();
    }

    public void setDataInputValues(String dataInputValues) {
        this.dataInputValues = dataInputValues;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(String appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setHomePhoe(String homePhoe) {
        this.homePhoe = homePhoe;
    }

    public void setMobilePhoe(String mobilePhoe) {
        this.mobilePhoe = mobilePhoe;
    }

    public void setComents(String coments) {
        this.coments = coments;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    /**
     * this metod  return  first letter
     * from "name" in Upper Case and add "."
     */
    protected String FIOBuilder(String name) {
        return String.valueOf(firstName.charAt(0)).toUpperCase() + ".";
    }
}
