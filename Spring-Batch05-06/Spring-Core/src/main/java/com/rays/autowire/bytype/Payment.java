package com.rays.autowire.bytype;

public class Payment {

	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int pay(int amount) {
		this.balance = this.balance - amount;
		return this.balance;
	}

}
