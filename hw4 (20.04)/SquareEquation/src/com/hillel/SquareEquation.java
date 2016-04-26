package com.hillel;

/**
 * Created by User on 20.04.2016.
 */
public class SquareEquation {
    double coeficientA;
    double coeficientB;
    double coeficientC;


    public SquareEquation(double coeficientA, double coeficientB, double coeficientC) {
        this.coeficientA = coeficientA;
        this.coeficientB = coeficientB;
        this.coeficientC = coeficientC;
    }
    int i;
    double rezult[];

    public double[] solve() {
        if (coeficientA == 0.) {
            throw new IllegalArgumentException(" a = 0!");
        }
        double d = coeficientB * coeficientB - 4 * coeficientA * coeficientC;
        if (d < 0) {
            return new double[]{};
        }
        if (d == 0) {
            i=1;
            rezult = new double[1];
            rezult[0]= -coeficientB/(2 * coeficientA);

        }
        if (d > 0) {
           rezult = new double[2];
            rezult[0] = (-coeficientB + Math.sqrt(d)) / (2 * coeficientA);
            rezult[1] = (-coeficientB - Math.sqrt(d)) / (2 * coeficientA);
        }
        return rezult;
    }
}