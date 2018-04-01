package com.bmc.collections;

import java.io.Serializable;

public class Employee implements Comparable<Employee>{
	
	private int empId;
	private String empName;
	private double empSalary;
	private String empDesignation;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public Employee(int empId, String empName, double empSalary,
			String empDesignation) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDesignation = empDesignation;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empSalary=" + empSalary + ", empDesignation="
				+ empDesignation + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((empDesignation == null) ? 0 : empDesignation.hashCode());
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(empSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empDesignation == null) {
			if (other.empDesignation != null)
				return false;
		} else if (!empDesignation.equals(other.empDesignation))
			return false;
		if (empId != other.empId)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (Double.doubleToLongBits(empSalary) != Double
				.doubleToLongBits(other.empSalary))
			return false;
		return true;
	}
	
	public static int compareByName(Employee e1,Employee e2){
		
		return e1.empName.compareTo(e2.empName);
	}
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		
		return this.empName.compareTo(o.empName);
	
	}

}
