package com.sdp.strategy;

import com.sdp.interfaces.PaymentStrategy;

public class CreditCardStrategy implements PaymentStrategy {
	
	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;

	public CreditCardStrategy(String name, String cardNumber, String cvv,
			String dateOfExpiry) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpiry = dateOfExpiry;
	}

	@Override
	public void pay(double amount) {
		System.out.println(amount + " paid with credit/debit card.");
	}

	public String getName() {
		return name;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public String getDateOfExpiry() {
		return dateOfExpiry;
	}

}
