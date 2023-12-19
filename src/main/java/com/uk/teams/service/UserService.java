package com.uk.teams.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uk.teams.model.User;
import com.uk.teams.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;



@Service
public class UserService {
	
	@Autowired
    UserRepository userRepository; 
	
	// CREATE 
	public User createUser(User user) {
	    return userRepository.save(user);
	}

	// READ
	public List<User> getUsers() {
	    return userRepository.findAll();
	}
	
	// READ One
	public User getUserById(UUID userId) {
	    return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
	}
	
	// UPDATE
	public User updateUser(UUID userId, User userDetails) {
	        User user = userRepository.findById(userId).get();
	        user.setFirstName(userDetails.getFirstName());
	        user.setLastName(userDetails.getLastName());
	        user.setDisplayName(userDetails.getLastName());
	        user.setAvatarUrl(userDetails.getAvatarUrl());
	        user.setLocation(userDetails.getLocation());
	        return userRepository.save(user);                                
	}

	// DELETE
	public void deleteUser(UUID userId) {
	    userRepository.deleteById(userId);
	}

}
