package com.hillel.tyshchenko;

/**
 * Created by roman on 23.05.16.
 */
public class Motorcycle extends Vehicle1 {


    public Motorcycle(String model, String registrationNumber) {
        super(model, registrationNumber);
    }

    @Override
    public String toString() {
        return "Motorcycle: {" +"model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
