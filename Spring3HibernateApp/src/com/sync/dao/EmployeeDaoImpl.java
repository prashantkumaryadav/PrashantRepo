package com.sync.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sync.model.Employee;

/**
 * @author Prashant Yadav
 *
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

 @Autowired
 private SessionFactory sessionFactory;
 
 public void addEmployee(Employee employee) {
	 System.out.println("adding" + employee.getEmpId());
	 System.out.println("adding" + employee.getEmpName());
	 Session session = sessionFactory.getCurrentSession();
	 session.saveOrUpdate(employee);
 }

 @SuppressWarnings("unchecked")
 public List<Employee> listEmployeess() {
	 Session session = sessionFactory.getCurrentSession();
	 Criteria cr = session.createCriteria(Employee.class);
	 List<Employee> employees = cr.list();
	 return employees;
  //return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
 }

 public Employee getEmployee(int empid) {
  return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
 }

 public void deleteEmployee(Employee employee) {
  sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+employee.getEmpId()).executeUpdate();
 }

public List<Employee> getEmployeeByName(String name,int age) {
	Session session = sessionFactory.getCurrentSession();
	 Criteria cr = session.createCriteria(Employee.class).add(Restrictions.like("empName", "%"+name+"%"));
	 cr.add(Restrictions.lt("empAge", age));
	 List<Employee> employees = cr.list();
	 return employees;
}
}
