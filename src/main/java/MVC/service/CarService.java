package MVC.service;

import MVC.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarList(int count);
}
