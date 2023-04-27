package Wiley_core_java;


class A{
	public void funcA() {
		System.out.println("Function from class A");
	}
}

class B extends A{
	public void funcB() {
		System.out.println("Func from class B extended by class A");
	}
}

class C extends A{
	public void funcC() {
		System.out.println("Func from class C extended by class A");
	}
}

class D extends B{
	public void funcD() {
		System.out.println("Func from class D extended by class B");
	}
	
}
class E extends D{
	public void funcE() {
		System.out.println("Func from class E extended by class D");
	}
}
public class HybridInheritance {
	
	public static void main(String[] args) {
		E objE = new E();
		objE.funcE();
		objE.funcD();
		objE.funcB();
		objE.funcA();
	}

}
