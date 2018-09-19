package com.java.exam;

public class Service {

	private Taxable taxable;
	
	public Service(Taxable taxable) {
		this.taxable = taxable;
	}
	
	public double execute(double amount) {
		return taxable.computeTax(amount);
	}
	
}
