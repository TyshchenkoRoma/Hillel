package com.Hillel;

/**
 * Created by roman on 07.04.16.
 */
public class Model {
    private int valueA;
    private int valueB;

    public int getValueA() {
        return valueA;
    }

    public int getValueB() {
        return valueB;
    }

    public void setValueB(int valueB) {
        this.valueB = valueB;
    }

    public void setValueA(int value) {
        this.valueA = value;
    }


    public int addValue(int a, int b) {
        return a + b;
    }
}
