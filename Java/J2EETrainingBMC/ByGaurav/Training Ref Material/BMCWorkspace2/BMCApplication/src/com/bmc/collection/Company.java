package com.bmc.collection;

import java.io.Serializable;

public class Company implements Serializable {
	
	public Company(){}
	
	protected int companyId;
	protected String companyName;
	public Company(int companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}
	public int getCompanyId() {
		return companyId;
	}
	public String getCompanyName() {
		return companyName;
	};
	
	

}
