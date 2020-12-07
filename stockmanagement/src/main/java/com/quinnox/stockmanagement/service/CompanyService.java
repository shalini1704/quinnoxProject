package com.quinnox.stockmanagement.service;



import java.util.List;

import com.quinnox.stockmanagement.dto.CompanyBean;

public interface CompanyService {
	boolean addCompany(CompanyBean company);

	boolean deleteCompany(String companyId);

	boolean updateCompany(String companyId, CompanyBean company);

	List<CompanyBean> getAllCompanies();

	CompanyBean searchCompany(String companyId);
}
