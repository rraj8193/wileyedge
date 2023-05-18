package javaGenerics;

import java.lang.module.FindException;

class MyClass<T>{
	
	T value;
	

	public T getValue() {
		return value;
	}


	public void setValue(T value) {
		this.value = value;
	}


	public MyClass(T value) {
		super();
		this.value = value;
	}
	
	public int findRelation(T[] arr, T ele) {
		int count = 0;
		for(T e:arr) {
//			if(e>ele) {
//				count++;
//			}
			count++;
		}
		return count;
	}
	
}

public class RelationalOperations {
	public static void main(String[] args) {
		MyClass<Integer>  obj = new MyClass<>(9);
		
		Integer[] arr = {4,5,6,7,8};
		
		System.out.println(obj.findRelation(arr, 3));
	}
}
