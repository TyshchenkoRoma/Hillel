package com.Hillel.tyshchenko;

import java.util.Arrays;

/**
 * Created by roman on 10.04.16.
 */
public class View {
    public static String ASK = "Please input values";
    public static final String INPUT_VALUES = "Your values:";
    public static final String MIDDLE  ="Middle range";
    public static final String NEAR_INT = "The nearer to middle int value is: ";

    public void printMessageAndArray(String s, int array[]) {
        System.out.println(s + " " + Arrays.toString(array));
    }
    public void printMessage (String s) {
        System.out.println(s);
    }
    public void printMessageAndInt(String s, int m) {
        System.out.println(s + m);
    }
    public void printMessageAndDoubl(String s, double i) {
        System.out.println(s + " " + i);
    }
}

