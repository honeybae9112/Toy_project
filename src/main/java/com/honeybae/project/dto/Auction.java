package com.honeybae.project.dto;

public class Auction {
	private int id;
	private int productId;
	private String startDate;
	private String endDate;
	private Integer minPrice;
	private Integer maxPrice;
	private Integer currentPrice;
	private int auctionState;

	public Auction() {
	}

	public Auction(int id, int productId, String startDate, String endDate, Integer minPrice, Integer maxPrice,
			Integer currentPrice, int auctionState) {
		super();
		this.id = id;
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.currentPrice = currentPrice;
		this.auctionState = auctionState;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public Integer getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Integer currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getAuctionState() {
		return auctionState;
	}

	public void setAuctionState(int auctionState) {
		this.auctionState = auctionState;
	}


}
