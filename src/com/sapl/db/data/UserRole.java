package com.sapl.db.data;

import java.io.Serializable;

public class UserRole implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id;
	private String userId;
	private String userRole;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


}
