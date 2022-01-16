package com.sk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.entity.User;
import com.sk.service.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	// create user
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/fetchUsers")
	public List<User> fetchUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/findUser/{userId}")
	public User findUser(@PathVariable long userId) {
		return userService.findUser(userId);
	}

	@PutMapping("/updateUser/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable long userId) {
		return userService.updateUserDetails(user, userId);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public User deleteUser(@PathVariable long userId) {
		return userService.deleteUser(userId);
	}

}
