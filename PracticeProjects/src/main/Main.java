package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] one = { 1, 2, 3, 4 };
		int[] two = { 0, 0, 0, 0 };

		ArrayLink oneArr = new ArrayLink(one);
		ArrayLink twoArr = new ArrayLink(two);

		System.out.println("Enter modifier");
		Scanner userIn = new Scanner(System.in);
		int change = userIn.nextInt();

		System.out.println("Enter Index [0-3]");
		int dex = userIn.nextInt();

		if (dex % 2 == 0) {
			oneArr.setLink(dex, change + oneArr.getLink(dex));
			twoArr.setLink(dex + 1, change + oneArr.getLink(dex + 1));
		} else {
			oneArr.setLink(dex, change + oneArr.getLink(dex));
			twoArr.setLink(dex - 1, change + oneArr.getLink(dex - 1));
		}
		
		System.out.println(Arrays.toString(oneArr.getLink()));
		System.out.println(Arrays.toString(twoArr.getLink()));

	}
}
