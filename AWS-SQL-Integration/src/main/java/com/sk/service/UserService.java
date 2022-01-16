package com.sk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.entity.User;
import com.sk.exception.ResourceNotFoundException;
import com.sk.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User findUser(long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
	}

	public User updateUserDetails(User user, long userId) {
		User existingUser = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));

		existingUser.setEmail(user.getEmail());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		return userRepository.saveAndFlush(existingUser);
	}
	
	public User deleteUser(long userId) {
		User existingUser=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with id :" + userId));
		userRepository.deleteById(userId);
		return existingUser;
	}
}
