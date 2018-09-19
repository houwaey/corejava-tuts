package com.collection.demo;

import java.util.HashSet;
import java.util.Set;

import com.collection.model.User;

public class SetDemo {

	public static void main(String[] args) {
		
		Set<User> set = new HashSet<User>();
		set.add(new User("paulo", "paulo@email.com"));
		set.add(new User("paulo", "nhoj@email.com"));
		set.add(new User("john", "paulo@email.com"));
		set.add(new User("paulo", "paulo@email.com"));
		System.out.println(set);
	}
	
}
