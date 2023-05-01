package SynchronizationConcept;

class BankAccount{
	int amount = 1000;
	
	
	public synchronized void withdrawAmount(int amount) {
		if(this.amount < amount) {
			System.out.println("Amount is less");
		}
		
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Successfully Withdrawn");
	}
	
	public synchronized void depositAmount(int amount) {
		this.amount+=amount;
		System.out.println("Amount deposited "+amount);
		System.out.println("Available balance = "+this.amount);
		notifyAll();

		
	}
}

public class InterCommunication {
	public static void main(String[] args) {
		BankAccount ba = new BankAccount();
		
		Thread t1 = new Thread()
		{
			public void run() {
				
				ba.withdrawAmount(1500);
				ba.depositAmount(1000);
			}
		};
		Thread t2 = new Thread()
		{
			public void run() {
				ba.depositAmount(500);
			}
		};		
		t1.start();
		t2.start();
	}


}
