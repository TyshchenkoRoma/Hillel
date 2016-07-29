package ua.hillel.tyschenko.carrental;

/**
 * Created by roman on 29.07.16.
 */
public class Car {
    public static void main(String[] args) {
        System.out.println("TEST for working Maven project ");
    }
    private String carName;
    private int carId;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public int hashCode() {
        return carName.hashCode();
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", carId=" + carId +
                '}';
    }
}
