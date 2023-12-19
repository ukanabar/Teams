package com.uk.teams.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uk.teams.model.User;
import com.uk.teams.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
    UserService userService;
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
	    return userService.createUser(user);
	}
	
	@GetMapping("/users")
	public List<User> GetUsers() {
	    return userService.getUsers();
	}

	@PutMapping("/users/{userId}")
	public User getUsers(@PathVariable(value = "userId") UUID id, @RequestBody User userDetails) {
	    return userService.updateUser(id, userDetails);
	}

	@DeleteMapping("/users/{userId}")
	public void deleteEmployees(@PathVariable(value = "userId") UUID id) {
	    userService.deleteUser(id);
	}
}
