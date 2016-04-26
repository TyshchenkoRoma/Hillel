package com.hillel.tyshchenko;

/**
 * Created by roman on 21.04.16.
 */
public class Model {
    int array[] = {1, 2, 3, 4, 5};

    public int getSumArray(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
        return sum;
    }
}
