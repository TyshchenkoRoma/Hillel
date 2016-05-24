package com.hillel.tyshchenko;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;

/**
 * Created by User on 07.04.2016.
 */
public class Point implements Cloneable{

    private double x;
    private double y;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
public Point addAllParameters (Point point){
    setX(point.getX()+10);
    setY(point.getY()+10);
        return point;
    }
    public double getX() {
        return x;
    }

    public void setX(double x) {

        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {

        this.y = y;
    }

    @Override
    public Point clone()  {
        try {
            Point temp = (Point)super.clone();
         //   TODO  ????????????????????????????????????
            return temp;

        }catch( CloneNotSupportedException ex){
            return null;
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
