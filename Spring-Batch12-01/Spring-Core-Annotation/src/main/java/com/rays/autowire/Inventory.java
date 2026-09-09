package com.rays.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("inventory")
public class Inventory {
	
	@Value("10")
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
