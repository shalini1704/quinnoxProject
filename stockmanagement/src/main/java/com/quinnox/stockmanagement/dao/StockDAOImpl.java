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

import com.quinnox.stockmanagement.dto.Stock;

@Repository
public class StockDAOImpl implements StockDAO {
	@Autowired
	EntityManager manager;

	@Override
	@Transactional
	public boolean addStock(Stock stock) {
		boolean isAdded = false;
		
		try {
			manager.persist(stock);
			isAdded = true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	@Transactional
	public boolean deleteStock(int stockId) {
		boolean isDeleted = false;
		

		Stock stock = manager.find(Stock.class, stockId);
		if (stock != null) {
			try {
				manager.remove(stock);
				isDeleted = true;
			} catch (Exception e) {
			} finally {
				manager.close();
			}
		}
		return isDeleted;
	}

	@Override
	@Transactional
	public boolean updateStock(int stockId, Stock stock) {
		boolean isUpdated = false;
		
		try {
			Stock bean = manager.find(Stock.class, stockId);
			if (bean != null) {
				bean.setStockQuantity(stock.getStockQuantity());
				bean.setPrice(stock.getPrice());
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
	public List<Stock> getAllStocks() {
		
		try {
			String jpql = "from Stock";
			TypedQuery<Stock> query = manager.createQuery(jpql, Stock.class);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	@Transactional
	public Stock searchStock(int stockId) {
		try {
			Stock bean = manager.find(Stock.class, stockId);
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

}