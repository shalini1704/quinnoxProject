package com.quinnox.stockmanagement.dao;



import java.util.List;

import com.quinnox.stockmanagement.dto.CompanyBean;

public interface CompanyDAO {

	boolean addCompany(CompanyBean company);

	boolean deleteCompany(String companyId);

	boolean updateCompany(String companyId, CompanyBean company);

	List<CompanyBean> getAllCompanies();

	CompanyBean getCompany(String companyId);
}
