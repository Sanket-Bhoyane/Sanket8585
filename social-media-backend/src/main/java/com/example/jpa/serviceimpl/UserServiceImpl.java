package com.example.jpa.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.entity.User;
import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.repository.UserRepository;
import com.example.jpa.service.UserService;

//we use a crude operation here for user 
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User use) {
		return userRepository.save(use);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User getAnUser(int id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " Not Found!!!!!"));
	}

	@Override
	public User updateUser(User use, int id) {
		User u = userRepository.findById(id).get();
		u.setName(use.getName());
		u.setFollwer(use.getFollwer());
		u.setGender(use.getGender());
		return userRepository.save(u);
	}

	@Override
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "User with id " + id + " has been deleted!!!!";
	}

	@Override
	public List<User> findByNameLike(String name) {
		return userRepository.findByNameLike(name);

	}
}
