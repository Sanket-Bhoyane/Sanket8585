package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.User;
import com.example.jpa.service.UserService;
//we create a usercontroller class for processing incoming rest api requests

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/saveuser")
	public User saveUser(@RequestBody User use) {
		return userService.saveUser(use);

	}

	@GetMapping(value = "/getalluser")
	public List<User> getAnUser() {
		return userService.getAllUser();

	}

	@GetMapping(value = "/user/{id}")
	public User getAnUser(@PathVariable int id) {
		return userService.getAnUser(id);

	}

	@PutMapping(value = "/user/{id}")
	public User updateAnUser(@PathVariable int id, @RequestBody User use) {

		return userService.updateUser(use, id);

	}

	@DeleteMapping(value = "/user/{id}")
	public String deleteAnUser(@PathVariable int id) {

		return userService.deleteUser(id);

	}
}
