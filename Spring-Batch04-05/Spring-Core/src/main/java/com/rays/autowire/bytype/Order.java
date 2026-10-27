package com.rays.autowire.bytype;

public class Order {

	private Inventry inventry;
	private Payment payment;

	public Inventry getInventry() {
		return inventry;
	}

	public void setInventry(Inventry inventry) {
		this.inventry = inventry;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void makeOrder(int book) {

		int pricePerBook = 100;

		int totalPayingAmt = pricePerBook * book;
		int remainingamt = payment.pay(totalPayingAmt);
		int remainingstock = inventry.sold(book);

		System.out.println("your order is complited");
		System.out.println("total paying amount: " + totalPayingAmt);
		System.out.println("total book ordered: " + book);
		System.out.println("you remaining balance: " + remainingamt);
		System.out.println("remaining book stock: " + remainingstock);

	}

}
