package com.quinnox.stockmanagement.dao;

import java.util.List;

import com.quinnox.stockmanagement.dto.InvestorRequest;
import com.quinnox.stockmanagement.dto.InvestorShare;

public interface InvestorDAO {
	boolean addShare(InvestorRequest investor);
	boolean buyShare(InvestorRequest investor);
	boolean sellShare(InvestorRequest investor);
	boolean updateStockAvailability(InvestorRequest investor, boolean flag);
	 List<InvestorShare> getAllShares(int id);
}
