package ua.springboot.web.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.springboot.web.validation.validator.ReturnUserValidator;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy =ReturnUserValidator.class)
public @interface ReturnUser {

	String message() default "There is no user in DB with that login and password";
	Class<?>[] groups() default {};
	Class<? extends Payload>[]payload() default {}; 
}
