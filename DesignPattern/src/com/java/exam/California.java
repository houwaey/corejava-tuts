package com.java.exam;

public class California implements Taxable {

	private double percentage = 6.125;
	
	@Override
	public double computeTax(double amount) {
		return amount * this.percentage;
	}
 
}
