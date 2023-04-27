package Wiley_core_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringToken {
	public static void main(String[] args) {
		
		ArrayList<StringBuffer> a = new ArrayList<StringBuffer>();
		ArrayList<StringBuilder> a1 = new ArrayList<StringBuilder>();
		
		System.out.println("String Buffer Array "+a);
		System.out.println("String Builder Array "+a1);

		
		
		StringTokenizer tokens2 = new StringTokenizer("We,love,java,Programming",",");
		while(tokens2.hasMoreElements()) {
			System.out.println(tokens2.nextToken());
		}
	}

}
