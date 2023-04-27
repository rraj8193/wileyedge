package StringClasses;

import java.util.Arrays;
import java.util.List;

public class StingFormat {
	public static void main(String[] args) {
		String title = "Java Developer";
		float salary = 5000.8765f;
		System.out.format("%s %.2f", title,salary);
		System.out.println();
		
		List<String> list = Arrays.asList(
						"Esentials of Java",
						"Let us C",
						"Oreilly Python for ML"
				);
		for(String book:list) {
			System.out.format("%-30s - In stock\n",book);
		}
	}
}
