package com.rays.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("p")
public class Payment {

	@Value("100")
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double makePayment(double amt) {
		balance = balance - amt;
		return balance;
	}

}
