package com.bmc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bmc.entities.Employee;
import com.bmc.helper.ConnectionManager;

public class JDBCEmployeeDAOImpl implements EmployeeDAO {
	
	ConnectionManager manager=new ConnectionManager();

	@Override
	public Employee findEmployeeById(int empId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=manager.openConnection();
		PreparedStatement statement=connection.prepareStatement("select * from employees where employee_id=?");
		statement.setInt(1, empId);
		ResultSet resultSet=statement.executeQuery();
		Employee employee=new Employee();
		while(resultSet.next()){
			employee.setEmpId(resultSet.getInt("employee_id"));
			employee.setEmpName(resultSet.getString("employee_name"));
			employee.setEmpSalary(resultSet.getDouble("employee_salary"));
			employee.setEmpDesignation(resultSet.getString("employee_designation"));
		}
		return employee;
	}

	@Override
	public boolean persistEmployee(Employee employee)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=manager.openConnection();
		connection.setAutoCommit(false);
		
		PreparedStatement statement=connection.prepareStatement("insert into employees values(?,?,?,?)");
		statement.setInt(1, employee.getEmpId());
		statement.setString(2, employee.getEmpName());
		statement.setDouble(3, employee.getEmpSalary());
		statement.setString(4, employee.getEmpDesignation());
		int rows=statement.executeUpdate();
		connection.commit();
		if(rows>0)
			return true;
		else
		return false;
	}

	@Override
	public boolean updateEmployeeSalaryById(int empId, double newSalary)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=manager.openConnection();
		PreparedStatement statement=connection.prepareStatement("update employees set employee_salary=? where employee_id=?");
		statement.setDouble(1, newSalary);
		statement.setInt(2, empId);
		int rows=statement.executeUpdate();
		if(rows>0)
		return true;
		else
		return false;
	}

	@Override
	public boolean removeEmployee(int empId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection connection=manager.openConnection();
		
		PreparedStatement statement=connection.prepareStatement("delete employees where employee_id=?");
        statement.setInt(1, empId);
        int rows=statement.executeUpdate();
        if(rows>0)
    		return true;
    		else
    		return false;
		
	}

	@Override
	public List<Employee> getAllEmployees() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection connection=manager.openConnection();
        Statement statement=connection.createStatement();
        List<Employee> employees=new ArrayList<Employee>();
        ResultSet resultSet=statement.executeQuery("select * from employees order by employee_name");
        while(resultSet.next()){
        	Employee employee=new Employee();
        	employee.setEmpId(resultSet.getInt("employee_id"));
        	employee.setEmpName(resultSet.getString("employee_name"));
        	employee.setEmpSalary(resultSet.getDouble("employee_salary"));
        	employee.setEmpDesignation(resultSet.getString("employee_designation"));
        	employees.add(employee);
        }
        manager.closeConnection();
		return employees;
	}

}
