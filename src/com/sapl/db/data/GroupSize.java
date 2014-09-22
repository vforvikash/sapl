package com.sapl.db.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.AutoPopulatingList;

public class GroupSize implements Serializable{
	private int id;
	private String name;
	private String description;
	private int noOfSizes = 1;
	private Set<Size> sizes = new HashSet<Size>();
	private List<Size> sizeList = new AutoPopulatingList<Size>(Size.class);

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

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getNoOfSizes() {
		return noOfSizes;
	}
	public void setNoOfSizes(int noOfSizes) {
		this.noOfSizes = noOfSizes;
	}

	public Set<Size> getSizes() {
		this.sizes.addAll(this.sizeList);
		return sizes;
	}
	public void setSizes(Set<Size> sizes) {
		this.sizeList.addAll(sizes);
		this.sizes = sizes;
	}

	public List<Size> getSizeList() {
		return sizeList;
	}
	public void setSizeList(List<Size> sizeList) {
		this.sizeList = sizeList;
	}
}
