package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class Model {
    int array [] = {1, 2, 0, 0, 0, 6};

    public int count(int array[]) {
        int count = 0;
        for (int i : array) {
            if (0 == i) {
                count++;
            }
        }
        return count;
    }
}
