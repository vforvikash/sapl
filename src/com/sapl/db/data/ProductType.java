package com.sapl.db.data;

import java.io.Serializable;

public class ProductType implements Serializable{
	private int id;
	private String productTypeName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getProductTypeName() {
		return productTypeName;
	}
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

}
