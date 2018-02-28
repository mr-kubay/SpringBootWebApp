package ua.springboot.web.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.springboot.web.entity.User;
import ua.springboot.web.validation.annotation.ConfirmPassword;

@Component
public class PasswordConfirmValidator implements ConstraintValidator<ConfirmPassword, User>{

	@Override
	public void initialize(ConfirmPassword arg0) {
	}

	@Override
	public boolean isValid(User user, ConstraintValidatorContext arg1) {

		if(user.getPassword().equals(user.getConfirmPassword())) {
		return true;
		}
		else return false;
	}

}
