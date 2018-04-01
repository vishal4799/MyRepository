package com.bmc.controller;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.bmc.entities.Employee;
import com.bmc.helper.FactoryEmployeeService;
import com.bmc.service.EmployeeService;

public class EmployeeControllerInterfaceImpl extends UnicastRemoteObject implements
		EmployeeControllerInterface,Serializable {

	public EmployeeControllerInterfaceImpl() throws RemoteException
	{
		super();
		
	}
	@Override
	public Employee retrieveEmployeeId(int empId) throws RemoteException {
		// TODO Auto-generated method stub
		
		EmployeeService employeeService=FactoryEmployeeService.createEmployeeService();
		Employee employee=employeeService.getEmployeeById(empId);
		return employee;
	}

}
