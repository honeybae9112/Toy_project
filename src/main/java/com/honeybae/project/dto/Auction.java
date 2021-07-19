package com.honeybae.project.dto;

public class Auction {
	private int id;
	private int productId;
	private String startDate;
	private String endDate;
	private int currentPrice;
	private int auctionState;

	public Auction() {
	}

	public Auction(int id, int productId, String startDate, String endDate, int currentPrice, int auctionState) {
		super();
		this.id = id;
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getAuctionState() {
		return auctionState;
	}

	public void setAuctionState(int auctionState) {
		this.auctionState = auctionState;
	}

	@Override
	public String toString() {
		return "Auction [id=" + id + ", productId=" + productId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", currentPrice=" + currentPrice + ", auctionState=" + auctionState + "]";
	}

}
