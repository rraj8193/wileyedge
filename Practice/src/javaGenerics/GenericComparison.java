package javaGenerics;




public class GenericComparison {
//	public static <T> int findMax(T[] t,T ele) {
//		int count = 0;
//		for(T e: t) {
//			if(e>ele) {
//				count++;
//			}
//		}
//		return count;
//	}
	
	public static <T extends  Comparable<T>> int findMax(T[] t,T ele) {
		int count = 0;
		for(T e: t) {
			if(e.compareTo(ele)>0) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Integer[] arr = {4,6,3,7,1,0};
		System.out.println(findMax(arr,2));
	}
}
