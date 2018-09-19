package com.creational.factory;

import com.model.commons.Shape;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		
		Shape s1 = ShapeFactory.getShape(ShapeFactory.CIRCLE);
		Shape s2 = ShapeFactory.getShape(ShapeFactory.RECTANGLE);
		Shape s3 = ShapeFactory.getShape(ShapeFactory.SQUARE);
		
		s1.draw();
		s2.draw();
		s3.draw();
		
	}
	
}
