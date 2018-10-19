package multithreading;

import java.util.*;

class Worker {
	Random random = new Random();
	List l1 = new ArrayList<Integer>();
	List l2 = new ArrayList<Integer>();
	
	
	/*
	 * https://stackoverflow.com/questions/29876641/what-is-the-purpose-of-passing-parameter-to-synchronized-block
	 */
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	
	public void proc1() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			l1.add(random.nextInt(100));
		}
		
		
	}
	
	public void proc2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l2.add(random.nextInt(100));
		}
	}
	
	public void workOnList() {
		for(int i=0; i<1000; i++) {
			proc1();
			proc2();
		}
	}
	
	public void main() {
		long start = System.currentTimeMillis();
		//workOnList();
		//workOnList();
		
		/*
		 * If you allow two threads to interleave then, when two threads are writing to l1, 
		 * One of the thread might generate random number and go to sleep while writing on index 'i'
		 * Now second thread might come and try to write at 'i+1'. this will give array out of bound exception
		 * https://stackoverflow.com/questions/8729786/arraylist-index-out-of-bounds
		 */
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				workOnList();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				workOnList();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken = " + (end-start));
		System.out.println("List_1_size = " + l1.size() + " List_2_size = " + l2.size());
	}
}

public class LearnSyncronizedBlock {
	
	

	public static void main(String[] args) {
		new Worker().main();
	}
}
