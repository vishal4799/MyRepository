package com.bmc.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bmc.entities.Employee;
import com.bmc.utility.HibernateUtils;

public class HibernateEmployeeDAOImpl implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() 
			 {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory=HibernateUtils.createSessionFactory();
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select e from Employee e");
		
		
		List<Employee> list= query.list();
		session.close();
		HibernateUtils.closeSessionFactory();
		return list;
		
	}

	@Override
	public Employee getEmployee(int empId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory=HibernateUtils.createSessionFactory();
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select e from Employee e where e.empId=:id");
		//query.setParameter(1, empId);
		query.setParameter("id", empId);
		Employee employee=(Employee)query.uniqueResult();
		HibernateUtils.closeSessionFactory();
		return employee;
	}

	@Override
	public boolean persistEmployee(Employee employee)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=HibernateUtils.createSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		session.save(employee);
		transaction.commit();
		HibernateUtils.closeSessionFactory();
		
		return false;
	}

	@Override
	public boolean updateEmployeeSalaryById(int empId, double newSalary)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=HibernateUtils.createSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		/*
		Query query=session.createQuery("update Employee e set e.empSalary=:newSal where e.empId=:id");
		query.setParameter("newSal",newSalary);
		query.setParameter("id",empId);
		query.executeUpdate();*/
		
		Employee employee=new Employee();
		employee.setEmpId(empId);
		employee.setEmpName("Sabbir");
		employee.setEmpSalary(newSalary);
		employee.setEmpDesignation("Trainer");
		
		session.merge(employee);
		transaction.commit();
		HibernateUtils.closeSessionFactory();
		
		return false;
	}

	@Override
	public boolean deleteEmployee(int empId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double computeTax(int empId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}