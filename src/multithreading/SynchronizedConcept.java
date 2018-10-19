package multithreading;

public class SynchronizedConcept {
	
	private int counter = 0;

	{
		System.out.println("Object created");
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		SynchronizedConcept obj = new SynchronizedConcept();
		obj.doWork();
		
		
		
		
		
	}
	
	public synchronized void increment() {
		counter++;
	}
	
	public void doWork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<100000; i++) {
					increment();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<100000; i++) {
					increment();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("counter = " + counter);
	}

}
