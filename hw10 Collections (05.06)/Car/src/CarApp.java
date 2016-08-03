import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by roman on 06.06.16.
 */
public class CarApp {
    public static void main(String[] s) {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Mersedes", "A170", 1.5, 100, 5));
        cars.add(new Car("Renault", "Kangu", 5, 110, 4));
        cars.add(new Car("Opel", "Vivaro", 4, 80, 6));
        cars.add(new Car("Hunday", "Acent", 0.7, 120, 5));
        cars.add(new Car("Suzuki", "Swift", 1.1, 100, 15));
        cars.add(new Car("Pegeot", "Boxer", 2, 50, 8));
        System.out.println(cars);
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.manufacturer.compareTo(o2.manufacturer);
            }
        });
        System.out.println(cars);
        cars.sort(Comparator.comparing(Car::getManufacturer).thenComparing(Car::getModel));
        System.out.println(cars);
    }
}

class Car {
    String manufacturer;
    String model;
    int price;
    int hp;
    double fuelConsumption;

    public Car(String manufacturer, String model, double fuelConsumption, int hp, int price) {
        this.manufacturer = manufacturer;
        this.fuelConsumption = fuelConsumption;
        this.hp = hp;
        this.model = model;
        this.price = price;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{" +
                manufacturer + '\'' +
                model + '\'' +
                +price + '\'' +
                hp + '\'' +
                fuelConsumption +
                '}';
    }

}