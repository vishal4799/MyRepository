package com.bmc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id
	@Column(name="id")
	private int id;
	//@Column is not mandatory if your column name and variable name are same.
	@Column(name="name")
	private String name;
	@Column(name="salary")
	private int salary;
	@Column(name="designation")
	private String designation;
	public Employee() {
	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+":"+name+":"+salary+":"+designation;
	}

}
