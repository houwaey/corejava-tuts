package com.sdp.context;

import java.util.ArrayList;
import java.util.List;

import com.sdp.interfaces.PaymentStrategy;
import com.sdp.model.Item;

public class ShoppingCart {

	private List<Item> items;
	
	public ShoppingCart() {
		this.items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void removeItem(Item item) {
		this.items.remove(item);
	}
	
	public double calculateTotal() {
		double sum = 0.0;
		for (Item item : this.items) {
			sum += item.getPrice();
		}
		return sum;
	}
	
	public void pay(PaymentStrategy paymentMethod) {
		double totalAmount = calculateTotal();
		paymentMethod.pay(totalAmount);
	}
	
}
