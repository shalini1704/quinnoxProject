package com.quinnox.stockmanagement.dto;



import java.util.List;


import lombok.Data;

public class InvestorResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<InvestorShare> shareDetails;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<InvestorShare> getShareDetails() {
		return shareDetails;
	}
	public void setShareDetails(List<InvestorShare> shareDetails) {
		this.shareDetails = shareDetails;
	}
	
}
