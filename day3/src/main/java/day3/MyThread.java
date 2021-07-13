package day3;

public class MyThread extends Thread{

	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("\t" + Thread.currentThread().getName());
		}
	}
}
