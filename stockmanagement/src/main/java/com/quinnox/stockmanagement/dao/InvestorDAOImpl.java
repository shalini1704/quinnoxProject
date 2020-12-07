package com.quinnox.stockmanagement.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.stockmanagement.dto.CompanyBean;
import com.quinnox.stockmanagement.dto.InvestorRequest;
import com.quinnox.stockmanagement.dto.InvestorShare;

@Repository
public class InvestorDAOImpl implements InvestorDAO{
	
@Autowired
	EntityManager manager;

	@Override
	@Transactional
	
	public boolean addShare(InvestorRequest investor) {
		boolean isAdded = false;
		
		EntityTransaction transaction = manager.getTransaction();
		InvestorShare record = new InvestorShare();
		record.setCompanyId(investor.getCompanyId());
		record.setUserId(investor.getUserId());
		record.setAvailableAmount(investor.getTotalAmount());
		record.setTotalSharesBought(investor.getTotalSharesTransacted());
		record.setTotalAmountBought(investor.getTotalAmount());
		record.setAvailableShares(investor.getTotalSharesTransacted());
		record.setTotalSharesSold(0);
		record.setTotalAmountSold(0);
		try {
			
			manager.persist(record);
			
			isAdded = true;
			updateStockAvailability(investor, true);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	@Transactional
	public boolean buyShare(InvestorRequest investor) {
		boolean isUpdated = false;
		
		try {
			InvestorShare bean = manager.find(InvestorShare.class, investor.getUserId());
			if (bean != null) {
				bean.setTotalAmountBought(bean.getTotalAmountBought() + investor.getTotalAmount());
				bean.setAvailableAmount(bean.getAvailableAmount() + investor.getTotalAmount());
				bean.setAvailableShares(bean.getAvailableShares() + investor.getTotalSharesTransacted());
				updateStockAvailability(investor, true);
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return isUpdated;
	}
	public boolean sellShare(InvestorRequest investor) {
		boolean isUpdated = false;
		try {
			InvestorShare bean = manager.find(InvestorShare.class, investor.getUserId());
			if (bean != null) {
				bean.setAvailableAmount(bean.getAvailableAmount() - investor.getTotalAmount());
				bean.setAvailableShares(bean.getAvailableShares() - investor.getTotalSharesTransacted());
				bean.setTotalSharesSold(bean.getTotalSharesSold() + investor.getTotalSharesTransacted());
				bean.setTotalAmountSold(bean.getTotalAmountSold() + investor.getTotalAmount());
				updateStockAvailability(investor, false);
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	@Transactional
	public boolean updateStockAvailability(InvestorRequest investor, boolean flag) {
		boolean isUpdated = false;
		try {
			CompanyBean bean = manager.find(CompanyBean.class, investor.getCompanyId());
			if (bean != null) {
				if(flag) {
					bean.setStockAvailability(bean.getStockAvailability() + investor.getTotalSharesTransacted());					
				} else {
					bean.setStockAvailability(bean.getStockAvailability() - investor.getTotalSharesTransacted());
				}
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	@Transactional
	public List<InvestorShare> getAllShares(int id) {
		try {
			String jpql = "from InvestorShare i where i.userId=:id1";
			TypedQuery<InvestorShare> query = manager.createQuery(jpql, InvestorShare.class);
			query.setParameter("id1", id);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

}

