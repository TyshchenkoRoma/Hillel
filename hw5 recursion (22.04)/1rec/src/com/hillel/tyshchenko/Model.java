package com.hillel.tyshchenko;

/**
 * Created by roman on 25.04.16.
 */
public class Model {

    int[] array = {1, 2, 3, 4, 5};
    private int index = array.length - 1;

    public int getIndex() {
        return index;
    }

    public static int fact(int array[], int index) {
        if (index == 0) {
            return array[0];
        }
        return array[index] + fact(array, index - 1);
    }
}
