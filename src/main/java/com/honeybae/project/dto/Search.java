package com.honeybae.project.dto;

public class Search {
	 private String brand;
	 private String type;
	 private int size;
	 private String color;
	 private boolean collaborationYn;
	 private int minPrice;
	 private int maxPrice;
	 private String name;
	 
	 
	public Search() {
	}

	public Search(String brand, String type, int size, String color, boolean collaborationYn, int minPrice,
			int maxPrice, String name) {
		super();
		this.brand = brand;
		this.type = type;
		this.size = size;
		this.color = color;
		this.collaborationYn = collaborationYn;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public boolean isCollaborationYn() {
		return collaborationYn;
	}


	public void setCollaborationYn(boolean collaborationYn) {
		this.collaborationYn = collaborationYn;
	}


	public int getMinPrice() {
		return minPrice;
	}


	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}


	public int getMaxPrice() {
		return maxPrice;
	}


	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	 
	 
	 
}
