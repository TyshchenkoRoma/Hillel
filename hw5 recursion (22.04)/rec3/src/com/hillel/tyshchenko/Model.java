package com.hillel.tyshchenko;

/**
 * Created by roman on 25.04.16.
 */
public class Model {

    int[] array = {11, 2, 1, 3, -4, 5, 8};
    private int index = array.length - 1;
    private int indexMinEL = 0;
    private int minEl = array[0];

    public int getIndex() {
        return index;
    }

    public int getMinEl() {
        return minEl;
    }

    public void setMinEl(int minEl) {
        this.minEl = minEl;
    }

    public int getIndexMinEL() {
        return indexMinEL;
    }


    public int min(int array[], int index, int minEl) {
        if (index == 0) {
            return minEl;
        }
        if (minEl < array[index]) {
            return min(array, index - 1, minEl);
        } else {
            minEl = array[index];
            return min(array, index - 1, minEl);
        }
    }

    public int findIndexMinEl(int array[], int minEl, int indexMinEl) {
        if (minEl == array[indexMinEl]) {
            return indexMinEl;
        }
        return findIndexMinEl(array, minEl, indexMinEl + 1);
    }
}
