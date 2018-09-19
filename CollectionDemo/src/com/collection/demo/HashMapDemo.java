package com.collection.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "One");
		map.put("2", "Two");
		map.put("3", "Three");
		
		Set<String> set = map.keySet();
		Iterator<String> i = set.iterator();
		
		while (i.hasNext()) {
			String key = (String) i.next();
			String value = map.get(key);
			System.out.println("Key: " + key + " ~ Value: " + value);
		}
		
	}
	
}
