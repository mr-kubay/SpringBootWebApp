package ua.springboot.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import ua.springboot.web.validation.annotation.Personal;

@Entity
@Table(name = "user")
@Personal
public class User extends BaseEntity{
	
	
	private String name;
	private String surname;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User() {
	}
	
	

}
