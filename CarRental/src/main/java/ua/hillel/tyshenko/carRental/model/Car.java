package ua.hillel.tyshenko.carRental.model;

/**
 * Created by roman on 29.07.16.
 */
public class Car {

    private String carModel;
    CarColour carColour;
    private String description;
    private int yearOfManufacture;
    private int rentPrice;
    private int carId;
    private boolean isRented;

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int rentPrice) {
        this.rentPrice = rentPrice;
    }

    public CarColour getCarColour() {
        return carColour;
    }

    public void setCarColour(CarColour carColour) {
        this.carColour = carColour;
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

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }



    @Override
    public int hashCode() {
        int result = getCarModel() != null ? getCarModel().hashCode() : 0;
        result = 31 * result + getCarId();
        result = 31 * result + (getCarColour() != null ? getCarColour().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + getYearOfManufacture();
        result = 31 * result + getRentPrice();
        result = 31 * result + (isRented() ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", carColour=" + carColour +
                ", description='" + description + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", rentPrice=" + rentPrice +
                ", carId=" + carId +
                ", isRented=" + isRented +
                '}';
    }

    public enum CarColour {WHITE, BLACK, RED, YELLOW, BLUE};
}

