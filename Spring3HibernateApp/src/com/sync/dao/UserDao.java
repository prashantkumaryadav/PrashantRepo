package com.sync.dao;

import java.util.ArrayList;

import com.sync.model.User;

public interface UserDao {
	public void addUser(User user) ;
	public User getUser(int userId);
	public ArrayList<User> getUsers();
	
	
}
