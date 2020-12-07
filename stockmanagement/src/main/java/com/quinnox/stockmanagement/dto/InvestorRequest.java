package com.quinnox.stockmanagement.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "investorrequest_info")
public class InvestorRequest {
	@Id
	@Column
	private int userId;
	@Column(nullable = false)
	private String companyId;
	@Column(nullable = false)
	private int totalSharesTransacted;
	@Column(nullable = false)
	private double totalAmount;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getTotalSharesTransacted() {
		return totalSharesTransacted;
	}
	public void setTotalSharesTransacted(int totalSharesTransacted) {
		this.totalSharesTransacted = totalSharesTransacted;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
