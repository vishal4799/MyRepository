package com.bmc.helper;

import java.util.ResourceBundle;

public class ResourceReader {
	private String driver;
	private String url;
	private String user;
	private String password;
	public ResourceReader(String baseName) {
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		this.driver = bundle.getString("driver");
		this.url = bundle.getString("url");
		this.user = bundle.getString("user");
		this.password = bundle.getString("password");
	}
	public String getDriver() {
		return driver;
	}
	public String getUrl() {
		return url;
	}
	public String getUser() {
		return user;
	}
	public String getPassword() {
		return password;
	}
	

}
