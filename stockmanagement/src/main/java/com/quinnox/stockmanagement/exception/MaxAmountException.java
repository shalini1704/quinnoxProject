package com.quinnox.stockmanagement.exception;



public class MaxAmountException extends Exception {

	String message;

	public MaxAmountException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
