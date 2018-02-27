package ua.springboot.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.Car;
import ua.springboot.web.repository.CarRepository;
import ua.springboot.web.service.CarService;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRep;
	@Override
	public void saveCar(Car car) {
		carRep.save(car);
	}

	@Override
	public Car findCarById(int id) {
		return carRep.findOne(id);		
	}

	@Override
	public List<Car> findAllCars() {
		return carRep.findAll();
	}

	@Override
	public Car findCarByModel(String model) {
		return carRep.findCarByModel(model);
	}

}
