package com.quinnox.stockmanagement.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.stockmanagement.dao.CompanyDAO;
import com.quinnox.stockmanagement.dao.InvestorDAO;
import com.quinnox.stockmanagement.dao.UserDAO;
import com.quinnox.stockmanagement.dto.InvestorRequest;
import com.quinnox.stockmanagement.dto.InvestorShare;
import com.quinnox.stockmanagement.exception.ExceptionSMS;
import com.quinnox.stockmanagement.util.ValidationSMS;

@Service
public class InvestorServiceImpl implements InvestorService{
	@Autowired
	InvestorDAO dao;
	@Autowired
	UserDAO userDao;
	@Autowired
	CompanyDAO companyDao;

	@Override
	public boolean addShare(InvestorRequest investor) {
		 if(userDao.getUser(investor.getUserId()) == null ||
	    		 companyDao.getCompany(investor.getCompanyId()) == null){
		   System.out.println("Given id doesn't exists");
	     }
		ValidationSMS v = new ValidationSMS();
		String companyId = investor.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			investor.setCompanyId(companyId);
		}
		else {
			throw new ExceptionSMS("Enter id in this format (example :TS-01)");
		}
		return dao.addShare(investor);
	}

	@Override
	public boolean buyShare(InvestorRequest investor) {

		return dao.buyShare(investor);
	}
	@Override
	public boolean sellShare(InvestorRequest investor) {

		return dao.sellShare(investor);
	}

	@Override
	public boolean updateStockAvailability(InvestorRequest investor, boolean flag) {
		ValidationSMS v = new ValidationSMS();
		String companyId = investor.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			investor.setCompanyId(companyId);
		}
		else {
			throw new ExceptionSMS("Enter id in this format (example :TS-01)");
		}
		return dao.updateStockAvailability(investor, flag);
	}

	@Override
	public List<InvestorShare> getAllShares(int id) {
	
		return dao.getAllShares(id);
	}

}

