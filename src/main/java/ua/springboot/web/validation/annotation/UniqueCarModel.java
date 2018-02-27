package ua.springboot.web.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.springboot.web.validation.validator.UniqueCarModelValidator;

@Target(value = {ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCarModelValidator.class)
public @interface UniqueCarModel {

	String message() default "Model already exists";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
