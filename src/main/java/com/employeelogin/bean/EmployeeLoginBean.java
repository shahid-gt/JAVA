package com.employeelogin.bean;

import java.io.Serializable;

public class EmployeeLoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	public EmployeeLoginBean() {
	}

	public EmployeeLoginBean(String u, String p) {
		username = u;
		password = p;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
