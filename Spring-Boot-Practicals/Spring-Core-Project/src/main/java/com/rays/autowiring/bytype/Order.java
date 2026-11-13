package com.rays.autowiring.bytype;

public class Order {

	private Inventory inventory;
	private Payment payment;

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
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
