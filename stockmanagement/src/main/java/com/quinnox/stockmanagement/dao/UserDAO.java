package com.quinnox.stockmanagement.dao;



import java.util.List;

import com.quinnox.stockmanagement.dto.User;


public interface UserDAO {
	boolean addUser(User user);

	boolean deleteUser(int userId);

	boolean updatePassword(int userId, String password);

	User loginUser(String email, String password);

	List<User> getAllUsers();
	
	User getUser(int userId);

}
