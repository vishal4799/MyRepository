package com.kpit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kpit.entities.Employee;
import com.kpit.helper.ConnectionManager;
@Repository
public class JDBCEmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private ConnectionManager manager;

	@Override
	public List<Employee> getAllEmployees() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=manager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from KPITEMPLOYEES");
		List<Employee> empList=new ArrayList<>();
		while(resultSet.next()){
			Employee employee=new Employee();
			employee.setEmpId(resultSet.getInt("emp_id"));
			employee.setEmpName(resultSet.getString("emp_name"));
			employee.setEmpSalary(resultSet.getDouble("emp_salary"));
			employee.setEmpDesignation(resultSet.getString("emp_designation"));
			empList.add(employee);
		}
		
		return empList;
	}

	@Override
	public boolean persistEmployee(Employee employee)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=manager.openConnection();
		PreparedStatement statement=connection.prepareStatement("insert into KPITEMPLOYEES values(?,?,?,?)");
		statement.setInt(1, employee.getEmpId());
		statement.setString(2,employee.getEmpName());
		statement.setDouble(3,employee.getEmpSalary());
		statement.setString(4, employee.getEmpDesignation());
		
		int rows=statement.executeUpdate();
		if(rows>0)
		return true;
		else
			return false;
	}

}
