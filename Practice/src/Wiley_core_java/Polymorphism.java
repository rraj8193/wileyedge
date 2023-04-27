package Wiley_core_java;

class Shape{
	
	public double area(double radius) {
		return 3.14*radius*radius;
	}
	public int area(int l,int b) {
		return l*b;
	}
	
}

public class Polymorphism {
	public static void main(String[] args) {
		Shape s = new Shape();
		System.out.println(s.area(10));
		System.out.println(s.area(10,20));
	}
}
