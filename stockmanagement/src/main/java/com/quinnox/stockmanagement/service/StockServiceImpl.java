package com.quinnox.stockmanagement.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.stockmanagement.dao.CompanyDAO;
import com.quinnox.stockmanagement.dao.StockDAO;
import com.quinnox.stockmanagement.dto.Stock;
import com.quinnox.stockmanagement.exception.ExceptionSMS;
import com.quinnox.stockmanagement.util.ValidationSMS;

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	StockDAO dao;
	@Autowired
	CompanyDAO companyDao;
	@Override
	public boolean addStock(Stock stock) {
		 if(companyDao.getCompany(stock.getCompanyId()) == null){
		   System.out.println("Given id doesn't exists");
	     }
		ValidationSMS v = new ValidationSMS();
		String companyId = stock.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			stock.setCompanyId(companyId);
		}
		else {
			throw new ExceptionSMS("Enter id in this format (example :TS-01)");
		}
		return dao.addStock(stock);
	}

	@Override
	public boolean deleteStock(int stockId) {
		return dao.deleteStock(stockId);
	}

	@Override
	public boolean updateStock(int stockId, Stock stock) {
		ValidationSMS v = new ValidationSMS();
		String companyId = stock.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			stock.setCompanyId(companyId);
		}
		else {
			throw new ExceptionSMS("Enter id in this format (example :TS-01)");
		}
		return dao.updateStock(stockId, stock);
	}

	@Override
	public List<Stock> getAllStocks() {
		return dao.getAllStocks();
	}

	@Override
	public Stock searchStock(int stockId) {
		return dao.searchStock(stockId);
	}
}
