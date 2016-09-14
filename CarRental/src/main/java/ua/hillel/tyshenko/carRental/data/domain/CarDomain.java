package ua.hillel.tyshenko.carRental.data.domain;

import ua.hillel.tyshenko.carRental.model.Car;

import java.math.BigDecimal;

/**
 * Created by roman on 03.08.16.
 */
public class CarDomain extends AbstractDomain {
    private String numberPlate;
    private String model;
    private Car.Colour colour;
    private String description;
    private int yearOfManufacture;
    private BigDecimal rentalPrice;
    private boolean rented;

    public CarDomain( String numberPlate, Long id, String model, Car.Colour colour, String description, int yearOfManufacture, BigDecimal rentalPrice, boolean rented) {
        super(id);
        this.numberPlate = numberPlate;
        this.model = model;
        this.colour = colour;
        this.description = description;
        this.yearOfManufacture = yearOfManufacture;
        this.rentalPrice = rentalPrice;
        this.rented = rented;
    }
    public Car getCar() {
        return new Car(this.numberPlate, this.rentalPrice,   this.model, this.colour,   this.description, this.yearOfManufacture, this.getId(),
                 this.rented);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Car.Colour getColour() {
        return colour;
    }

    public void setColour(Car.Colour colour) {
        this.colour = colour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public BigDecimal getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

}
