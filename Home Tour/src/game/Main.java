package game;

import java.util.Scanner;
import fixtures.Room;
import sun.print.resources.serviceui;

public class Main {

	public static void main(String[] args) {
		RoomManagerMap init = new RoomManagerMap();
		init.init();
		Player player = new Player();
		boolean i = true;
		player.currentRoom = init.getStart();

		while (i) {
			printRoom(player);
			System.out.println("\n What would you like to do?");
			String[] command = collectInput();
			parse(command, player);
		}
	}

	private static void printRoom(Player player) {
		player.currentRoom.print();
		player.currentRoom.getExits();
	}

	private static String[] collectInput() {
		Scanner userIn = new Scanner(System.in);

		String input = userIn.nextLine();
		input = input.toLowerCase();

//		System.out.println();
//		System.out.println(input);
		String[] command = input.split(" ");
//		userIn.close();
		return command;

	}

	private static void parse(String[] command, Player player) {
		String cmd = command[0];
		String direction = "";
		Room nextRoom = new Room();
		try {
			if (command[1] != null) {
				nextRoom = player.currentRoom.getExit(command[1]);
				direction = command[1];
			}
		} catch (Exception e) {
		}

		switch (cmd) {
		case "quit":
			System.exit(0);
		case "go":
			if (player.currentRoom.getLock(direction) == 1) {
				System.out.println("\nThe " + direction + " door is locked\n");
			} else {
				player.currentRoom = nextRoom;
			}
			break;
		case "lock":
			if (player.currentRoom.getLock(direction) == -1) {
				System.out.println("\nThe lock on the " + direction + " door is broken\n");
			} else if (player.currentRoom.getLock(direction) == 0) {
				player.currentRoom.lock(direction, nextRoom);
				System.out.println("\nThe " + direction + " door is now locked\n");
			} else {
				player.currentRoom.unlock(direction, nextRoom);
				System.out.println("\nThe " + direction + " door is now unlocked\n");
			}
			break;
		case "kick":
			if (player.currentRoom.getLock(direction) == 0) {
				System.out.println("\nWhy not use the doorknob like everyone else!\n");
				player.currentRoom = nextRoom;
			} else {
				System.out.println("\nYou kick in the door, destroying the lock!\n");
				player.currentRoom.breakLock(direction, nextRoom);
				player.currentRoom = nextRoom;
			}
			break;
		case "look":
			try {
				if (command[1].equals("room")) {
					player.currentRoom.print();
				} else {
				}
			} catch (Exception e) {
				player.currentRoom.print();
			}
			break;
		case "help":
			System.out.println(
					"\nThe commands are: \nGo : Change Room \nLook: Observe the surroundings\nGet: Pick up an item (NYI)"
					+ "\nInventory: Check your bag\nLock : (Un)Lock a door\nKick: The other way to open a door..."
					+ "\nFix: Repair something\nHelp: This menu\nQuit: Exit the program\nPress a key to continue...");
			Scanner userIn = new Scanner(System.in);
			userIn.nextLine();
			break;
		case "inventory":
			player.getInventory();
			break;
		case "fix":
			if (player.currentRoom.getLock(direction) == -1) {
				player.currentRoom.unlock(direction, nextRoom);
				System.out.println("\nYou repaired the " + direction + " door\n");
			} else {
				System.out.println("\\nThe " + direction + " door is not broken\\n");
			}
			break;
		default:
			System.out.println("\nSorry, I do not recognize that command \n");
			break;
		}
	}
}
