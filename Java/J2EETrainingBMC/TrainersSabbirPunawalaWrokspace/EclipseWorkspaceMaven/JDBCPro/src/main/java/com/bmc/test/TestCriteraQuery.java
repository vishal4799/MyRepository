package com.bmc.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.bmc.entities.Employee;
import com.bmc.utility.HibernateUtils;

public class TestCriteraQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		SessionFactory sessionFactory=HibernateUtils.createSessionFactory();
		Session session=sessionFactory.openSession();
		Criteria criteria1=session.createCriteria(Employee.class);
		Criteria criteria2=session.createCriteria(Employee.class);

		
		criteria1.add(Restrictions.disjunction()
				
				.add(Restrictions.lt("empSalary", 500000d))
				.add((Restrictions.like("empName", "S%")))
				.add(Restrictions.eq("empDesignation", "Trainer"))
				
				);

		criteria2.add(Restrictions.conjunction()
				
				.add(Restrictions.lt("empSalary", 500000d))
				.add((Restrictions.like("empName", "R%")))
				.add(Restrictions.eq("empDesignation", "Trainer"))
				
				);
		
		List<Employee> list1=criteria1.list();
		for(Employee e:list1){
			System.out.println(e);
		}
		
		List<Employee> list2=criteria2.list();
		for(Employee e:list2){
			System.out.println(e);
		}
		session.close();
		HibernateUtils.createSessionFactory();


	}

}
