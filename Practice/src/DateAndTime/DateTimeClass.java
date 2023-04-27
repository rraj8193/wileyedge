package DateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class DateTimeClass {
	
	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-yyyy-MM HH:mm:ss");
		System.out.println(localDateTime.format(formatter1));
		

	}

}
