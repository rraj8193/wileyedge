package javaGenerics;


class NewUtil{
	public static <K extends Number,V> boolean newCompare(NewPair<K,V> pair1, NewPair<K,V> pair2) {
		
		return pair1.getKey().equals(pair2.getKey()) && pair1.getValue().equals(pair2.getValue());
	}
}
public class BoundedTypeMethod {
	public static void main(String[] args) {
		
		
		NewPair<Integer,String> pair1 = new NewPair<>(1,"Java");
		NewPair<Integer,String> pair2 = new NewPair<>(2,"python"); //Outputs false 
		System.out.println(NewUtil.newCompare(pair1, pair2)); // Throws error
		
		Pair<String, String> pair3 = new Pair<>("A","Orange");
		Pair<String, String> pair4 = new Pair<>("B","Mango");
//		System.out.println(NewUtil.newCompare(pair3, pair4)); // Throws error
	}
}
