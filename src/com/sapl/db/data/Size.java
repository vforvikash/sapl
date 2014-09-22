package com.sapl.db.data;

import java.io.Serializable;

public class Size implements Serializable{
	private int id;
	private String sizeName;
	private GroupSize group;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public GroupSize getGroup() {
		return group;
	}
	public void setGroup(GroupSize group) {
		this.group = group;
	}
}
