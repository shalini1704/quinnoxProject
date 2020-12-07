package com.quinnox.stockmanagement.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.stockmanagement.dao.CompanyDAO;
import com.quinnox.stockmanagement.dto.CompanyBean;
import com.quinnox.stockmanagement.exception.ExceptionSMS;
import com.quinnox.stockmanagement.util.ValidationSMS;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO dao;

	@Override
	public boolean addCompany(CompanyBean company) {
		ValidationSMS v = new ValidationSMS();
		String companyName = company.getCompanyName();
		if(v.nameValidation(companyName)) {
			company.setCompanyName(companyName);
		}else{
			throw new ExceptionSMS("Enter only alphabet in name field");
		}
		String companyId = company.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			company.setCompanyId(companyId);
		}
		else {
			throw new ExceptionSMS("Enter id in this format (example :TS-01)");
		}
		return dao.addCompany(company);
	}

	@Override
	public boolean deleteCompany(String companyId) {

		return dao.deleteCompany(companyId);
	}

	@Override
	public boolean updateCompany(String companyId, CompanyBean company) {
		ValidationSMS v = new ValidationSMS();
		String companyName = company.getCompanyName();
		if(v.nameValidation(companyName)) {
			company.setCompanyName(companyName);
		}else{
			throw new ExceptionSMS("Enter only alphabet in name field");
		}
		companyId = company.getCompanyId();
		if(v.companyIdValidation(companyId)) {
			company.setCompanyId(companyId);
		}
		else {
			throw new ExceptionSMS("Enter id in this format (example :TS-01)");
		}
		return dao.updateCompany(companyId, company);
	}

	@Override
	public List<CompanyBean> getAllCompanies() {

		return dao.getAllCompanies();
	}

	@Override
	public CompanyBean searchCompany(String companyId) {

		return dao.getCompany(companyId);
	}

}