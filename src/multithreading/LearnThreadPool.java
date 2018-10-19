package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
	private int id;
	
	Processor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Starting pocess = " + id);
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ending process = " + id);
		
	}
	
	public void main() {
		
	}
	
}

public class LearnThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i=0; i<5; i++) {
			executor.submit(new Processor(i));
		}
		
		executor.shutdown();
		//executor.submit(new Processor(10));
		System.out.println("All Threads have been submitted");
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
