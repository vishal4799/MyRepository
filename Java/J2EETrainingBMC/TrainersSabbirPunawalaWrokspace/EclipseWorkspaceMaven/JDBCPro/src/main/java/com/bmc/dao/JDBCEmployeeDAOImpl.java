package com.bmc.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.bmc.entities.Employee;
import com.bmc.helper.ConnectionManager;

public class JDBCEmployeeDAOImpl implements EmployeeDAO {
	

	public List<Employee> getAllEmployees() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from EMPLOYEEBMCTABLE");
		List<Employee> empList=new ArrayList<>();
		while(resultSet.next()){
			Employee employee=new Employee();
			employee.setEmpId(resultSet.getInt("emp_id"));
			employee.setEmpName(resultSet.getString("emp_name"));
			employee.setEmpSalary(resultSet.getDouble("emp_salary"));
			employee.setEmpDesignation(resultSet.getString("emp_designation"));
			empList.add(employee);
		}
		ConnectionManager.closeConnection();
		
		return empList;
	}

	public Employee getEmployee(int empId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=connection.prepareStatement("select * from EMPLOYEEBMCTABLE where emp_id=?");
		statement.setInt(1, empId);
		ResultSet resultSet=statement.executeQuery();
		Employee employee=new Employee();
		while(resultSet.next()){
		
		employee.setEmpId(resultSet.getInt("emp_id"));
		employee.setEmpName(resultSet.getString("emp_name"));
		employee.setEmpSalary(resultSet.getDouble("emp_salary"));
		employee.setEmpDesignation(resultSet.getString("emp_designation"));
		}
		ConnectionManager.closeConnection();
		return employee;
	}

	public boolean persistEmployee(Employee employee)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=connection.prepareStatement("insert into EMPLOYEEBMCTABLE values(?,?,?,?)");
		statement.setInt(1, employee.getEmpId());
		statement.setString(2, employee.getEmpName());
		statement.setDouble(3,employee.getEmpSalary());
		statement.setString(4, employee.getEmpDesignation());
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0)
			return true;
		else
		return false;
	}

	public boolean updateEmployeeSalaryById(int empId, double newSalary)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=connection.prepareStatement("update EMPLOYEEBMCTABLE set emp_salary=? where emp_id=?");
		statement.setDouble(1, newSalary);
		statement.setInt(2, empId);
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		if(rows>0)
			return true;
		else
		return false;
	}

	public boolean deleteEmployee(int empId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public double computeTax(int empId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		CallableStatement statement=connection.prepareCall("{call COMPUTETAX(?,?) }");
		statement.registerOutParameter(2, Types.DOUBLE);
		statement.setInt(1, empId);
		statement.execute();
		double result=statement.getDouble(2);
		ConnectionManager.closeConnection();
		return result;
	}

}
