package com.creational.abstractfactory;

import com.model.commons.Color;
import com.model.commons.Shape;

public class AbstractFactoryPatternDemo {

	public static void main(String[] args) {

		AbstractFactory shapeFactory = FactoryProducer.getFactory(FactoryProducer.SHAPE);
		Shape s1 = shapeFactory.getShape(ShapeFactory.CIRCLE);
		Shape s2 = shapeFactory.getShape(ShapeFactory.RECTANGLE);
		Shape s3 = shapeFactory.getShape(ShapeFactory.SQUARE);
		
		AbstractFactory colorFactory = FactoryProducer.getFactory(FactoryProducer.COLOR);
		Color c1 = colorFactory.getColor(ColorFactory.RED);
		Color c2 = colorFactory.getColor(ColorFactory.GREEN);
		Color c3 = colorFactory.getColor(ColorFactory.BLUE);
		
		s1.draw();
		s2.draw();
		s3.draw();
		
		c1.fill();
		c2.fill();
		c3.fill();
		
	}
	
}
