package ua.hillel.tyshenko.carRental;

import ua.hillel.tyshenko.carRental.model.Car;

import java.math.BigDecimal;

/**
 * Created by roman on 03.08.16.
 */
public class Main {


    public static void main(String[] args) {
        Car car = new Car();
        car.setCarId((long) 1);
        car.setCarModel("Ferrari");
        car.setCarColour(Car.Color.BLACK);
        car.setYearOfManufacture(2012);
        car.setRentPrice(new BigDecimal(2000d));
        car.setDescription("Very fast car! Input car");
        car.setIsRented(true);

          System.out.println(car);

//        CarDAOImpl carDAO = new CarDAOImpl();
//        Car carFromDB = carDAO.getById(2L).getCar();
//
//        List<Car> cars = new ArrayList<Car>();
//        for (CarDomain domain : carDAO.getAll()) {
//            cars.add(domain.getCar());
//        }
//
//        System.out.println(carFromDB);
//        System.out.println("----");
//        System.out.println(Arrays.toString(cars.toArray()));
//
//        carFromDB = carDAO.getByModel("Ford").getCar();
//
//        System.out.println(carFromDB);
    }
}

