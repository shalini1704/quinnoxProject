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

import com.quinnox.stockmanagement.dto.User;
import com.quinnox.stockmanagement.exception.ExceptionSMS;

@Repository
public class UserDAOImpl implements UserDAO {
  @Autowired
	EntityManager manager;
	@Override
	@Transactional
	public boolean addUser(User user) {
		boolean isAdded = false;
		
		try {
			manager.persist(user);
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean deleteUser(int userId) {
		boolean isDeleted = false;

		User user = manager.find(User.class, userId);
		if (user != null) {
			try {
				manager.remove(user);
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
	public boolean updatePassword(int userId, String password) {
		boolean isUpdated = false;
		
		try {
			User bean = manager.find(User.class, userId);
			if (bean != null) {
				bean.setPassword(password);
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
	public User loginUser(String email, String password) {

		try {
			String jpql = "from User where email=:email and password=:password";
			TypedQuery<User> query = manager.createQuery(jpql, User.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			User record = query.getSingleResult();
			return record;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		try {
			String jpql = "from User";
			TypedQuery<User> query = manager.createQuery(jpql, User.class);
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
	public User getUser(int userId) {
		String jpql = "from User where userId=:userId";
		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		query.setParameter("userId", userId);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
				throw new ExceptionSMS("user not found");
			}
	}
	}

 