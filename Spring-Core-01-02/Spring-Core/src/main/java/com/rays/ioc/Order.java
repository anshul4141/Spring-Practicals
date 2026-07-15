package com.rays.ioc;

public class Order {

	private Inventory inventory;
	private Payment payment;

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void order(int item) {

		int perItem = 100;

		int totalAmount = item * perItem;

		int remainingAmt = payment.pay(totalAmount);

		int remainingBooks = inventory.sold(item);

		System.out.println("amount paid: " + totalAmount);
		System.out.println("book ordered: " + item);
		System.out.println("remaining amt: " + remainingAmt);
		System.out.println("remaining book: " + remainingBooks);

	}

}
