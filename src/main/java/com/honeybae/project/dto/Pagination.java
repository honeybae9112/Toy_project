package com.honeybae.project.dto;

public class Pagination {
	private int currentPage;
	private int pageRowSize;
	
	public Pagination() {
		this.currentPage=1;
		this.pageRowSize=10;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageRowSize() {
		return pageRowSize;
	}

	public void setPageRowSize(int pageRowSize) {
		this.pageRowSize = pageRowSize;
	}
	
	public int getStartPage() {
		return (currentPage-1)  * pageRowSize;
	}
	
	
	
	
}
