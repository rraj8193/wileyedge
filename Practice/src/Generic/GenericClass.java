package Generic;

public class GenericClass {
	public static void main(String[] args) {
		PrinterClass<String> s = new PrinterClass<>("Wiley Edge");
		s.print();
		
		PrinterClass<Integer> i = new PrinterClass<>(10);
		i.print();
	}
}
