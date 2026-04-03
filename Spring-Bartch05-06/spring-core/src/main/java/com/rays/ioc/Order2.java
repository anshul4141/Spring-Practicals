package com.rays.ioc;

// by constructor injection
public class Order2 {

	private Inventory inventory;
	private Payment payment;

	public Order2(Inventory inventory, Payment payment) {
		this.inventory = inventory;
		this.payment = payment;
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
