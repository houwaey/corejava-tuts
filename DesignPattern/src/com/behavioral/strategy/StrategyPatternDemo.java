package com.behavioral.strategy;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 5;
		
		Context ctx = new Context(new OperationAdd());
		System.out.println("10 + 5 = " + ctx.executeStrategy(num1, num2));
		
		ctx = new Context(new OperationSubtract());
		System.out.println("10 - 5 = " + ctx.executeStrategy(num1, num2));
		
		ctx = new Context(new OperationMultiply());
		System.out.println("10 * 5 = " + ctx.executeStrategy(num1, num2));
 		
	}
	
}
