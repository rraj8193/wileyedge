package SynchronizationConcept;

class MyThread extends Thread{
	
	
	public synchronized void method2() {
		for(int j=0;j<10;j++) {
			System.out.print(j+"/////////");
		}
	}
	
	@Override
	public void run() {
		method2();
	}
}

public class SynchronizeExample {
	public static void main(String[] args) {
		
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
//		MyThread t3 = new MyThread();
		
		t1.start();
		t2.start();
//		t3.start();
	}
}
