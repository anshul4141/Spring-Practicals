package com.rays.autowiring.bytype;

public class Inventory {

	private int stock;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int bookSold(int book) {
		stock = stock - book;
		return stock;
	}

}
