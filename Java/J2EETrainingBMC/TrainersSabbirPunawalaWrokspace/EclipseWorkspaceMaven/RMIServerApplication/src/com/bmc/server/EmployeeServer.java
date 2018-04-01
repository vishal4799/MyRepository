package com.bmc.server;

import java.rmi.Naming;

import com.bmc.controller.EmployeeControllerInterface;
import com.bmc.controller.EmployeeControllerInterfaceImpl;

public class EmployeeServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			EmployeeControllerInterface controller=new EmployeeControllerInterfaceImpl();

			Naming.rebind("controller",controller);
			}catch(Exception ne){
			ne.printStackTrace();
			}

			while(true){}


			}

	}


