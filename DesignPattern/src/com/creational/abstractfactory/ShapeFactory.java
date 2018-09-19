package com.creational.abstractfactory;

import com.model.commons.Circle;
import com.model.commons.Color;
import com.model.commons.Rectangle;
import com.model.commons.Shape;
import com.model.commons.Square;

public class ShapeFactory extends AbstractFactory {

	public static final String CIRCLE = "CIRCLE";
	public static final String RECTANGLE = "RECTANGLE";
	public static final String SQUARE = "SQUARE";
	
	@Override
	Color getColor(String color) {
		return null;
	}

	@Override
	Shape getShape(String shape) {
		
		if (shape == null) {
			return null;
		}
		
		if (CIRCLE.equalsIgnoreCase(shape)) {
			return new Circle();
		} else if (RECTANGLE.equalsIgnoreCase(shape)) {
			return new Rectangle();
		} else if (SQUARE.equalsIgnoreCase(shape)) {
			return new Square();
		}
		
		return null;
	}

}
