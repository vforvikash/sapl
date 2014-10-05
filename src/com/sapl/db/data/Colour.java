package com.sapl.db.data;

import java.io.Serializable;

public class Colour implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String colourName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getColourName() {
		return colourName;
	}
	public void setColourName(String colourName) {
		this.colourName = colourName;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return (obj!=null && obj instanceof Colour && this.getId() > 0) ? this.getId()==((Colour)obj).getId() : false;
	}

}
