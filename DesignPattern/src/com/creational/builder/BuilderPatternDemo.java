package com.creational.builder;

public class BuilderPatternDemo {

	public static void main(String[] args) {
		
		MealBuilder builder = new MealBuilder();
		
		Meal vegMeal = builder.prepareVegMeal();
		System.out.println("Veg Meals");
		vegMeal.showItems();
		System.out.println("Total Cost: " + vegMeal.getCost());
		
		System.out.println();
		System.out.println();
		
		Meal nonVegMeal = builder.prepareNonVegMeal();
		System.out.println("Non-Veg Meals");
		nonVegMeal.showItems();
		System.out.println("Total Cost: " + nonVegMeal.getCost());
	}
	
}
