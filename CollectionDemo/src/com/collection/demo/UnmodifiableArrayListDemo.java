package com.collection.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableArrayListDemo {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		System.out.println(unmodifiableList);
	}
	
}
