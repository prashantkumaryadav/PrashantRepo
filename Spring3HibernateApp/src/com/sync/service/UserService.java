package com.sync.service;


import java.util.ArrayList;

import com.sync.model.User;

public interface UserService {
	public void addUser(User user);
	public User getUser(int userId);
	public ArrayList<User> getUsers();
}
