package com.hillel.tyshchenko;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Point point = new Point(1, 1);
        Rectangle rectangle = new Rectangle(2, 3, 4, 5);
        int array[] = {1, 2, 3, 4, 5, 6, 7};
        Point arrayPoints[] = {new Point(0, 0), new Point(1, 1), new Point(2, 2), new Point(3, 3)};

        Point arrayPointsClone[] = arrayPoints.clone();
        Point point1 = point.clone();
        Rectangle rectangle1 = rectangle.clone();
        int array1[] = array.clone();

        System.out.println(" point is: " + point + "  rectangle is: " + rectangle);
        System.out.println("point1 is: " + point1 + " rectangle1 is: " + rectangle1);
        System.out.println(Arrays.toString(array) + "\n" + Arrays.toString(array1));
        System.out.println(Arrays.toString(arrayPoints) + "\n" + Arrays.toString(arrayPointsClone));

        point1.setX(0);
        point1.setY(0);
        rectangle1.setLeftTop(point1);
        for (int i = 0; i < array1.length; i++) {
            array1[i] *= 2;
        }
        for (int i = 0; i < arrayPointsClone.length; i++) {
            arrayPointsClone[i]= arrayPointsClone[i].addAllParameters(arrayPointsClone[i]) ;
        }


        System.out.println("\n point is: " + point + "  rectangle is: " + rectangle);
        System.out.println("point1 is: " + point1 + " rectangle1 is: " + rectangle1);
        System.out.println("point1 is: " + point1 + " rectangle1 is: " + rectangle1);
        System.out.println(Arrays.toString(array) + "\n" + Arrays.toString(array1));
        System.out.println(Arrays.toString(arrayPoints) + "\n" + Arrays.toString(arrayPointsClone));

    }
}
