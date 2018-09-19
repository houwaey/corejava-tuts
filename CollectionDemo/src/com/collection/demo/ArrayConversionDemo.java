package com.collection.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayConversionDemo {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		System.out.println(list);
		System.out.println();
		
		String[] items = list.toArray(new String[list.size()]);
		for (String item : items) {
			System.out.println(item);
		}
		System.out.println();
		
		List<String> newList = Arrays.asList(items);
		System.out.println(newList);
		
	}
	
}
