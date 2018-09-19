package com.sdp.model;

public class Item {

	private String code;
	private double price;
	
	public Item(String code, double price) {
		super();
		this.code = code;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public double getPrice() {
		return price;
	}
	
}