package com.sync.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sync.dao.UserDao;
import com.sync.model.User;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	 @Autowired
	 private UserDao userDao;
	 
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	 public void addUser(User user) {
		 userDao.addUser(user);
	 }
	 
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	 public User getUser(int id) {
		 return userDao.getUser(id);
	 }
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}
	 
	 

}
