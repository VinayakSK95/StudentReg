package com.example.demo.model;

public class LoginObject {

	String username;
	String password;
	
	public LoginObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginObject(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginObject [userName=" + username + ", password=" + password + "]";
	}
	
	
}
