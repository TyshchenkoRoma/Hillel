package com.hillel;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        double a = 0;
        double b = 0;
        double c = 0;
        SquareEquation squareEquation = new SquareEquation(a,b,c);
        System.out.println(Arrays.toString(squareEquation.solve()));

    }
}
