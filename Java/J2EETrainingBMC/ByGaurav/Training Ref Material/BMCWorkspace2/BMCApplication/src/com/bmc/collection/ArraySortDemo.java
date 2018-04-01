package com.bmc.collection;


import java.util.Arrays;
import java.util.Comparator;


public class ArraySortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Before Java 8
		
	    String[] names = {"Sabbir","Amit","Sachin","Rakesh"};
	    
	    Arrays.sort(names);
	  
	    System.out.println(Arrays.toString(names));

	    //After Java 8
	    
	    Arrays.sort(names, Comparator.comparing(String::length));	    
	    System.out.println(Arrays.toString(names));

	   Employee employees[]=new Employee[]{new Employee(1,"BMC",101,"Sabbir",4500,"Trainer"),new Employee(1,"BMC",102,"Amit",14500,"Trainer"),new Employee(1,"BMC",103,"Rakesh",5500,"Trainer")};
	   
	   Arrays.sort(employees,new Comparator<Employee>(){
		   
		   @Override
		   public int compare(Employee e1,Employee e2){
			   
			   if(e1.getEmpSalary()>e2.getEmpSalary()){
				   return 1;
			   }
			   else if(e1.getEmpSalary()<e2.getEmpSalary()){
				   return -1;
			   }
			   else{
				   
				   return 0;
			   }
			   
		   }
		   
	   }
			   
			   
			   
			   );
	   
	   //Java 8
	   
		Comparator<Employee> sortByEmpSalary =(Employee e1, Employee e2)->
		{
			if(e1.getEmpSalary()>e2.getEmpSalary())
		{
			return 1;
		}
			else if (e1.getEmpSalary()<e2.getEmpSalary()){
				return -1;
			}
			else{
				return 0;
			}
		};
		
		Arrays.sort(employees,sortByEmpSalary);
	   
	}

}
