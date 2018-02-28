package ua.springboot.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.User;
import ua.springboot.web.repository.UserRepository;
import ua.springboot.web.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRep;
	
	@Override
	public void saveUser(User user) {
		userRep.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRep.findAll();
	}

	@Override
	public User findUser(String login, String email) {
		return userRep.findUser(login, email);
	}

	@Override
	public User returnUser(String login, String password) {
		return userRep.returnUser(login, password);
	}

}
