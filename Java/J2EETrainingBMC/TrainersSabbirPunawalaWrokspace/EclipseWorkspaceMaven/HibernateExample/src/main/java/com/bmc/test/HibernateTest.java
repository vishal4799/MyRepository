package com.bmc.test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bmc.utility.HibernateUtils;
import com.bmc.works.domain.Employee;

public class HibernateTest {
	public static void main(String args[]){
	Session session = HibernateUtils.getSessionFactory().openSession();
	  
    session.beginTransaction();

 

    session.save(new Employee(101,"Sabbir",45000,"Trainer"));
    session.save(new Employee(102,"Rakesh",45000,"Trainer"));
  
    session.getTransaction().commit();

    Query query = session.createQuery("From Employee ");
             
    List<Employee> resultList = query.list();
    System.out.println("num of employess:" + resultList.size());
    for (Employee next : resultList) {
        System.out.println("next employee: " + next);
    }
	}

}