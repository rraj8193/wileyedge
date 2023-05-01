package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardMatch {
	
	public static void main(String[] args) {
		
		
		String cardNumber = "4548-6789-2453-8654";
		
		Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-\\d{4}");
		Matcher matcher = pattern.matcher(cardNumber);
		
		String maskedCard = matcher.replaceAll("xxxx-xxxx-xxxx");
		System.out.println(maskedCard);
	}

}
