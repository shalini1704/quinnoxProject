package com.quinnox.stockmanagement.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.quinnox.stockmanagement.dto.UserResponse;
import com.quinnox.stockmanagement.exception.ExceptionSMS;

@RestControllerAdvice 
public class UserControllerAdvice {
	@ExceptionHandler(ExceptionSMS.class)
	public UserResponse handleUserException(ExceptionSMS e) {
		UserResponse userResponse = new UserResponse();
		userResponse.setStatusCode(501);
		userResponse.setMessage("Exception");
		userResponse.setDescription(e.getMessage());
		return userResponse;
	}
}
