package com.sapl.db.data;

import java.io.Serializable;

public class Group implements Serializable{
	private int id;
	private String groupName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
