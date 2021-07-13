package day3;

public class ThreadDriver {

	public static void main(String[] args) {
		
		Thread th = new Thread();
		
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());
		
		try {
			mainThread.sleep(3000);
			System.out.println(mainThread.getPriority());
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		MyThread th1 = new MyThread();
		th1.setName("First Thread");
		
		MyRunnable r1 = new MyRunnable();
		
		Thread th2 = new Thread(r1);
		th2.setName("Thread Two");
		
		th1.start();
		th2.start();
		
		for (int i=0; i<100; i++) {
			System.out.println("\t" + Thread.currentThread().getName());
		}
	}
}
