package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{
	String name;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			System.out.println("Thread Executed - " +this.name+" - "+ Thread.currentThread().getName() );
		}
		
	}
	
	public MyThread(String name) {
		this.name = name;
	}
	
}

public class MultiThreadsExamples {
	
	public static void main(String[] args) {
		
		
//		ExecutorService executor = Executors.newFixedThreadPool(5);
//		executor.execute(new MyThread("Task 1"));
//		executor.execute(new MyThread("Task 2"));
//		executor.execute(new MyThread("Task 3"));
		
//		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//		executor.scheduleAtFixedRate(new MyThread("Task 1"), 1, 3,TimeUnit.SECONDS);
//		executor.scheduleAtFixedRate(new MyThread("Task 2"), 1, 1,TimeUnit.SECONDS);
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		executor.scheduleWithFixedDelay(new MyThread("Task 1"), 1, 3,TimeUnit.SECONDS);
		executor.scheduleWithFixedDelay(new MyThread("Task 2"), 1, 1,TimeUnit.SECONDS);
		
	}

}
