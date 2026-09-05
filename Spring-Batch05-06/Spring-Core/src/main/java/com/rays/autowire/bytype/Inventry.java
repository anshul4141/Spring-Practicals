package com.rays.autowire.bytype;

public class Inventry {

	private int stock;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int sold(int book) {
		this.stock = this.stock - book;
		return this.stock;
	}

}
