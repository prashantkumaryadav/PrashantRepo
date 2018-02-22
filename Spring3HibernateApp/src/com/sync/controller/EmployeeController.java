package com.sync.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sync.bean.EmployeeBean;
import com.sync.model.Employee;
import com.sync.service.EmployeeService;
import com.sync.service.UserService;

/**
 * @author Dinesh Rajput
 *
 */
@Controller
public class EmployeeController {
	
	final static Logger OUT = Logger.getLogger(EmployeeController.class);
 @Autowired
 private EmployeeService employeeService;
 
@RequestMapping(value = "/saveemp", method = RequestMethod.POST)
public ModelAndView saveEmployee(@ModelAttribute("command")EmployeeBean employeeBean, 
   BindingResult result) {
OUT.debug("Saving the employe.");
  Employee employee = prepareModel(employeeBean);
  employeeService.addEmployee(employee);
  return new ModelAndView("redirect:/add.html");
 }

 @RequestMapping(value="/employees", method = RequestMethod.GET)
 public ModelAndView listEmployees() {
	 
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
  return new ModelAndView("employeeList", model);
 }

 @RequestMapping(value = "/add", method = RequestMethod.GET)
 public ModelAndView addEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
  return new ModelAndView("addEmployee", model);
 }
 
@RequestMapping(value = "/index", method = RequestMethod.GET)
public ModelAndView welcome( @ModelAttribute("command")EmployeeBean employeeBean) {
  return new ModelAndView("excep");
 }

@RequestMapping(value = "/process", method = RequestMethod.GET)
public ModelAndView procedd( @ModelAttribute("command")EmployeeBean employeeBean) {
  return new ModelAndView("process");
 }

@RequestMapping(value = "/delete", method = RequestMethod.GET)
public ModelAndView editEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
   BindingResult result) {
  employeeService.deleteEmployee(prepareModel(employeeBean));
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("employee", null);
  model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
  return new ModelAndView("addEmployee", model);
 }
 
@RequestMapping(value = "/edit", method = RequestMethod.GET)
public ModelAndView deleteEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
   BindingResult result) {
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employeeBean.getId())));
  model.put("employees",  prepareListofBean(employeeService.listEmployeess()));
  return new ModelAndView("addEmployee", model);
 }

@RequestMapping(value="/searchEmp", method = RequestMethod.POST)
public ModelAndView getEmployeeByName(@ModelAttribute("command")EmployeeBean employeeBean) {
	 
 Map<String, Object> model = new HashMap<String, Object>();
 System.out.println("getting details for" + employeeBean.getAge());
 model.put("employees",  prepareListofBean(employeeService.getEmployeeByName(employeeBean.getName(),employeeBean.getAge())));
 return new ModelAndView("employeeList", model);
}

@RequestMapping(value="/empForm", method = RequestMethod.GET)
public ModelAndView getEmployeeForm(@ModelAttribute("command")EmployeeBean employeeBean) {
 return new ModelAndView("searchEmployee");
}
 
 private Employee prepareModel(EmployeeBean employeeBean){
  Employee employee = new Employee();
  employee.setEmpAddress(employeeBean.getAddress());
  employee.setEmpAge(employeeBean.getAge());
  employee.setEmpName(employeeBean.getName());
  employee.setSalary(employeeBean.getSalary());
  employee.setEmpId(employeeBean.getId());
  employeeBean.setId(null);
  return employee;
 }
 
 private List<EmployeeBean> prepareListofBean(List<Employee> employees){
  List<EmployeeBean> beans = null;
  if(employees != null && !employees.isEmpty()){
   beans = new ArrayList<EmployeeBean>();
   EmployeeBean bean = null;
   for(Employee employee : employees){
    bean = new EmployeeBean();
    bean.setName(employee.getEmpName());
    bean.setId(employee.getEmpId());
    bean.setAddress(employee.getEmpAddress());
    bean.setSalary(employee.getSalary());
    bean.setAge(employee.getEmpAge());
    beans.add(bean);
   }
  }
  return beans;
 }
 
 private EmployeeBean prepareEmployeeBean(Employee employee){
  EmployeeBean bean = new EmployeeBean();
  bean.setAddress(employee.getEmpAddress());
  bean.setAge(employee.getEmpAge());
  bean.setName(employee.getEmpName());
  bean.setSalary(employee.getSalary());
  bean.setId(employee.getEmpId());
  return bean;
 }
}
