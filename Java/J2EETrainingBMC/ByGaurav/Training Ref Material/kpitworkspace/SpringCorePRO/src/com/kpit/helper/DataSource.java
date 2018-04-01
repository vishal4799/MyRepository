package com.kpit.helper;

public class DataSource {
	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public DataSource(String driver,String url,String username,String password){
		
		this.driver=driver;
		this.url=url;
		this.username=username;
		this.password=password;
	}

	public String getDriver() {
		return driver;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "DataSource [driver=" + driver + ", url=" + url + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
	
	

}
