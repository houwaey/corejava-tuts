package com.java.exam;

public class DemoTax {

	public static void main(String[] args) {
		
		Service ny = new Service(new NewYork());
		Service nj = new Service(new NewJersey());
		Service ca = new Service(new California());
		
		System.out.println("NewYork ~ Amount: 1.00 ~ Tax: " + ny.execute(1.00));
		System.out.println("NewJersey ~ Amount: 1.00 ~ Tax: " + nj.execute(1.00));
		System.out.println("California ~ Amount: 1.00 ~ Tax: " + ca.execute(1.00));
		
	}
	
}
