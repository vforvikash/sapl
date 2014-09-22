package com.sapl.db.data;

import java.io.Serializable;

public class Loom implements Serializable{
	private int id;
	private String loomName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getLoomName() {
		return loomName;
	}
	public void setLoomName(String loomName) {
		this.loomName = loomName;
	}

}
