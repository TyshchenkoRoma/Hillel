package ua.hillel.tyschenko.carrental.model.entity;

/**
 * Created by roman on 29.07.16.
 */
public class Car {
    public static void main(String[] args) {

        System.out.println("TEST for working Maven project" );
    }
    private String carModel;
    CarColour carColour;
    private String description;
    private int yearOfManufacture;
    private int rentPrice;
    private int carId;


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
        return result;
    }


    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", carId=" + carId +
                ", carColour=" + carColour +
                ", description='" + description + '\'' +
                ", yearOfManufacrure=" + yearOfManufacture +
                ", rentPrice=" + rentPrice +
                '}';
    }

    public enum CarColour {WHITE, BLACK, RED, YELLOW, BLUE};
}

