package StringClasses;

import java.util.Arrays;

public class CompareString {
	public static void main(String[] args) {
		String s1 = "Wiley";
		String s2 = "Wiley";
		
		String s3 = new String("Wiley");
		String s4 = new String("Wiley");
		System.out.println(s1==s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
		
		
		String s5 = new String("Wiley Mthree");
		System.out.println("Before replacing -------- "+s5);
		
		String s6 = s5.replace("Mthree", "Edge");
		System.out.println("After replacing -------- "+s6);
		
		String [] s_arr = s6.split(" ");
		System.out.println(Arrays.toString(s_arr));
		
	}

}
