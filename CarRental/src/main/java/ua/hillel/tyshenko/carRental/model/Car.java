package ua.hillel.tyshenko.carRental.model;

import java.math.BigDecimal;

/**
 * Created by roman on 29.07.16.
 */
public class Car {

    private String carModel;
    private String numberPlate;
    private Color colour;
    private String description;
    private int yearOfManufacture;
    private BigDecimal rentPrice;
    private Long carId;
    private boolean isRented;

    public Car() {
    }

    public Car(BigDecimal rentPrice,   String numberPlate, String carModel, Car.Color colour, String description, int yearOfManufacture, Long carId, boolean isRented) {
        this.rentPrice = rentPrice;
        this.numberPlate = numberPlate;
        this.carModel = carModel;
        this.colour = colour;
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

    public Color getColour() {
        return colour;
    }

    public void setCarColour(Color carColour) {
        this.colour = carColour;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carId != car.carId) return false;
        if (yearOfManufacture != car.yearOfManufacture) return false;
        if (isRented != car.isRented) return false;
        if (!numberPlate.equals(car.numberPlate)) return false;
        if (carModel != null ? !carModel.equals(car.carModel) : car.carModel != null) return false;
        if (colour != car.colour) return false;
        if (description != null ? !description.equals(car.description) : car.description != null) return false;
        return !(rentPrice != null ? !rentPrice.equals(car.rentPrice) : car.rentPrice != null);
    }

    @Override
    public int hashCode() {
        int result = (int) (carId ^ (carId >>> 32));
        result = 31 * result + numberPlate.hashCode();
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        result = 31 * result + (colour != null ? colour.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + yearOfManufacture;
        result = 31 * result + (rentPrice != null ? rentPrice.hashCode() : 0);
        result = 31 * result + (isRented ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + carId +
                ", numberPlate='" + numberPlate + '\'' +
                ", model='" + carModel + '\'' +
                ", color=" + colour +
                ", description='" + description + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", rentalPrice=" + rentPrice +
                ", rented=" + isRented +
                '}';
    }

    public enum Color {NAN, WHITE, BLACK, GREY, RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE, PINK, BROWN, GOLD, SILVER, BRONZE}
}
