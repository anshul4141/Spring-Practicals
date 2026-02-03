package com.rays.ioc;

public class Order2 {

	private Payment payment;
	private Inventry inventry;

	public Order2(Payment payment, Inventry inventry) {
		this.payment = payment;
		this.inventry = inventry;
	}

	public Payment getPayment() {
		return payment;
	}

	public Inventry getInventry() {
		return inventry;
	}

	public void bookATicket(int items) {

		int price = 10;

		double totalAmount = items * price;

		double updatedBalance = payment.makePayment(totalAmount);

		int updatedStock = inventry.sold(items);

		System.out.println("Tickets are Booked");
		System.out.println("Total Amount Paid: " + totalAmount);
		System.out.println("Remaining Balance: " + updatedBalance);
		System.out.println("Total Booked Tickects: " + items);
		System.out.println("Updated Stock: " + updatedStock);
	}

}
