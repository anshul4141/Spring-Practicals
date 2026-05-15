package com.rays.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("order")
public class Order {

	@Autowired
	private Payment payment;

	@Autowired
	private Inventry inventry;

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
