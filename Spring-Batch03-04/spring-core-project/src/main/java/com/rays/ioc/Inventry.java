package com.rays.ioc;

public class Inventry {

	private int stock;

	public Inventry() {

	}

	public Inventry(int stock) {
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int sold(int qty) {
		stock -= qty; // stock = stock - qty;
		return stock;
	}

}
