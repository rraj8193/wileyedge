package Generic;

public class PrinterClass<T> {
	
	T data;
	
	public void print() {
		System.out.println(this.data);
	}
	
	
	public PrinterClass(T data){
		this.data = data;
	}
	
}
