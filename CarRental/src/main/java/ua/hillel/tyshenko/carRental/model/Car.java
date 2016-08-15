package ua.hillel.tyshenko.carRental.model;

import java.math.BigDecimal;

/**
 * Created by roman on 29.07.16.
 */
public class Car {

    private String carModel;
    private Colour Colour;
    private String description;
    private int yearOfManufacture;
    private BigDecimal rentPrice;
    private Long carId;
    private boolean isRented;

    public Car() {
    }

    public Car(BigDecimal rentPrice, String carModel, Car.Colour colour, String description, int yearOfManufacture, Long carId, boolean isRented) {
        this.rentPrice = rentPrice;
        this.carModel = carModel;
        Colour = colour;
        this.description = description;
        this.yearOfManufacture = yearOfManufacture;
        this.carId = carId;
        this.isRented = isRented;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Colour getColour() {
        return Colour;
    }

    public void setCarColour(Colour carColour) {
        this.Colour = carColour;
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

    public void setYearOfManufacture(int yearOfIssue) {
        this.yearOfManufacture = yearOfIssue;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carName) {
        this.carModel = carName;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }



    @Override
    public int hashCode() {
        int result = getCarModel() != null ? getCarModel().hashCode() : 0;
        result = 31 * result + getCarId().hashCode();
        result = 31 * result + (getColour() != null ? getColour().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getYearOfManufacture();
        result = 31 * result + getRentPrice().hashCode();
        result = 31 * result + (isRented() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", carColour=" + Colour +
                ", description='" + description + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", rentPrice=" + rentPrice +
                ", carId=" + carId +
                ", isRented=" + isRented +
                '}';
    }

    public enum Colour {WHITE, BLACK, RED, YELLOW, BLUE};
}

