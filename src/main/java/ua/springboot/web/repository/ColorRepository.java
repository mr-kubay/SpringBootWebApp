package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer>{

}
