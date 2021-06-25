package game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		RoomManager init = new RoomManager();
		init.init();
		Player player = new Player();
		int i = 0;
		player.currentRoom = init.startingRoom;
		while (i == 0) {
			printRoom(player);
			String[] command = collectInput();
			parse(command, player);
		}
	}

	private static void printRoom(Player player) {
		System.out.println(player.currentRoom.name);
		System.out.println(player.currentRoom.shortDescription);
		System.out.println(player.currentRoom.longDescription);

	}

	private static String[] collectInput() {
		Scanner userIn = new Scanner(System.in);

		String input = userIn.nextLine();
		input.toLowerCase();
		String[] command = input.split(" ");
		userIn.close();
		return command;

	}

	private static void parse(String[] command, Player player) {

	}
}
