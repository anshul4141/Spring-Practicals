package com.rays.autowiring.byname;

public class Payment {

	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int pay(int amount) {

		balance = balance - amount;

		return balance;

	}

}
