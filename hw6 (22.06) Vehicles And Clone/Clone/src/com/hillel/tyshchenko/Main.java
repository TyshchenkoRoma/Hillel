package com.hillel.tyshchenko;

public class Main {

    public static void main(String[] args) {
        Point point = new Point(1, 1);
        Rectangle rectangle = new Rectangle(2, 3, 4, 5);
        Point point1 = point.clone();
        Rectangle rectangle1 = rectangle.clone();
        System.out.println(rectangle1);
        rectangle1.setLeftTop(point1);
        System.out.println(rectangle1);
    }
}
