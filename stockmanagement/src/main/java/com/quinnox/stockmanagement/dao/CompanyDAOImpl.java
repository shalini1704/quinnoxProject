package com.quinnox.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.stockmanagement.dto.CompanyBean;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public boolean updateCompany(String companyId, CompanyBean company) {
		boolean isUpdated = false;

		try {
			CompanyBean bean = manager.find(CompanyBean.class, companyId);
			if (bean != null) {

				// bean.setStockAvailability(company.getStockAvailability());
				bean.setTotalQuantity(company.getTotalQuantity());
				bean.setBidPrice(company.getBidPrice());
				bean.setMaxStockAmount(company.getMaxStockAmount());
				bean.setMaxStockQuantity(company.getMaxStockAmount());
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return isUpdated;
	}

	@Override
	@Transactional
	public List<CompanyBean> getAllCompanies() {
		try {
			String jpql = "from CompanyBean";
			TypedQuery<CompanyBean> query = manager.createQuery(jpql, CompanyBean.class);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public CompanyBean getCompany(String companyId) {
		try {
			CompanyBean bean = manager.find(CompanyBean.class, companyId);
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public boolean deleteCompany(String companyId) {
		boolean isDeleted = false;

		CompanyBean company = manager.find(CompanyBean.class, companyId);
		if (company != null) {
			try {
				manager.remove(company);
				isDeleted = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			} finally {
				manager.close();
			}
		}
		return isDeleted;
	}

	@Override
	@Transactional
	public boolean addCompany(CompanyBean company) {
		boolean isAdded = false;
		try {
			manager.persist(company);
			isAdded = true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return isAdded;
	}

}