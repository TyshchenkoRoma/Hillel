package com.hillel.tyshchenko;

/**
 * Created by roman on 26.04.16.
 */
public class Model {
    public int[] array = {1, -5, 5, -6, 7, -100};
    private int count = 0;
    private int index = 0;

    public int getCount() {
        return count;
    }

    public int getIndex() {
        return index;
    }

    public static int countElMorZero(int[] array, int counter, int index) {
        if (index == array.length - 1) {
            return counter;
        }
        if (array[index] > 0) {
            counter++;
        }
        return countElMorZero(array, counter, index + 1);
    }
}
