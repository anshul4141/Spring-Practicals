package com.rays.autowire;

import org.springframework.beans.factory.annotation.Autowired;

public class Order {

	@Autowired
//	@Qualifier("inventory") this annotation is used to by-name autowire
	private Inventory inventory;

	@Autowired
	private Payment payment;
	
	public void makeOrder(int book) {

		int pricePerBook = 100;

		int totalPayingAmt = pricePerBook * book;
		int remainingamt = payment.pay(totalPayingAmt);
		int remainingstock = inventory.sold(book);

		System.out.println("your order is complited");
		System.out.println("total paying amount: " + totalPayingAmt);
		System.out.println("total book ordered: " + book);
		System.out.println("you remaining balance: " + remainingamt);
		System.out.println("remaining book stock: " + remainingstock);

	}

}
