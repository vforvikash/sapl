package com.sapl.db.data;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 2L;

	private int id;
	private String loginName;
	private String password;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
