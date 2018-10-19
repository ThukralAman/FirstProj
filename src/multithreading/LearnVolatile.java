package multithreading;

import java.util.Scanner;


/*
 * In some of the cases thread t1 might have counting variable cached in cpu register 
 * and while the main thread update the value of boolean "counting" to false
 * the thread might still see the value of counting = true cached in cpu register as ith has not bee updated with latest
 * value of "counting" variable (which is false) as it is written to RAM
 * 
 * But if we use volatile type for variable counting, then all threads will read/write counter from main memory and not cache it 
 *   
 */
class Counter extends Thread{
	int counter=0;
	volatile boolean counting=true;
	
	public void run() {
		while(counting) {
			System.out.println("Counter val is = " + counter);
			counter++;
			try{
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	void resetCounting(boolean val) {
		counting = val;
	}
	
}

public class LearnVolatile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter c1 = new Counter();
		c1.start();
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		c1.resetCounting(false);
		
		

	}

}
