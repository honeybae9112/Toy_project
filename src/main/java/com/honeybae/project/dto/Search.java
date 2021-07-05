package com.honeybae.project.dto;

public class Search {
	 private int minPrice;
	 private int maxPrice;
	 
	 private String brand;
	 private String type;
	 private int	size;
	 private Boolean collaboration;
	 private Boolean retro;
	 private Boolean used;
	 private Boolean soldout;
	 
	public Search() {
	}

	public Search(int minPrice, int maxPrice, String brand, String type, int size, Boolean collaboration, Boolean retro,
			Boolean used, Boolean soldout) {
		super();
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.brand = brand;
		this.type = type;
		this.size = size;
		this.collaboration = collaboration;
		this.retro = retro;
		this.used = used;
		this.soldout = soldout;
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

	public Boolean getCollaboration() {
		return collaboration;
	}

	public void setCollaboration(Boolean collaboration) {
		this.collaboration = collaboration;
	}

	public Boolean getRetro() {
		return retro;
	}

	public void setRetro(Boolean retro) {
		this.retro = retro;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

	public Boolean getSoldout() {
		return soldout;
	}

	public void setSoldout(Boolean soldout) {
		this.soldout = soldout;
	}

	
	
	
	 
	


	

	
	
	




	 
	 
	 
}
