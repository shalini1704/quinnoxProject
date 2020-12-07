package com.quinnox.stockmanagement.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.quinnox.stockmanagement.dto.StockResponse;
import com.quinnox.stockmanagement.exception.ExceptionSMS;

@RestControllerAdvice 
public class StockControllerAdvice {
	@ExceptionHandler(ExceptionSMS.class)
	public StockResponse handleStockException(ExceptionSMS e) {
		StockResponse stockResponse = new StockResponse();
		stockResponse.setStatusCode(501);
		stockResponse.setMessage("Exception");
		stockResponse.setDescription(e.getMessage());
		return stockResponse;
	}
}
