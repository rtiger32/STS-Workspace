package game;

import java.util.HashMap;
import java.util.Map;
import fixtures.Room;

public class RoomManagerMap {

	private Map<String, Room> roomList = new HashMap<>();
	private Room startingRoom;

	protected void init() {

		Room one = new Room("Entry", "Front Door", "The front door");
		Room two = new Room("Living Space", "An open space", "A Living area");
		Room three = new Room("Study", "Lots of books", "A desk and lots of bookshelves");
		Room four = new Room("Kitchen", "Tempting scents...", "Pots and pans");
		Room five = new Room("Upstairs", "Stairs", "Top of the stairs");
		five.setLocks(1, 0, 0, 0, 0, 0);
		Room six = new Room("Bedroom", "Strange noises...", "What are you doing here?!?");
		six.setLocks(0, 1, 0, 0, 0, 0);

		one.setExits(two, null, three, null, five, null);
		two.setExits(four, one, null, null, null, null);
		three.setExits(null, null, null, one, null, null);
		four.setExits(null, two, null, null, null, null);
		five.setExits(six, null, null, null, null, one);
		six.setExits(null, five, null, null, null, null);

		roomList.put("one", one);
		roomList.put("two", two);
		roomList.put("three", three);
		roomList.put("four", four);
		roomList.put("five", five);
		roomList.put("six", six);

		startingRoom = roomList.get("one");
		title();
	}

	private void title() {
		System.out.println(" __    __                                            __                                   \r\n"
						+ "|  \\  |  \\                                          |  \\                                  \r\n"
						+ "| $$  | $$  ______   ______ ____    ______         _| $$_     ______   __    __   ______  \r\n"
						+ "| $$__| $$ /      \\ |      \\    \\  /      \\       |   $$ \\   /      \\ |  \\  |  \\ /      \\ \r\n"
						+ "| $$    $$|  $$$$$$\\| $$$$$$\\$$$$\\|  $$$$$$\\       \\$$$$$$  |  $$$$$$\\| $$  | $$|  $$$$$$\\\r\n"
						+ "| $$$$$$$$| $$  | $$| $$ | $$ | $$| $$    $$        | $$ __ | $$  | $$| $$  | $$| $$   \\$$\r\n"
						+ "| $$  | $$| $$__/ $$| $$ | $$ | $$| $$$$$$$$        | $$|  \\| $$__/ $$| $$__/ $$| $$      \r\n"
						+ "| $$  | $$ \\$$    $$| $$ | $$ | $$ \\$$     \\         \\$$  $$ \\$$    $$ \\$$    $$| $$      \r\n"
						+ " \\$$   \\$$  \\$$$$$$  \\$$  \\$$  \\$$  \\$$$$$$$          \\$$$$   \\$$$$$$   \\$$$$$$  \\$$      \r\n"
						+ "                                                                                         ");
		System.out.println("                       W E L C O M E   T O   M Y   H O M E   T O U R !             ");
		System.out.println("\n Type HELP for a list of commands.");
	}

	protected Room getStart() {
		return startingRoom;
	}
}