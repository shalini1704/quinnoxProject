package com.quinnox.stockmanagement.controller;

import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.stockmanagement.dto.User;
import com.quinnox.stockmanagement.dto.UserResponse;
import com.quinnox.stockmanagement.service.UserService;
 
@RestController

public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse register(@RequestBody User user) {
		UserResponse response = new UserResponse();
		if (service.addUser(user)) {
			response.setStatusCode(201);
			response.setDescription("Success");
			response.setMessage("Account created successfully");
		} else {
			response.setStatusCode(401);
			response.setDescription("Failure");
			response.setMessage("Account already exists");
		}
		return response;
	}

	@PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse login(@RequestBody User user) {
		UserResponse response = new UserResponse();
		User account = service.loginUser(user.getEmail(), user.getPassword());
		if (account != null) {
			response.setStatusCode(201);
			response.setDescription("Success");
			response.setMessage("Logged in successfully");
			response.setUser(Arrays.asList(account));
		} else {
			response.setStatusCode(401);
			response.setDescription("Failure");
			response.setMessage("Provide valid credentials");
		}
		return response;
	}

	@PutMapping(path = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse changePassword(@RequestBody User user) {

		UserResponse response = new UserResponse();
		if (service.updatePassword(user.getUserId(), user.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Updated successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Password is not updated");
		}
		return response;
	}

	@GetMapping(path = "/view-all-users", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse viewAllUsers() {
		UserResponse response = new UserResponse();
		List<User> list = service.getAllUsers();
		if (list.size() != 0) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("You got all the user details");
			response.setUser(list);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("No Users are present");
		}
		return response;
	}

	@DeleteMapping(path = "/delete-user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse removeUser(@PathVariable("userId") int userId) {
		UserResponse response = new UserResponse();
		if (service.deleteUser(userId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User is deleted successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("User not found to delete");
		}
		return response;
	}
	@GetMapping(path = "/search-user",produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse searchUser(@RequestParam ("id")int id) {
		UserResponse response = new UserResponse();
		User beans =service.getUser(id);
		if(beans!=null)
		{
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Details of User found");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record with particular id doesn't found");
			
		}
		return response;
	}
}