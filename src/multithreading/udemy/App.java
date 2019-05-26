package multithreading.udemy;



class Runner1 implements Runnable{
    public void startRunning(){

    }

    @Override
    public void run() {
        for(int i=0; i<100;i++) {
            System.out.println("Runner1: " + i );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner2 implements Runnable {
    public void startRunning(){

    }

    @Override
    public void run() {
        for(int i=0; i<10;i++) {
            System.out.println("Runner2: " + i );
        }
    }
}


public class App {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());
        t1.start();
        t2.start();

        /*Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();

        runner1.startRunning();
        runner2.startRunning();*/


    }

}
