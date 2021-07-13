package com.honeybae.project.dto;

public class Search extends Pagination{
	 private int minPrice;
	 private int maxPrice;
	 private String brand;
	 private String category;
	 private int	size;
	 private Boolean collaboration;
	 private Boolean retro;
	 private Boolean used;
	 private Boolean soldout;
	 
	public Search() {
	}

	public Search(int minPrice, int maxPrice, String brand, String category, int size, Boolean collaboration,
			Boolean retro, Boolean used, Boolean soldout) {
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.brand = brand;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
	

	@Override
	public String toString() {
		return "Search [minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", brand=" + brand + ", category=" + category
				+ ", size=" + size + ", collaboration=" + collaboration + ", retro=" + retro + ", used=" + used
				+ ", soldout=" + soldout + "]";
	}

}
