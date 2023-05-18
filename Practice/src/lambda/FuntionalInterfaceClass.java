package lambda;

@FunctionalInterface
interface Calc{
	int calculate(int s);
}

public class FuntionalInterfaceClass {
	public static void main(String[] args) {
		Calc cl = (int val) -> val + 54;
		System.out.println("Result "+cl.calculate(54));
	}
}
