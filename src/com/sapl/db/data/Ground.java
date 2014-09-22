package com.sapl.db.data;

import java.io.Serializable;

public class Ground implements Serializable{
	private int id;
	private String groundName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getGroundName() {
		return groundName;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}

}
