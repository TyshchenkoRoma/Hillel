package com.hillel.tyshchenko;

/**
 * Created by roman on 24.04.16.
 */
public class Mobel {

    int number = 2;

    public int[] multiplication() {
        int[] array = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            array[i] *= number;
        }
        return array;
    }
}