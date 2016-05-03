package com.hillel.tyshchenko;

/**
 * Created by roman on 03.05.16.
 */
public class Model {

    public static int[] getZero() {
        int array[] = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 1; i < array.length; i += 2) {
            array[i] = 0;
        }
        return array;
    }
}
