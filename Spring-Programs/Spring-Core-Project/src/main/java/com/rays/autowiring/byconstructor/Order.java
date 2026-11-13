package com.rays.autowiring.byconstructor;

public class Order {

	private Inventory inventory;
	private Payment payment;

	public Order(Inventory inventory, Payment payment) {
		this.inventory = inventory;
		this.payment = payment;
	}

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
