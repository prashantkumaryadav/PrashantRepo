package com.sync.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sync.bean.EmployeeBean;
import com.sync.bean.UserBean;
import com.sync.model.Employee;
import com.sync.model.User;
import com.sync.service.UserService;

@Controller
public class UserController {
	final static Logger OUT = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	 @RequestMapping(value = "/adduser", method = RequestMethod.GET)
	 public ModelAndView addUser(@ModelAttribute("command")UserBean userBean,
	   BindingResult result) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  return new ModelAndView("addUser");
	 }
	
	 @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	 public ModelAndView saveUser(@ModelAttribute("command")UserBean userBean,
	   BindingResult result) {
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("user", userBean);
	  System.out.print("this is user" + userBean.getuName());
	  User user = prepareModel(userBean);
	  System.out.print(userBean.toString());
	  userService.addUser(user);
	  return new ModelAndView("success", model);
	 }

	 @RequestMapping(value = "/search", method = RequestMethod.GET)
	 public ModelAndView searchUser(@ModelAttribute("command")UserBean userBean,
	   BindingResult result) {
	  User user = userService.getUser(userBean.getuId());
	  Map<String, Object> model = new HashMap<String, Object>();
	  model.put("user", user);
	  return new ModelAndView("success", model);
	 }
	 
	 @RequestMapping(value = "/allusers", method = RequestMethod.GET)
	 public ModelAndView gerUsers() {
		  Map<String, Object> model = new HashMap<String, Object>();
		  model.put("users",  prepareListofBean(userService.getUsers()));
	  return new ModelAndView("success", model);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	private ArrayList<UserBean> prepareListofBean(ArrayList<User> users) {
		// TODO Auto-generated method stub
		ArrayList<UserBean> userBeanList = new ArrayList<>();
		for(User user: users){
			UserBean bean= new UserBean();
			bean.setuId(user.getuId());
			bean.setuName(user.getuName());
			userBeanList.add(bean);
		}
		return userBeanList;
	}

	private User prepareModel(UserBean user) {
		User newuser = new User();
		newuser.setuId(user.getuId());
		newuser.setuName(user.getuName());
		return newuser;
		
	}


}
