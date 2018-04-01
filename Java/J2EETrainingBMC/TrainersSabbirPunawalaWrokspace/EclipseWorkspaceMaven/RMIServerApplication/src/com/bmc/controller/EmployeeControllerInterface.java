package com.bmc.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.bmc.entities.Employee;

public interface EmployeeControllerInterface extends Remote{
	
	public Employee retrieveEmployeeId(int empId) throws RemoteException;

}
