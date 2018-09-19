package com.sdp.strategy;

import com.sdp.interfaces.PaymentStrategy;

public class PayPalStrategy implements PaymentStrategy {

	private String emailAddress;
	private String password;
	
	public PayPalStrategy(String emailAddress, String password) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
	}

	@Override
	public void pay(double amount) {
		System.out.println(amount + " paid using paypal.");
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

}
