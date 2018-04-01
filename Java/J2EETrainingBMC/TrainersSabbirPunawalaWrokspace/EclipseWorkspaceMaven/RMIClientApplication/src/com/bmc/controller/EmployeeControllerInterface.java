package com.bmc.controller;

import java.rmi.RemoteException;

import com.bmc.entities.Employee;

public interface EmployeeControllerInterface {
	public Employee retrieveEmployeeId(int empId) throws RemoteException;

}
