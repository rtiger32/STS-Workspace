package game;

import java.util.Random;
import java.util.Scanner;
import fixtures.Room;
import sun.print.resources.serviceui;

public class Main {

	static private Boolean next = true;
	
	public static void main(String[] args) {
		RoomManagerMap init = new RoomManagerMap();
		init.init(); // Start the game and populate the rooms
		Player player = new Player();
		player.setCurrentRoom(init.getStart()); // Move the player to the starting point
		
		boolean i = true;
		while (i) {
			if (next) printRoom(player);
			System.out.println("\nWhat would you like to do?");
			String[] command = collectInput();
			parse(command, player);
		}
	}

	// Display what is in the room
	private static void printRoom(Player player) {
		Room current = player.getCurrentRoom();
		System.out.println("\n" +current.getName());
		System.out.println(current.getLongDescription());
		current.getExits();
	}

	// Take the input from user and store in variable
	private static String[] collectInput() {
		Scanner userIn = new Scanner(System.in);

		String input = userIn.nextLine();
		input = input.toLowerCase();
		String[] command = input.split(" ");
		return command;

	}

	// Take the input variable and act accordingly
	private static void parse(String[] command, Player player) {
		String cmd = command[0];
		String direction = "Wrong";
		Room nextRoom = new Room();
		Room current = new Room();
		// Try to parse the second argument
		try {
			if (command[1] != null) {
				current = player.getCurrentRoom();
				nextRoom = current.getExit(command[1]);
				direction = command[1];
			} else {}
				
		} catch (Exception e) {
			current = player.getCurrentRoom();
			nextRoom = current.getExit(direction);
		}
		

		switch (cmd) {

		// Exit the program
		case "quit":
			System.exit(0);

			// Move between the rooms
		case "go":
			if (current.getLock(direction) == 1) {
				System.out.println("\nThe " + direction + " door is locked\n");
				next = false;
			} else next = player.move(nextRoom);
			
			break;

		// Lock or unlock the door
		case "lock":
			next = false;
			if (current.getLock(direction) == -1) System.out.println("\nThe lock on the " + direction + " door is broken\n");
			else if (current.getLock(direction) == 0) {
				current.lock(direction, nextRoom);
				System.out.println("\nThe " + direction + " door is now locked\n");
				player.setCurrentRoom(current);
			} else {
				current.unlock(direction, nextRoom);
				System.out.println("\nThe " + direction + " door is now unlocked\n");
				player.setCurrentRoom(current);
			}
			break;

		// Try to kick down the door
		case "kick":
			next = false;
			if (current.getLock(direction) == 0) System.out.println("\nWhy not use the doorknob like everyone else!\n");		
			else {
				Random random = new Random();
				int kick = random.nextInt(4);
				if (kick == 0) {
					System.out.println("\nYou kick in the door, destroying the lock!\n");
					current.breakLock(direction, nextRoom);	
					player.setCurrentRoom(current);
				} else System.out.println("Try as you might, the door refuses to budge");
				
			}
			break;

		// Look around the room, or at an object(WIP)
		case "look":
			next = false;
			try {
				if (command[1].equals("room") || (command[1].equals(null))) {		
					System.out.println(current.getName());
					System.out.println(current.getLongDescription());;
				} else {
				} // Space reserved for items
			} catch (Exception e) {
				System.out.println(current.getName());
				System.out.println(current.getLongDescription());
			}
			break;

		// Standard help menu
		case "help":
			next = false;
			System.out.println(
					"\nThe commands are: \nGo : Change Room \nLook: Observe the surroundings\nGet: Pick up an item (NYI)"
							+ "\nInventory: Check your bag\nLock : (Un)Lock a door\nKick: The other way to open a door..."
							+ "\nFix: Repair something\nHelp: This menu\nQuit: Exit the program\nPress a key to continue...");
			Scanner userIn = new Scanner(System.in);
			userIn.nextLine();
			break;

		// Look at what the player is holding(WIP)
		case "inventory":
			next = false;
			player.getInventory();
			break;

		// Try to repair a broken door
		case "fix":
			next = false;
			if (current.getLock(direction) == -1) {
				Random random = new Random();
				int fix = random.nextInt(2);

				if (fix == 0) {
					current.unlock(direction, nextRoom);
					System.out.println("\nYou repaired the " + direction + " door\n");
					player.setCurrentRoom(current);
				} else System.out.println("Your attempt to repair the damaged door has failed");
			} else System.out.println("\\nThe " + direction + " door is not broken\\n");
			break;

		default:
			next = false;
			System.out.println("\nSorry, I do not recognize that command \n");
			break;
		}
	}
}
