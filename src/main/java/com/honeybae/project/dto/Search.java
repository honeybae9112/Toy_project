package com.honeybae.project.dto;

public class Search {
	 private int minPrice;
	 private int maxPrice;
	 
	 private String brand;
	 private String type;
	 private int	size;
	 private boolean collaboration;
	 private boolean retro;
	 private boolean used;
	 private boolean soldout;
	 
	public Search() {
	}

	public Search(int minPrice, int maxPrice, String brand, String type, int size, boolean collaboration, boolean retro,
			boolean used, boolean soldout) {
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

	public boolean isCollaboration() {
		return collaboration;
	}

	public void setCollaboration(boolean collaboration) {
		this.collaboration = collaboration;
	}

	public boolean isRetro() {
		return retro;
	}

	public void setRetro(boolean retro) {
		this.retro = retro;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public boolean isSoldout() {
		return soldout;
	}

	public void setSoldout(boolean soldout) {
		this.soldout = soldout;
	}

	
	
	
	 
	


	

	
	
	




	 
	 
	 
}
