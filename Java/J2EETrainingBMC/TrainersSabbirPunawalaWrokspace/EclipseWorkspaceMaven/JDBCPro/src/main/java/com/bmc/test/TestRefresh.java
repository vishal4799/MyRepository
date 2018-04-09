package com.bmc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bmc.entities.Employee;
import com.bmc.utility.HibernateUtils;

public class TestRefresh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory=HibernateUtils.createSessionFactory();
		Session session=sessionFactory.openSession();
		
		Employee employee=new Employee();
		employee.setEmpId(1001);
		employee.setEmpName("Sabbir");
		employee.setEmpSalary(75000);
		employee.setEmpDesignation("Trainer");
		while(true){
		session.refresh(employee);
		System.out.println("Salary:"+employee.getEmpSalary());
		}
		
		
		
		

	}

}