package Wiley_core_java;

public class ConstructorTypes {
	
	public ConstructorTypes() {
		// TODO Auto-generated constructor stub
		System.out.println("This is a 0 argument constructor");
	}
	public ConstructorTypes(int a , int b) {
		System.out.println("This is 2 argument constructor with integer values "+(a+b));
	}
	public ConstructorTypes(float a , float b) {
		System.out.println("This is 2 argument constructor with float values "+(a+b));
	}
	
	public static void main(String[] args) {
		ConstructorTypes ct = new ConstructorTypes();
		ConstructorTypes ct2 = new ConstructorTypes(2,3);
		ConstructorTypes ct3 = new ConstructorTypes(2.5f,6.5f);
		
	}

}
