package com.example.jpa.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.jpa.entity.User;

// we built a buisness logic here for user
@Component
public interface UserService {
	User saveUser(User use);

	List<User> getAllUser();

	User getAnUser(int id);

	User updateUser(User use, int id);

	String deleteUser(int id);

	List<User> findByNameLike(String name);
}
