package com.hillel.tyshchenko;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int numberVehicl = 0;
        int numberTracks = 0;
        int numberMotorcycles = 0;
        Motorcycle motorcycle = new Motorcycle("YAMAHA", "СА 234-34 В)");
        Vehicle1 vehicles[] = {new Motorcycle("YAMAHA", "mm)"), new Motorcycle("YAMAHA", "СА 234-34 В)"),
                new Motorcycle("YAMAHA", "СА 234-34 В)"), new Truck("MAN", "CD 123", 100),
                new Truck("CD 124", "MAGNUM", 200)};
        System.out.println(Arrays.toString(vehicles));
        for (Vehicle1 vehicle : vehicles) {

            if (vehicle instanceof Vehicle1) {
                numberVehicl++;
            }
            if (vehicle instanceof Truck) {
                numberTracks++;
            }
            if (vehicle.hashCode() == motorcycle.hashCode()) {
                numberMotorcycles++;
            }
        }
        System.out.println("number of Vehicles is: " + numberVehicl + "\nnumber of truks is: " + numberTracks +
                "\nnumber of Motorcycle YAMAHA, СА 234-34 В is: " + numberMotorcycles);
    }
}

