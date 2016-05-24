package com.hillel.tyshchenko;

/**
 * Created by roman on 23.05.16.
 */
public abstract class Vehicle1 {
    String model;
    String registrationNumber;

    public Vehicle1(String model, String registrationNumber) {
        this.model = model;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle1)) return false;

        Vehicle1 vehicle1 = (Vehicle1) o;

        if (model != null ? !model.equals(vehicle1.model) : vehicle1.model != null) return false;
        return !(registrationNumber != null ? !registrationNumber.equals(vehicle1.registrationNumber) : vehicle1.registrationNumber != null);

    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle1{" +
                "model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
