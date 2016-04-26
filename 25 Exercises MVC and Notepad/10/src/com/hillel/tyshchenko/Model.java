package com.hillel.tyshchenko;

/**
 * Created by roman on 26.04.16.
 */
public class Model {
    int array [] = {1, 2, 3, 4, 5, 6};
    public  int[] getZiroArrays() {

        for (int i = 0; i < array.length; i++ ) {
            if (i%2==0) {
                array[i] = 0;
            }}
        return array;
    }
}
