package com.honeybae.project.dto;

public class Search extends Pagination{
	 private Integer minPrice;
	 private Integer maxPrice;
	 private String brand;
	 private String category;
	 private int	size;
	 private Boolean collaboration;
	 private Boolean retro;
	 private Boolean used;
	 private Integer sellStatus;

	public Search() {
	}

	public Search(Integer minPrice, Integer maxPrice, String brand, String category, int size, Boolean collaboration,
			Boolean retro, Boolean used, Integer sellStatus) {
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.brand = brand;
		this.category = category;
		this.size = size;
		this.collaboration = collaboration;
		this.retro = retro;
		this.used = used;
		this.sellStatus = sellStatus;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
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

	public Integer getSellStatus() {
		return sellStatus;
	}

	public void setSellStatus(Integer sellStatus) {
		this.sellStatus = sellStatus;
	}


	@Override
	public String toString() {
		return "Search [minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", brand=" + brand + ", category=" + category
				+ ", size=" + size + ", collaboration=" + collaboration + ", retro=" + retro + ", used=" + used
				+ ", sellStatus=" + sellStatus + "]";
	}

}
