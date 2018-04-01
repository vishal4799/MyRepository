package com.bmc.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bmc.entities.Employee;
import com.bmc.helper.Query;
@Repository
public class SpringJDBCEmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbctemplate;
	@Autowired
	private Query query;

	
	@Override
	public List<Employee> getAllEmployees() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		
		if(jdbctemplate==null){
			System.out.println("is null");
		}
		List<Employee> empList=jdbctemplate.query(query.getSelectQuery(), new EmployeeMapper());
		
		return empList;
	}

	@Override
	public Employee getEmployee(int empId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean persistEmployee(Employee employee)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
Object data[]={employee.getEmpId(),employee.getEmpName(),employee.getEmpSalary(),employee.getEmpDesignation()};
		
		int rows=jdbctemplate.update(query.getInsertQuery(), data);
		if(rows>0)
			return true;
		else
		return false;
		
	}

	@Override
	public boolean updateEmployeeSalaryById(int empId, double newSalary)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
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
