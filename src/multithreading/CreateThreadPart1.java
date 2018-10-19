package multithreading;

public class CreateThreadPart1 implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
				System.out.println("WELCOME TO LEARN THREAD CLASS!!");
				CreateThreadPart1 obj = new CreateThreadPart1();
				/*for(int i=0; i<10; i++) {
					new Thread(obj).start();;
				}*/
				Thread t1 = new Thread(obj);
				t1.setName("Thread1");
				Thread t2 = new Thread(obj);
				t2.setName("Thread2");
				t1.start();
				t2.start();
				System.out.println("main end");
	}
	
	public void run() {
		for(int i=1; i<50; i++) {
			System.out.println("Hello  "+ Thread.currentThread().getName() + "  printing " +  i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			if(i%10 == 0) {
				System.out.println("Hey we got a multiple of 10 for " + Thread.currentThread().getName());
			}
		}
		
	}

}
