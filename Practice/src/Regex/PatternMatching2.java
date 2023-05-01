package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching2 {
	public static void main(String[] args) {
		
		// regex101.com
		
		Pattern pattern = Pattern.compile("agent \\d{3}");
		Matcher matcher = pattern.matcher("agent 007");
		System.out.println("Found : "+ matcher.find());
		System.out.println("Matches : "+matcher.matches());
		System.out.println("-------------------------------");
		
		pattern = Pattern.compile("agent \\d{3,5}");
		matcher = pattern.matcher("agent 00000007");
		System.out.println("Found : "+ matcher.find());
		System.out.println("Matches : "+matcher.matches());
		System.out.println("-------------------------------");
		
		pattern = Pattern.compile("agent \\d{3,5}");
		matcher = pattern.matcher("agent 00000007 agent 00007");
		System.out.println("Matches : "+matcher.matches());
		System.out.println("Found : "+ matcher.find());
		
		System.out.println("-------------------------------");
		
	}
}
