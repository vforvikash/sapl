package com.sapl.db.data;

import java.io.Serializable;

public class Sample implements Serializable{

	private static final long serialVersionUID = 4L;
	private int id;
	private String name;
	private String desc;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String description) {
		this.desc = description;
	}


}
