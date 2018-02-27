package ua.springboot.web.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.springboot.web.service.CarService;
import ua.springboot.web.validation.annotation.UniqueCarModel;

@Component
public class UniqueCarModelValidator implements ConstraintValidator<UniqueCarModel, String>{

	@Autowired
	private CarService carService;
	
	@Override
	public void initialize(UniqueCarModel arg0) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if(value == null) return false;
		
		if(carService.findCarByModel(value)!=null) { 
			return false; 
		} else return true;
	}
}

	

