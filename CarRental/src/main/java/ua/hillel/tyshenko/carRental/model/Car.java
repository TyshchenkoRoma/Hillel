package ua.hillel.tyshenko.carRental.model;

import java.math.BigDecimal;

/**
 * Created by roman on 29.07.16.
 */
public class Car {

    private String carModel;
    private String numberPlate;
    private Color color;
    private String description;
    private int yearOfManufacture;
    private BigDecimal rentPrice;
    private Long carId;
    private boolean isRented;

    public Car() {
    }

    public Car( String numberPlate, BigDecimal rentPrice, String carModel, Car.Color colour, String description, int yearOfManufacture, Long carId, boolean isRented) {
        this.rentPrice = rentPrice;
        this.carModel = carModel;
        this.numberPlate = numberPlate;
        this.color = colour;
        this.description = description;
        this.yearOfManufacture = yearOfManufacture;
        this.carId = carId;
        this.isRented = isRented;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public boolean isIsRented() {
        return isRented;
    }

    public void setIsRented(boolean rented) {
        isRented = rented;
    }

    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Color getColour() {
        return color;
    }

    public void setCarColour(Color carColour) {
        this.color = carColour;
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
        int result = (int) (carId ^ (carId >>> 32));
        result = 31 * result + numberPlate.hashCode();
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + yearOfManufacture;
        result = 31 * result + (rentPrice != null ? rentPrice.hashCode() : 0);
        result = 31 * result + (isRented ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                "numberPlate" + numberPlate + '\'' +
                ", carColor=" + color +
                ", description='" + description + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", rentPrice=" + rentPrice +
                ", carId=" + carId +
                ", isIsRented=" + isRented + "+" +
                '}';
    }

    public enum Color {NAN, WHITE, BLACK, GREY, RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE, PINK, BROWN, GOLD, SILVER, BRONZE}
}

