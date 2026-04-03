package com.rays.ioc;

// by setter injection
public class Order1 {

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
