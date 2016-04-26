package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class Model {
    int array[] = {1, 2, 3, 4, 5};

    public int getMiddleRange(int array[]) {
        int sum = 0;
        int middleRange = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        middleRange = sum / array.length;

        return middleRange;
    }
}
