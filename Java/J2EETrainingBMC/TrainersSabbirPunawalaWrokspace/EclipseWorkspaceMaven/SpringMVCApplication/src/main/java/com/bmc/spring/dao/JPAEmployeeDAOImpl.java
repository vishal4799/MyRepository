package com.bmc.spring.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bmc.spring.dao.EmployeeDAO;
import com.bmc.spring.entities.Employee;
@Repository("JPAEmployeeDAO")
public class JPAEmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public List<Employee> getAllEmployees() 
			 {
		// TODO Auto-generated method stub
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createQuery("select e from Employee e");
		
		List<Employee> empList=query.getResultList();
		
		
		return empList;
	}

	public boolean persistEmployee(Employee employee)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean result=false;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
        result=true;
		return result;
	}

	public List<String> getLocationNames()  {
		// TODO Auto-generated method stub
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Query query=entityManager.createNativeQuery("select location_name from location");
		List<String> locationList=query.getResultList();
		return locationList;
	}

	public int generateEmpId() {
		// TODO Auto-generated method stub
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		//Query query=entityManager.createNativeQuery("select EMPIDSEQ.nextval from dual");
        //int empId=(Integer)query.getSingleResult();
		//System.out.println(empId);
		//return empId;
		return 1;
	}

}
