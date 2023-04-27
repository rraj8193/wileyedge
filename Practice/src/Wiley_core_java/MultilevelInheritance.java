package Wiley_core_java;


class Vehicle1{
	public void wheel() {
		System.out.println("Wheel");
	}
}

class Car1 extends Vehicle1{
	public void steering() {
		System.out.println("Steering");
	}
}

class SmartCar extends Car1{
	public void sensor() {
		System.out.println("Sensor");
	}
}
public class MultilevelInheritance {
	public static void main(String[] args) {
		SmartCar sc = new SmartCar();
		sc.wheel();
		sc.steering();
		sc.sensor();
	}

}
