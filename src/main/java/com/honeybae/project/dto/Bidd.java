package com.honeybae.project.dto;

public class Bidd {
	private int id;
	private int auctionId;
	private int bidderId;
	private int biddPrice;
	private String biddDate;
	private boolean successfulFlag;
	private boolean deleteFlag;
	
	public Bidd() {
	}

	public Bidd(int id, int auctionId, int bidderId, int biddPrice, String biddDate, boolean successfulFlag,
			boolean deleteFlag) {
		super();
		this.id = id;
		this.auctionId = auctionId;
		this.bidderId = bidderId;
		this.biddPrice = biddPrice;
		this.biddDate = biddDate;
		this.successfulFlag = successfulFlag;
		this.deleteFlag = deleteFlag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public int getBidderId() {
		return bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public int getBiddPrice() {
		return biddPrice;
	}

	public void setBiddPrice(int biddPrice) {
		this.biddPrice = biddPrice;
	}

	public String getBiddDate() {
		return biddDate;
	}

	public void setBiddDate(String biddDate) {
		this.biddDate = biddDate;
	}

	public boolean isSuccessfulFlag() {
		return successfulFlag;
	}

	public void setSuccessfulFlag(boolean successfulFlag) {
		this.successfulFlag = successfulFlag;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "Bidd [id=" + id + ", auctionId=" + auctionId + ", bidderId=" + bidderId + ", biddPrice=" + biddPrice
				+ ", biddDate=" + biddDate + ", successfulFlag=" + successfulFlag + ", deleteFlag=" + deleteFlag + "]";
	}

}
