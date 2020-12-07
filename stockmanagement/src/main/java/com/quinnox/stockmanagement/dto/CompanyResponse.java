package com.quinnox.stockmanagement.dto;



import java.util.List;

import lombok.Data;


public class CompanyResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<CompanyBean> company;
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
	public List<CompanyBean> getCompany() {
		return company;
	}
	public void setCompany(List<CompanyBean> company) {
		this.company = company;
	}

}
