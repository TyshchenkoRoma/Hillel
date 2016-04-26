package com.Hillel;

/**
 * Created by roman on 07.04.16.
 */
public class View {
    public static final String INPUT_VALUE = "Input INT value!";
    public static final String RESULT = "Addind result = ";
    public static final String WRONG_ONPUT = "Wrong value please input INT value ";


    public void printMessege(String massage) {
        System.out.println(massage + " ");
    }

    public void printResult(String massege, int result) {
        System.out.println(massege + " " + result);
    }
}
