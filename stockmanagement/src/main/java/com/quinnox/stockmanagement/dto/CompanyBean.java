package com.quinnox.stockmanagement.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "companies_info")
public class CompanyBean {
	@Id
	@Column
	private String companyId;
	@Column(nullable = false,unique=true)
	private String companyName;
	@Column(nullable = false)
	private int stockAvailability;
	@Column(nullable = false)
	private int totalQuantity;
	@Column(nullable=false)
	private double bidPrice;
	@Column(nullable = false)
	private int maxStockAmount;
	@Column(nullable=false)
	private int maxStockQuantity;
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getStockAvailability() {
		return stockAvailability;
	}
	public void setStockAvailability(int stockAvailability) {
		this.stockAvailability = stockAvailability;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public int getMaxStockAmount() {
		return maxStockAmount;
	}
	public void setMaxStockAmount(int maxStockAmount) {
		this.maxStockAmount = maxStockAmount;
	}
	public int getMaxStockQuantity() {
		return maxStockQuantity;
	}
	public void setMaxStockQuantity(int maxStockQuantity) {
		this.maxStockQuantity = maxStockQuantity;
	}

}
