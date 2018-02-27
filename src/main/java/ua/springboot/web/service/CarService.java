package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.Car;

public interface CarService {
	void saveCar(Car car);
	Car findCarById(int id);
	List<Car> findAllCars();
	Car findCarByModel(String model);
}
