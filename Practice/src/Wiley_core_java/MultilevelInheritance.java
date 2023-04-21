package Wiley_core_java;


class Vehicle{
	public void wheel() {
		System.out.println("Wheel");
	}
}

class Car extends Vehicle{
	public void steering() {
		System.out.println("Steering");
	}
}

class SmartCar extends Car{
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
