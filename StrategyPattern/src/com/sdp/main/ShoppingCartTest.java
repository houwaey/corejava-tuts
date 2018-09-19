package com.sdp.main;

import com.sdp.context.ShoppingCart;
import com.sdp.model.Item;
import com.sdp.strategy.CreditCardStrategy;
import com.sdp.strategy.PayPalStrategy;

public class ShoppingCartTest {

	public static void main(String[] args) {
		
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Item("1234", 10.50));
		cart.addItem(new Item("5678", 40.00));
		
		cart.pay(new PayPalStrategy("username@email.com", "mypass"));
		cart.pay(new CreditCardStrategy("Paulo Marquez", "1234567890", "786", "12/20"));
		
	}
	
}
