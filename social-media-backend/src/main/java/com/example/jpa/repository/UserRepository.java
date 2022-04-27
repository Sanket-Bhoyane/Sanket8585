package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public Iterable<User> findUsersByname(String string);

	@Query("SELECT u FROM User u WHERE u.name LIKE %?1%")
	List<User> findByNameLike(String name);

	@Query("select u1 from User u1 where u1.gender LIKE %?1%")
	public User findByGenderLike(String gender);
}
