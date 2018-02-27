package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.User;

public interface UserService {

	void saveUser(User user);
	List<User> findAllUsers();
	User findUser(String name, String surname, String email);
}
