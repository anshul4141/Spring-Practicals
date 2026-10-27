package com.rays.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("payment")
public class Payment {

	@Value("1000")
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
