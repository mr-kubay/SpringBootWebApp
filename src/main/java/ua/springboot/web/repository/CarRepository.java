package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{

	@Query("SELECT c FROM Car c WHERE c.model = :model")
	Car findCarByModel(@Param("model") String model);
}