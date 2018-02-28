package ua.springboot.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import ua.springboot.web.validation.annotation.ConfirmPassword;
import ua.springboot.web.validation.annotation.Personal;
import ua.springboot.web.validation.annotation.ReturnUser;

@Entity
@Table(name = "user")
@Personal
@ConfirmPassword
//@ReturnUser
public class User extends BaseEntity{
	
	
	private String login;
	
	private String email;
	private String password;
	@Transient
	private String confirmPassword;
	
	
	
	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	public User() {
	}
	
	

}
