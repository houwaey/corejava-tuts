package com.collection.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateArrayList {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");
		list.add("Six");
		list.add("Seven");
		list.add("Eight");
		list.add("Nine");
		list.add("Ten");
		list.add("Two");
		System.out.println(list);
		
		Set<String> set = new LinkedHashSet<String>(list); // insertion order is preserved
		System.out.println(set);
	}

}
