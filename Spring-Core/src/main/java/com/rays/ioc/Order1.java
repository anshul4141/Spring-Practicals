package com.rays.ioc;

public class Order1 {

	private Payment payment;
	private Inventory inventory;

	// Setter injection
	public void setpayment(Payment payment) {
		this.payment = payment;
	}

	// Setter injection
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void bookATicket(int items) {

		int price = 10;

		double totalAmount = items * price;

		double updatedBalance = payment.makePayment(totalAmount);

		int updatedStock = inventory.sold(items);

		System.out.println("Tickets are Booked");
		System.out.println("Total Amount Paid: " + totalAmount);
		System.out.println("Remaining Balance: " + updatedBalance);
		System.out.println("Total Booked Tickects: " + items);
		System.out.println("Updated Stock: " + updatedStock);
	}
}
