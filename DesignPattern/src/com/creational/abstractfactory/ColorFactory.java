package com.creational.abstractfactory;

import com.model.commons.Blue;
import com.model.commons.Color;
import com.model.commons.Green;
import com.model.commons.Red;
import com.model.commons.Shape;

public class ColorFactory extends AbstractFactory {

	public static final String RED = "RED";
	public static final String GREEN = "GREEN";
	public static final String BLUE = "BLUE";
	
	@Override
	Color getColor(String color) {
		
		if (color == null) {
			return null;
		}
		
		if (RED.equalsIgnoreCase(color)) {
			return new Red();
		} else if (GREEN.equalsIgnoreCase(color)) {
			return new Green();
		} else if (BLUE.equalsIgnoreCase(color)) {
			return new Blue();
		}
		
		return null;
	}

	@Override
	Shape getShape(String shape) {
		return null;
	}

}
