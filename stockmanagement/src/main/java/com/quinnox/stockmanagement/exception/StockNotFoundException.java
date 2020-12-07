package com.quinnox.stockmanagement.exception;


public class StockNotFoundException extends Exception {
	String message;

	public StockNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}