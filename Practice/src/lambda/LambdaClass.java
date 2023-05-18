package lambda;

public class LambdaClass {

	public static void printThing(Printable thing) {
		thing.print(" !");
	}

	public static void main(String[] args) {

//		Product product = new Product();
//		product.print();
//		printThing(product);

		printThing((s) -> {
			System.out.println("This is lambda expression"+s);
		});
	}

}
