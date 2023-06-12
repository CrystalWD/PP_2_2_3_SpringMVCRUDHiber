package service;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public interface CarService {
    List<Car> getCarList(int count);
}
