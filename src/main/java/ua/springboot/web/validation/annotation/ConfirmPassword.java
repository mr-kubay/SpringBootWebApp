package ua.springboot.web.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.springboot.web.validation.validator.PasswordConfirmValidator;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordConfirmValidator.class)
public @interface ConfirmPassword {
	
	String message() default "Fields aren't equal";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};

}
