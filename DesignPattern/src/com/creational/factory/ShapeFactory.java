package com.creational.factory;

import com.model.commons.Circle;
import com.model.commons.Rectangle;
import com.model.commons.Shape;
import com.model.commons.Square;

public class ShapeFactory {

	public static final String CIRCLE = "CIRCLE";
	public static final String RECTANGLE = "RECTANGLE";
	public static final String SQUARE = "SQUARE";
	
	public static Shape getShape(String type) {
		
		if (type == null) {
			return null;
		}
		
		if (CIRCLE.equalsIgnoreCase(type)) {
			return new Circle();
		} else if (RECTANGLE.equalsIgnoreCase(type)) {
			return new Rectangle();
		} else if (SQUARE.equalsIgnoreCase(type)) {
			return new Square();
		}
		
		return null;

	}
	
}