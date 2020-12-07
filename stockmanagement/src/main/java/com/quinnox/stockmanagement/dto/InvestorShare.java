package com.quinnox.stockmanagement.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "investor_share")
public class InvestorShare {
	@Id
	@Column
	int shareId;
	@Column
	private int userId;
	@Column
	private String companyId;
	@Column
	private int totalSharesSold;
	@Column
	private double totalAmountSold;
	@Column
	private double totalAmountBought;
	@Column
	private int totalSharesBought;
	@Column
	private int availableShares;
	@Column
	private double availableAmount;
	public int getShareId() {
		return shareId;
	}
	public void setShareId(int shareId) {
		this.shareId = shareId;
	}
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
	public int getTotalSharesSold() {
		return totalSharesSold;
	}
	public void setTotalSharesSold(int totalSharesSold) {
		this.totalSharesSold = totalSharesSold;
	}
	public double getTotalAmountSold() {
		return totalAmountSold;
	}
	public void setTotalAmountSold(double totalAmountSold) {
		this.totalAmountSold = totalAmountSold;
	}
	public double getTotalAmountBought() {
		return totalAmountBought;
	}
	public void setTotalAmountBought(double totalAmountBought) {
		this.totalAmountBought = totalAmountBought;
	}
	public int getTotalSharesBought() {
		return totalSharesBought;
	}
	public void setTotalSharesBought(int totalSharesBought) {
		this.totalSharesBought = totalSharesBought;
	}
	public int getAvailableShares() {
		return availableShares;
	}
	public void setAvailableShares(int availableShares) {
		this.availableShares = availableShares;
	}
	public double getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}
	
}
