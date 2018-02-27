package ua.springboot.web.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.springboot.web.validation.validator.PersonalValidator;


@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PersonalValidator.class)
public @interface Personal {

	String message() default "gsdffg";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
