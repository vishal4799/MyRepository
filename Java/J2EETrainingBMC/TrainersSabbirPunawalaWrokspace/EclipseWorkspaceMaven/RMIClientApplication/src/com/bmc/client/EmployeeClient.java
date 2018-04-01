package com.bmc.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.util.Scanner;

import com.bmc.controller.EmployeeControllerInterface;
import com.bmc.entities.Employee;

public class EmployeeClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		
	    System.setSecurityManager(new RMISecurityManager());
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Employee Id:");
		
		int empId=scanner.nextInt();
		
		EmployeeControllerInterface controllerIntf=(EmployeeControllerInterface)
				Naming.lookup("rmi://localhost:1099/controller");
		Employee employee=controllerIntf.retrieveEmployeeId(empId);
		System.out.println(employee);

	}

}
