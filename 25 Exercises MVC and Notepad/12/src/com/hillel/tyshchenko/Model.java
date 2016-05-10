package com.hillel.tyshchenko;

/**
 * Created by roman on 10.05.16.
 */
public class Model {

    int array[] = {-4, -9, -4, -1, 8 - 4, 10};
    int i;

    public int getPositiveValue(int array[]) {
        for (i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                break;
            }
        }
        return array[i];
    }
}

