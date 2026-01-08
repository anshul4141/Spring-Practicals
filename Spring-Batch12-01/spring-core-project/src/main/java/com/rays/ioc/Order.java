package com.rays.ioc;

public class Order {

	private Payment payment;
	private Inventry inventry;

	public Order(Payment payment, Inventry inventry) {
		this.payment = payment;
		this.inventry = inventry;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void setInventry(Inventry inventry) {
		this.inventry = inventry;
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
