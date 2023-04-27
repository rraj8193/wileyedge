package Currency;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyClass {
	
	public static void main(String[] args) {
		Currency usd = Currency.getInstance("USD");
		NumberFormat frm = NumberFormat.getCurrencyInstance(Locale.US);
		String formattedValue = frm.format(108.45);
		System.out.println(formattedValue);
		
		
		double price = 2000.45;
		Locale local = new Locale("en","IN");
		
		NumberFormat frm1 = NumberFormat.getCurrencyInstance(local);
		System.out.println(frm1.format(price));
		
		DecimalFormat frm3 = new DecimalFormat("#,##0.00");
		frm3.setPositivePrefix("$");
		System.out.println(frm3.format(price));
	}

}
