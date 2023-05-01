package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {
	
	
	public static void main(String[] args) {
//		String re = "\\w\\w\\w";   \w-> matches word character and _ while \W -> matches non word character such as symbols @
		
//		String re ="\\s\\S";      \s -> matches void space characters while \\S -> matches non void space characters
		String re = "\\d\\D";    //  \d -> matches digits and \D matches non-digits
		String text = "9@";   
		
		Pattern pattern = Pattern.compile(re);
		Matcher matcher = pattern.matcher(text);
		System.out.println(matcher.matches());
	}
	
}
