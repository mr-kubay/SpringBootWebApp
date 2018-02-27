package ua.springboot.web.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.springboot.web.entity.User;
import ua.springboot.web.repository.UserRepository;
import ua.springboot.web.validation.annotation.Personal;

@Component
public class PersonalValidator implements ConstraintValidator<Personal, User>{

	@Autowired
	private UserRepository userRep;
	@Override
	public void initialize(Personal arg0) {
		
	}

	@Override
	public boolean isValid(User user, ConstraintValidatorContext arg1) {
		if(userRep.findUser(user.getName(), user.getSurname(), user.getEmail())!=null) {
			return false;
		} else return true;
	}

}
