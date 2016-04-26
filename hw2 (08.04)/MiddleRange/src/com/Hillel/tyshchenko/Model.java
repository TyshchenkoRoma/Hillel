package com.Hillel.tyshchenko;

/**
 * Created by roman on 10.04.16.
 */
public class Model {
    public double findMiddleValue(int[] arrayInputValues) {
        int sum = 0;
        for (int i : arrayInputValues) {
            sum= sum+i;
        }
        double middleValue =(double) sum /arrayInputValues.length;
        return middleValue;
    }
}
