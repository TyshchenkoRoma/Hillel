package com.hillel.tyshchenko;

/**
 * Created by roman on 25.04.16.
 */
public class Model {

    private int array[] = {1, 3, 5, 7, 9};
    private int value = 3;

    public int[] getArray() {
        return array;
    }

    public int getValue() {
        return value;
    }

    // The Work method
    public static int binarySearchRecursion(int[] array, int val) {
        int from = 0;
        int to = array.length;
        int middle = (to - from) / 2;
        if (val == array[middle])
            return middle;
        if (val < array[middle]) {
            to = middle;
            return binarySearchRecursion(array, val);
        }
        if (val > array[middle]) {
            from = middle;
            return binarySearchRecursion(array, val);
        } else {
            return -1;

        }
    }
}
