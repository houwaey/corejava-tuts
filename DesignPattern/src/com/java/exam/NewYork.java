package com.java.exam;

public class NewYork implements Taxable {

	private double percentage = 6.50;
	
	@Override
	public double computeTax(double amount) {
		return amount * this.percentage;
	}

}
