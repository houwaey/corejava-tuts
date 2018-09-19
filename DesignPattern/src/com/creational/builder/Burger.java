package com.creational.builder;

import com.model.commons.Item;
import com.model.commons.Packing;

public abstract class Burger implements Item {

	@Override
	public Packing packing() {
		return new Wrapper();
	}

	@Override
	public abstract float price();
	
}
