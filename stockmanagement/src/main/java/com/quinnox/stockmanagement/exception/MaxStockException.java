package com.quinnox.stockmanagement.exception;



@SuppressWarnings("serial")
public class MaxStockException extends Exception {
	String message;

	public MaxStockException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
