package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.login = :login and u.email = :email")
	User findUser(@Param("login") String login, @Param("email") String email);
	
	@Query("select u from User u where u.login = :login and u.password = :password")
	User returnUser(@Param("login") String login, @Param("password") String password);
}
