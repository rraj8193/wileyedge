package MultiThreading;

class Demo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(" Thread name :- "+ Thread.currentThread().getName());
		System.out.println(" Thread Group :-  "+ Thread.currentThread().getThreadGroup().getName());
		for(int i=0;i<100;i++) {
//			System.out.print(i);
			continue;
		}
		
	}
	
}

public class ThreadGroupConcept {
	
	public static void main(String[] args) throws InterruptedException{
		ThreadGroup tgParent = new ThreadGroup("Parent Thread Group");
		ThreadGroup tgChild1 = new ThreadGroup(tgParent,"Child Thread Group");
		
		Thread t1 = new Thread(tgParent, new Demo());
		Thread t2 = new Thread(tgParent, new Demo());
		Thread t3 = new Thread(tgChild1, new Demo());
		
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.sleep(100);
		t1.sleep(100);
		t1.sleep(100);
		
		System.out.println("Active count "+ tgParent.activeCount());
		
		
//		tgParent.list();
		
	}

}
