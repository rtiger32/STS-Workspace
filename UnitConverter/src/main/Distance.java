package main;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Distance {

	protected void run() throws NumberFormatException {

		String option = "";
		int i = 1;
		Scanner userIn = new Scanner(System.in);

		// Repeat the code until the user exits the menu
		while (i == 1) {
			System.out.println();
			System.out.println("What system are you trying to convert?");
			System.out.println();
			System.out.println("1. Kilometers to Miles");
			System.out.println("2. Miles to Kilometers");
			System.out.println("3. Return to previous menu");

			// Take user input and parse to int. If invalid, set to zero.
			option = userIn.nextLine();

			int select = 0;
			double number = 0;

			try {
				select = Integer.parseInt(option);
			} catch (Exception e) {
				select = 0;
			}

			if (select == 3) {
				userIn.close();
				return;
			}
			System.out.println();
			System.out.println("Convert what number?");

			// Take user input and parse to double. If invalid, set to zero.
			option = userIn.nextLine();

			try {
				number = Integer.parseInt(option);
			} catch (Exception e) {
				number = 0;
			}

			// Send the user input to calculation method
			 calc(select, number);

		}
		userIn.close();
	}

	protected void calc(int x, double y) {
		double z = 0;
		DecimalFormat numberFormat = new DecimalFormat("#.###");

		// Analyze input and respond accordingly with the proper operation

		switch (x) {
		case 1:
			z = (y / 1.6093);
			System.out.println(y + " Kilometers is " + numberFormat.format(z) + " Miles");
			break;
		case 2:
			z = (y * 1.6093);
			System.out.println(y + " Miles is " + numberFormat.format(z) + " Kilometers");
			break;
		/*
		 * case 3: z = (((y - 32) * 5 / 9) + 273.15); System.out.println(y +
		 * " Fahrenheit is " + numberFormat.format(z) + " Kelvin"); break; case 4: z =
		 * (((y - 273.15) * 9 / 5) + 32); System.out.println(y + " Kelvin is " +
		 * numberFormat.format(z) + " Fahrenheit"); break; case 5: z = (y + 273.15);
		 * System.out.println(y + " Celsius is " + numberFormat.format(z) + " Kelvin");
		 * break; case 6: z = (y - 273.15); System.out.println(y + " Kelvin is " +
		 * numberFormat.format(z) + " Celsius"); break;
		 */ default:
			System.out.println("I did not recognize that option. Try again.");
		}
	}

}
