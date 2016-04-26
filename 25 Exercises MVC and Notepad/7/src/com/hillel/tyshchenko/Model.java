package com.hillel.tyshchenko;

/**
 * Created by roman on 22.04.16.
 */
public class Model {

    int array[] = {1, 2, 3, 4, -6, -4};

    public int getCount(int[] array) {
        int count = 0;
        for (int s : array) {
            if (s > 0) {
                count++;
            }
        }
        return count;
    }
}
