package com.sync.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sync.model.Employee;
import com.sync.model.User;
import com.sync.service.UserService;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	 @Autowired
	 private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		System.out.println("adding" + user.getuName());
		System.out.println("adding" + user.getuId());
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	public User getUser(int userId){
	 return (User)sessionFactory.getCurrentSession().get(User.class, userId);
	}
	@Override
	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		return (ArrayList<User>)sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}
	
	
	
	


}
