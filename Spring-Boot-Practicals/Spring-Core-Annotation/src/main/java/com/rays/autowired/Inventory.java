package com.rays.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("inv")
public class Inventory {

	@Value("10")
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
