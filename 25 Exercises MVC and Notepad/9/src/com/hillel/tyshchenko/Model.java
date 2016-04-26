package com.hillel.tyshchenko;

/**
 * Created by roman on 25.04.16.
 */
public class Model {
    // The Program logic
    public static int[] getArrayAddIndex() {
        int[] array = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            array[i] += i;
        }
        return array;
    }
}
