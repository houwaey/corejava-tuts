package com.creational.abstractfactory;

import com.model.commons.Color;
import com.model.commons.Shape;

public abstract class AbstractFactory {

	abstract Color getColor(String color);
	abstract Shape getShape(String shape);
	
}
