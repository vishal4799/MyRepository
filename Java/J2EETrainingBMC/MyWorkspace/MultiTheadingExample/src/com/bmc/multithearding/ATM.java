package com.bmc.multithearding;

public class ATM {
	private String bankName;
	private String location;
	
	public ATM(String bankName, String location) {
		this.bankName = bankName;
		this.location = location;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
