package com.Hillel.tyshchenko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    private int minBarier = 0;
    private int maxBarier = 100;
    int secretValue;

    public Model() {
        secretValue = getRandValue();
    }

    private List<Integer> inputValueList = new ArrayList<Integer>();

    public List<Integer> getInputValueList() {
        return inputValueList;
    }

    public int getMaxBarier() {
        return maxBarier;
    }

    public int getMinBarier() {
        return minBarier;
    }

    // The Program logic
    private int getRandValue() {
        Random r = new Random();
        return r.nextInt(maxBarier - 1) - 1;
    }

    /**
     * this metod comparing  randValue and  inputValue
     * and write inputValue to minBarier or maxBarier
     * depending from rezult
     *
     * @param inputValue input value
     */
    public void comparindValues(int inputValue) {
        inputValueList.add(inputValue);
        if (inputValue < secretValue) {
            minBarier = inputValue;
        } else {
            maxBarier = inputValue;
        }
    }

    /**
     * this method takes random value, and input value
     * eaquals them, and return true if them are eaquals and false if
     * them not eaquals for exit whis cycle
     *
     * @param inputValue input value
     */
    public boolean usersWin(int inputValue) {
        if (inputValue == secretValue) {
            return true;
        }
        return false;
    }
}


