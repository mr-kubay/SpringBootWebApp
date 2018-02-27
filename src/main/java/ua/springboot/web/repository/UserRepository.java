package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.name = :name and u.surname = :surname and u.email = :email")
	User findUser(@Param("name") String name, @Param("surname") String surname, @Param("email") String email);
}
