package com.honeybae.project.dto;

public class AuctionVO  {
	private int id;
	private Product product;

	private String startDate;
	private String endDate;
	private int currentPrice;
	private int auctionState;

	public AuctionVO(int id,Product product, String startDate, String endDate, int currentPrice, int auctionState) {
		this.product = product;
		this.startDate = startDate;
		this.endDate = endDate;
		this.currentPrice = currentPrice;
		this.auctionState = auctionState;
	}
	public int getId() {
		return id;
	}
	public Product getProduct() {
		return product;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public int getAuctionState() {
		return auctionState;
	}


}
