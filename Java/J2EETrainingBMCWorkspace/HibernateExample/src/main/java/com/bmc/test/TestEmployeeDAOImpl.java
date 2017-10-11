package com.bmc.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bmc.dao.EmployeeDAO;
import com.bmc.dao.EmployeeDAOImpl;
import com.bmc.entities.Employee;
import com.bmc.helper.FactoryEmployeeDAO;

public class TestEmployeeDAOImpl {

	private EmployeeDAO daoimpl = null;
	@Before
	public void setUp() throws Exception {
		daoimpl = FactoryEmployeeDAO.createEmployeeDAO();
	}

	@After
	public void tearDown() throws Exception {
		daoimpl = null;
	}

	@Test
	public void testPersistEmployeePositive() {
		System.out.println("\n<==== add emp =====>");
		Employee employee = new Employee();
		employee.setId(7);
		employee.setName("vishal7");
		employee.setSalary(70000);
		employee.setDesignation("DEVELOPER7");
		try {
			assertTrue(daoimpl.persistEmployee(employee));
			assertEquals(7, daoimpl.getEmployee(7).getId());
		} catch (ClassNotFoundException | SQLException e) {
			fail("Shouldn't throw error");
		}
	}

	@Test
	public void testUpdateEmployeeSalaryById() {
		try {
			assertTrue(daoimpl.updateEmployeeSalaryById(2, 2000000));
			assertEquals(2000000, daoimpl.getEmployee(2).getSalary());
		} catch (ClassNotFoundException | SQLException e) {
			fail("Shouldn't throw error");
		}
	}
	
	@Test
	public void testUpdateEmployeeSalaryById_UsingMerge() {
		try {
			assertTrue(daoimpl.updateEmployeeSalaryByIdUsingMerge(7, 7000000));
			assertEquals(2000000, daoimpl.getEmployee(2).getSalary());
		} catch (ClassNotFoundException | SQLException e) {
			fail("Shouldn't throw error");
		}
	}
	@Test
	public void testHibernateRefresh() {
		try {
			daoimpl.getEmployeeUsingRefresh(7);
		} catch (ClassNotFoundException | SQLException e) {
			fail("Shouldn't throw error");
		}
		
	}
	
	@Test
	public void testUsingCriteriaBuilder() {
		daoimpl.usingCriteriaBuilder();
	}
	@Test
	public void testDeleteEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testComputeTax() {
		try {
			System.out.println(daoimpl.computeTax(1));
		} catch (ClassNotFoundException | SQLException e) {
			fail("Shouldn't throw error");
		}
	}

}
