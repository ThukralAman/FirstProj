package multithreading;

public class CreateThreadPart2 extends Thread {
	
	public static void main(String args[]) {
		CreateThreadPart2 obj1 = new CreateThreadPart2();
		CreateThreadPart2 obj2 = new CreateThreadPart2();
		obj1.start();
		obj2.start();
		System.out.println("main end");
	}
	
	public void run() {
		for(int i=0; i<50; i++) {
			System.out.println(i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
