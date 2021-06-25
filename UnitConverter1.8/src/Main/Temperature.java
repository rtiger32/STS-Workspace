package Main;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Temperature {

	protected void run() throws NumberFormatException {

		String option = "";
		int i = 1;
		Scanner userIn = new Scanner(System.in);

		// Repeat the code until the user exits the menu
		while (i == 1) {
			System.out.println();
			System.out.println("What system are you trying to convert?");
			System.out.println();
			System.out.println("1. Fahrenheit to Celsius");
			System.out.println("2. Celsius to Fahrenheit");
			System.out.println("3. Fahrenheit to Kelvin");
			System.out.println("4. Kelvin to Fahrenheit");
			System.out.println("5. Celsius to Kelvin");
			System.out.println("6. Kelvin to Celsius");
			System.out.println("7. Return to previous menu");

			// Take user input and parse to int. If invalid, set to zero.
			option = userIn.nextLine();

			int select = 0;
			double number = 0;

			try {
				select = Integer.parseInt(option);
			} catch (Exception e) {
				select = 0;
			}

			if (select == 7) {
//				userIn.close();
				return;
			}
			// Accept number to convert as a double. If invalid, set to zero

			System.out.println();
			System.out.println("Convert what number?");

			option = userIn.nextLine();

			try {
				number = Integer.parseInt(option);
			} catch (Exception e) {
				number = 0;
			}

			// Send the user input to calculation method

			calc(select, number);

		}
//		userIn.close();
	}

	protected void calc(int x, double y) {
		double z = 0;
		DecimalFormat numberFormat = new DecimalFormat("#.##");

		// Analyze input and respond accordingly with the proper operation

		switch (x) {
		case 1:
			z = ((y - 32) * 5 / 9);
			System.out.println(y + " Fahrenheit is " + numberFormat.format(z) + " Celsius");
			break;
		case 2:
			z = ((y * 9 / 5) + 32);
			System.out.println(y + " Celsius is " + numberFormat.format(z) + " Fahrenheit");
			break;
		case 3:
			z = (((y - 32) * 5 / 9) + 273.15);
			System.out.println(y + " Fahrenheit is " + numberFormat.format(z) + " Kelvin");
			break;
		case 4:
			z = (((y - 273.15) * 9 / 5) + 32);
			System.out.println(y + " Kelvin is " + numberFormat.format(z) + " Fahrenheit");
			break;
		case 5:
			z = (y + 273.15);
			System.out.println(y + " Celsius is " + numberFormat.format(z) + " Kelvin");
			break;
		case 6:
			z = (y - 273.15);
			System.out.println(y + " Kelvin is " + numberFormat.format(z) + " Celsius");
			break;
		default:
			System.out.println("I did not recognize that option. Try again.");
		}
	}
}
