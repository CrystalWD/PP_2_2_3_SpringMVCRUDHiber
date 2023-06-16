package MVC.service;

import MVC.models.Car;


import java.util.Arrays;
import java.util.List;

public class CarServiceImp implements CarService {

    List<Car> carList = Arrays.asList(
            new Car("Toyota", 32323, "Fingolfin"),
            new Car("Honda", 21213, "Turin"),
            new Car("Ford", 5542, "Gandalf"),
            new Car("Chevrolet", 1123, "Nienor"),
            new Car("Tesla", 123, "John")
    );

    @Override
    public List<Car> getCarList(int count) {
        if (count > carList.size()) {
            throw new IllegalArgumentException("NonData");
        }
        return carList.subList(0, count);
    }
}
