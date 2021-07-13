package main;

import java.util.Random;

public class concatTest {

	public static void main(String[] args) {
		
		String test = "1234";
		String test2 = (test + test);
		
		System.out.println(test2);
		
		
		
		int test3 = new Random().nextInt(9999);
			
		System.out.println(test3);
		test2 = String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999));		
		
		System.out.println(test2);
		
		test2 = String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999));		
		
		System.out.println(test2);
		
		test2 = String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999));		
		
		System.out.println(test2);
		
		test2 = String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999)) + " " +
				String.format("%04d", new Random().nextInt(9999));		
		
		System.out.println(test2);
	}
}
