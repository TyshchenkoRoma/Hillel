package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class Model {
    int value = 4;
    int array[] = {1, 2, 3, 4, 4, 4, 5, 6};

    public int countValues(int array[]) {
        int count = 0;
        for (int i : array) {
            if (value == i) {
                count++;
            }
        }
        return count;
    }
}
