package main;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class concatTest {

	public static void main(String[] args) {
		for (int i = 0; i != -1; i++) {
		String test2 = String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999));		
		
		System.out.println(test2);
try {
	Thread.sleep(50);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}		
		}
	}
}
