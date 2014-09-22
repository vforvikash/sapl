package com.sapl.db.data;

import java.io.Serializable;

public class Texture implements Serializable{
	private int id;
	private String textureName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getTextureName() {
		return textureName;
	}
	public void setTextureName(String textureName) {
		this.textureName = textureName;
	}

}
