package javaGenerics;

import JavaStreams.Main5;

class MyNewClass<X> {
	
	  <T> MyNewClass(T t) {
	    // ...
		  System.out.println("Constructor Invoked "+t);
	  }
	}

public class GenericConstructor {
	public static void main(String[] args) {
		MyNewClass<Integer> myclass = new MyNewClass<>("String");
		MyNewClass<Integer> myclass1 = new MyNewClass<>(7);
	}
}
