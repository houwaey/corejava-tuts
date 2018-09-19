package com.test.java;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RunApplication {

	public static void main(String[] args) {
		// Generating Streams
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println("strings: " + strings);
        
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("filtered: " + filtered);
        
        long count = strings.stream().filter(string -> !string.isEmpty()).count();
        System.out.println("count: " + count);
        
        count = strings.parallelStream().filter(string -> !string.isEmpty()).count();
        System.out.println("count: " + count);
        
        String mergedStrings = strings.stream().filter(string -> !strings.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("mergedStrings: " + mergedStrings);
        System.out.println("==========");
        
        //new Random().ints().limit(10).forEach(System.out::println);
        
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        System.out.println("squaresList: " + squaresList);
        
	}
	
}
