package ua.springboot.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import ua.springboot.web.validation.annotation.UniqueCarModel;


@Entity
@Table(name = "car")
public class Car extends BaseEntity{

	@NotNull(message = "this field cant be empty")
	@NotEmpty(message = "this field can not be empty")
	private String make;
	

	@NotNull(message = "this field cant be empty")
	@NotEmpty(message = "this field can not be empty")
	@Size(min = 1,max = 20, message ="Should be at 5 to 20")
	@UniqueCarModel(message = "there is this model in the base")
	private String model;

	
	
	private String color;
	
	public Car() {}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}