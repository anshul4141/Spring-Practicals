package com.rays.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("order")
public class Order {

	private Inventory inventory;
	private Payment payment;

	@Autowired
	public Order(Inventory inventory, Payment payment) {
		this.inventory = inventory;
		this.payment = payment;
	}

//	@Autowired
//	public void setInventory(Inventory inventory) {
//		this.inventory = inventory;
//	}
//
//	@Autowired
//	public void setPayment(Payment payment) {
//		this.payment = payment;
//	}

	public void placedOrder(int item) {

		int payingAmt = item * 100;
		System.out.println("total paying amount is: " + payingAmt);
		int remainingItem = inventory.bookSold(item);
		int remainingBalance = payment.pay(payingAmt);

		System.out.println("you order has been placed");

		System.out.println("your remainingBalance is: " + remainingBalance);
		System.out.println("remainingItem is: " + remainingItem);

	}

}
