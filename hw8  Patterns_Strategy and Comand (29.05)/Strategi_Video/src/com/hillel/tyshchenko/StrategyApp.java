package com.hillel.tyshchenko;

import java.util.Arrays;

/**
 * Created by roman on 30.05.16.
 */
public class StrategyApp {
    public static void main(String[] args) {
StrategyCkient  c= new StrategyCkient();

        int [] array0 = {10, 5, 9, 1};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(array0);

        int [] array1 = {110, 15, 19, 11};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(array1);

        int [] array2 = {210, 25, 29, 21};
        c.setStrategy(new InsertingSort());
        c.executeStrategy(array2);

    }
}

// Context
class StrategyCkient {
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] array) {
        strategy.sort(array);
    }

}

// Strategy
interface Sorting {
    void sort(int[] array);
}

class BubbleSort implements Sorting {
    public void sort(int[] array) {
        System.out.println("Bubble Sorting");
        System.out.println("before:\t " + Arrays.toString(array));
        for (int barier = array.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        System.out.println("After:\t " + Arrays.toString(array)+"\n");
    }
}

class SelectionSort implements Sorting {
    public void sort(int[] array) {
        System.out.println("Selec Sort");
        System.out.println("before:\t " + Arrays.toString(array));
        for (int barier = 0; barier < array.length; barier++) {
            for (int i = barier + 1; i < array.length; i++) {
                if (array[i] < array[barier]) {
                    int temp = array[i];
                    array[i] = array[barier];
                    array[barier] = temp;
                }
            }
        }
        System.out.println("After:\t " + Arrays.toString(array)+"\n");
    }
}
// Inserting sorting strategi
class InsertingSort implements Sorting {
    public void sort(int[] array) {
        System.out.println("Inserting Sorting");
        System.out.println("before:\t " + Arrays.toString(array));
        for (int barier = 1; barier < array.length; barier++) {
            int index = barier;
            while (index - 1 >= 0 && array[index] < array[index - 1]) {
                int temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
        System.out.println("After:\t " + Arrays.toString(array)+"\n");
    }
}