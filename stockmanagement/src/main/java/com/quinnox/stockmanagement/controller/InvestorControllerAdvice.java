package com.quinnox.stockmanagement.controller;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.quinnox.stockmanagement.dto.InvestorResponse;
import com.quinnox.stockmanagement.exception.ExceptionSMS;

@RestControllerAdvice 
public class InvestorControllerAdvice {
	@ExceptionHandler(ExceptionSMS.class)
	public InvestorResponse handleInvestorException(ExceptionSMS e) {
		InvestorResponse investorResponse = new InvestorResponse();
		investorResponse.setStatusCode(501);
		investorResponse.setMessage("Exception");
		investorResponse.setDescription(e.getMessage());
		return investorResponse;
	}
}
