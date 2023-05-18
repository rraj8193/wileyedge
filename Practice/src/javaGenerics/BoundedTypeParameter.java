package javaGenerics;

class NewPair<K extends Number,V>{
	K key;
	V value;
	
	K getKey() {
		return key;
	}
	
	void setKey(K k) {
		key = k;
	}
	
	V getValue() {
		return value;
	}
	void setValue(V v) {
		value = v;
	}
	
	public NewPair(K key, V value) {
		this.key = key;
		this.value = value;
	}
}


public class BoundedTypeParameter {
	NewPair<Integer,String> pair1 = new NewPair<>(1,"Java");
//	NewPair<String,String> pair2 = new NewPair<>("Script","JavaScript");  // Throws Error
	
	
}
