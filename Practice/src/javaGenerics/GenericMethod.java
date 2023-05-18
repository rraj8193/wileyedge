package javaGenerics;

class Pair<K,V>{
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
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

class Util{
	public static <K,V> boolean compare(Pair<K,V> pair1, Pair<K,V> pair2) {
		
		return pair1.getKey().equals(pair2.getKey()) && pair1.getValue().equals(pair2.getValue());
	}
}

public class GenericMethod {
	
	public static void main(String[] args) {
		Pair<Integer, String> pair1 = new Pair<>(8,"Orange");
		Pair<Integer, String> pair2 = new Pair<>(6,"Mango");
		System.out.println(Util.compare(pair1, pair2));       // Outputs false
		
		pair1.setKey(3);
		pair1.setValue("Apple");
		
		pair2.setKey(3);
		pair2.setValue("Apple");
		
		System.out.println(Util.compare(pair1, pair2));   // Outputs true
	}
	
	
	
}
