package javaGenerics;

import java.util.Arrays;
import java.util.List;

public class UpperBoundWildCard {

	public static double sumOfList(List<? extends Number> list) {
		double sum = 0;
		
		for(Number ele : list) {
			sum += ele.doubleValue();
		}
		
		return sum;
	}
	
	public static double sumOfList2(List<Number> list) {
		double sum = 0;
		
		for(Number ele : list) {
			sum += ele.doubleValue();
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1,3,4);
		System.out.println(sumOfList(list1));
//		System.out.println(sumOfList2(list1)); // throw error
		
		List<Double> list2 = Arrays.asList(3.0,2.0,4.0);
		System.out.println(sumOfList(list2));
//		System.out.println(sumOfList2(list2));   // throw error
	}
}
