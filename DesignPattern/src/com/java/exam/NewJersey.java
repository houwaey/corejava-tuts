package com.java.exam;

public class NewJersey implements Taxable {

	private double percentage = 5.50;
	
	@Override
	public double computeTax(double amount) {
		return amount * this.percentage;
	}

}
