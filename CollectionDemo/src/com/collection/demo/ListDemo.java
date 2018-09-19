package com.collection.demo;

import java.util.ArrayList;
import java.util.List;

import com.collection.model.User;

public class ListDemo {

	public static void main(String[] args) {
		
		List<User> list = new ArrayList<User>();
		list.add(new User("paulo", "paulo@email.com"));
		list.add(new User("paulo", "paulo@email.com"));
		System.out.println(list);
	}
	
}
