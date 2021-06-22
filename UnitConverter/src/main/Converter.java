package main;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Converter {

	public static void main(String[] args) throws NumberFormatException {

		String option = "";
		int i = 1;
		Scanner userIn = new Scanner(System.in);

		// Repeat the code until the user exits the program
		while (i == 1) {
			System.out.println("Unit Conversions");
			System.out.println();
			System.out.println("Select a conversion");
			System.out.println("1. Temperature (Celsius, Fahrenheit, Kelvin)");
			System.out.println("2. Distance (Meter, Foot)");
			System.out.println("3. Volume (Liter, Gallon)");
			System.out.println("4. Exit");

			// Take user input and parse to int. If invalid, set to zero.
			option = userIn.nextLine();

			int MenuSelection = 0;

			try {
				MenuSelection = Integer.parseInt(option);
			} catch (Exception e) {
				MenuSelection = 0;
			}

			// Respond accordingly to the user input with the proper class
			switch (MenuSelection) {
			case 1:
				Temperature temp = new Temperature();
				temp.run();
				break;
			case 2:
				Distance dist = new Distance();
				dist.run();
				break;
			case 3:
				// Volume vol = new Volume();
				// vol.run();
				throw new NoSuchElementException("Sorry, I can't do that yet"); 
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("I did not recognize that option. Try again.");
				System.out.println();
			}

		}
		// Close scanner to save resources
		userIn.close();
	}

}
