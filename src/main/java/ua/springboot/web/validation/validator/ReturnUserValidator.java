package ua.springboot.web.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.springboot.web.entity.User;
import ua.springboot.web.repository.UserRepository;
import ua.springboot.web.validation.annotation.ReturnUser;

@Component
public class ReturnUserValidator implements ConstraintValidator<ReturnUser, User>{

	@Autowired
	private UserRepository userRep;

	@Override
	public void initialize(ReturnUser arg0) {
		
	}

	@Override
	public boolean isValid(User user, ConstraintValidatorContext arg1) {
		if(userRep.returnUser(user.getLogin(), user.getPassword()) == null) {
			return false;
		}
		else return true;
	}

}
