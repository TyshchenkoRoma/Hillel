package com.hillel.tyshchenko;

/**
 * Created by roman on 10.05.16.
 */
public class Model {
    int number = 0;
    int givenEl = 7;
    int array[] = {1, 2, 3, 7, 4, 7, 8, 7};

    public int getNumberEl(int array[]) {
        for (int i = 0; i < array.length; i++) {
            if (givenEl == array[i]) {
                number++;
            }
        }
        return number;
    }
}
