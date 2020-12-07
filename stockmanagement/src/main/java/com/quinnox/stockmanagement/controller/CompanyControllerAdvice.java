package com.quinnox.stockmanagement.controller;



import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.quinnox.stockmanagement.dto.CompanyResponse;
import com.quinnox.stockmanagement.exception.ExceptionSMS;
@RestControllerAdvice 
public class CompanyControllerAdvice {
	@ExceptionHandler(ExceptionSMS.class)
	public CompanyResponse handleCustomerException(ExceptionSMS e) {
		CompanyResponse companyResponse = new CompanyResponse();
		companyResponse.setStatusCode(501);
		companyResponse.setMessage("Exception");
		companyResponse.setDescription(e.getMessage());
		return companyResponse;
	}
}
