package com.bmc.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bmc.dao.JDBCEmployeeDAOImpl;
import com.bmc.entities.Employee;

public class TestJDBCEmployeeDAOImpl {
	
	private JDBCEmployeeDAOImpl jdbcemployeedao=null;

	@Before
	public void setUp() throws Exception {
		jdbcemployeedao=new JDBCEmployeeDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		jdbcemployeedao=null;
	}

	@Test
	public void testPersistEmployee_positive() {
		
		Employee employee=new Employee();
		employee.setEmpId(2001);
		employee.setEmpName("Purohit");
		employee.setEmpSalary(45000);
		employee.setEmpDesignation("Trainer");
		
		try {
			jdbcemployeedao.persistEmployee(employee);
			Employee employee1=jdbcemployeedao.getEmployee(2001);
			assertEquals(2001,employee1.getEmpId());
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			fail("should not throw exception");
		}
		
		
		
		
		
	}

}
