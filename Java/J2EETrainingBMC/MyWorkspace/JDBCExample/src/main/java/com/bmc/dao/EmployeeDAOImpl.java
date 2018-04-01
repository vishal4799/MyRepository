package com.bmc.dao;
//Declaration of CRUD operation for Domain Class-Employee

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bmc.entities.Employee;
import com.bmc.helper.ConnectionManager;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private ConnectionManager manager = new ConnectionManager();
	
	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException{
		Connection connection = manager.openConnection();
		Statement stmt = (Statement) connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
		List<Employee> empList = new ArrayList<>();
		while(rs.next()){
			Employee employee = new Employee();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setSalary(rs.getInt("salary"));
			employee.setDesignation(rs.getString("designation"));
			empList.add(employee);
		}
		ConnectionManager.closeConnection();
		return empList;
	}
	public Employee getEmployee(int id) throws ClassNotFoundException, SQLException{
		Connection connection = manager.openConnection();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID =?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setSalary(rs.getInt("salary"));
		employee.setDesignation(rs.getString("designation"));
		ConnectionManager.closeConnection();
		return employee;
	}
	public boolean persistEmployee(Employee employee) throws ClassNotFoundException, SQLException{
		Connection connection = manager.openConnection();
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?)");
		stmt.setInt(1, employee.getId());
		stmt.setString(2, employee.getName());
		stmt.setInt(3, employee.getSalary());
		stmt.setString(4, employee.getDesignation());
		boolean r = stmt.executeUpdate() > 0;
		ConnectionManager.closeConnection();
		return r;
	}
	public boolean updateEmployeeSalaryById(int id, int newSalary) throws ClassNotFoundException, SQLException{
		Connection connection = manager.openConnection();
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("UPDATE EMPLOYEE SET SALARY = ? WHERE ID =?");
		stmt.setInt(2, newSalary);
		stmt.setInt(2, id);
		boolean r = stmt.executeUpdate() > 0;
		ConnectionManager.closeConnection();
		return r;
	}
	public boolean deleteEmployee(int id) throws ClassNotFoundException{
		return false;
	}
	public int computeTax(int id) throws ClassNotFoundException, SQLException{
		Connection connection = manager.openConnection();
		java.sql.CallableStatement stmt = connection.prepareCall("{call COMPUTETAX(?,?)}");
		stmt.registerOutParameter(2, Types.INTEGER);
		stmt.setInt(1, id);
		stmt.execute();
		int result = stmt.getInt(2);
		ConnectionManager.closeConnection();
		return result;
	}
}
