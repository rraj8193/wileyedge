package javaGenerics;

import java.util.*;

public class GenericOverOverloading {

	
	// To call generic method comment overloaded method as java first matches the methods with best matching parameter.
	
	public static void print(String s) {
		System.out.println("Overloaded as String method called");
		System.out.println(s);
	}
	public static void print(Integer t) {
		System.out.println("Overloaded as Integer method called");
		System.out.println(t);
	}
	
	public static <T> void print(T data) {
		System.out.println("Generic method called");
		System.out.println(data);
	}
	
	
	
	public static void main(String[] args) {

		
		String stringData = "This is a string data";
		Integer intData = 10;
		print(stringData);
		print(intData);
		
		
	}
}
