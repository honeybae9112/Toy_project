package com.honeybae.project.dto;

public class BiddVO {


	private int id;
	private int biddPrice;
	private String biddDate;
	private Product product;
	private Auction auction;


	public BiddVO(int id, int biddPrice, String biddDate, Product product, Auction auction) {
		super();
		this.id = id;
		this.biddPrice = biddPrice;
		this.biddDate = biddDate;
		this.product = product;
		this.auction = auction;
	}
	public int getId() {
		return id;
	}
	public int getBiddPrice() {
		return biddPrice;
	}
	public String getBiddDate() {
		return biddDate;
	}
	public Product getProduct() {
		return product;
	}
	public Auction getAuction() {
		return auction;
	}




}
