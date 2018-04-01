package com.bmc.collection;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Employee extends Company  implements Externalizable{
	
	/**
	 * 
	 */
	
	public Employee(){}
	private static final long serialVersionUID = 1L;
	private int empId;
	private String empName;
	private double empSalary;
	private String empDesignation;
	public Employee(int companyId,String companyName,int empId, String empName, double empSalary,
			String empDesignation) {
		super(companyId,companyName);
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empDesignation = empDesignation;
	}
	public int getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empSalary=" + empSalary + ", empDesignation="
				+ empDesignation + "]";
	};
	
	public static int compareByEmpName(Employee e1, Employee e2) {
        return e1.empName.compareTo(e2.empName);
    }
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
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
	@Override
	public void readExternal(ObjectInput arg0) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		this.empId=arg0.readInt();
		this.empName=arg0.readUTF();
		this.empSalary=arg0.readDouble();
		this.empDesignation=arg0.readUTF();
		super.companyName=arg0.readUTF();
		
		
	}
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		
		arg0.writeInt(empId);
		arg0.writeUTF(empName);
		arg0.writeDouble(empSalary);
		arg0.writeUTF(empDesignation);
		arg0.writeUTF(super.companyName);
		
		
		
	}
	
	

}
