package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class Model {

    int array[] = {3, 5, 6, 1, 8};
    int min = array[0];
    int index = 0;

    public int getMin(int array[], int min) {
        for (int i : array) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public int getMinIndex(int array[], int min) {
        for (int i = 0; i < array.length; i++) {
            if (min == array[i]) {
                index = i;
            }
        }
        return index;
        // System.out.println("min index =  " + index +  "min value = " + min);
    }
}