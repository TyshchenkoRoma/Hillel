package com.hillel.tyshchenko;

public class Main {

    public static void main(String[] args) {
        int input = 6;
        System.out.println(fact(input));
    }

    public static double fact(double inputValues) {
        if (inputValues <= 1) {
            return 1;
        }
        return inputValues * fact(inputValues - 1);
    }
}

