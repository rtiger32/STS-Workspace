package game;

import fixtures.Room;

public class RoomManager {

	// Library to store all rooms
	// on init, create a room object for every room in this list
	// add all rooms to a master array

	private Room[] rooms = new Room[6]; // Master list of rooms
	private Room startingRoom; // The first room for the player

	void init() {
		Room one = new Room("Entry", "Front Door", "The front door");
		rooms[0] = one;

		Room two = new Room("Living Space", "An open space", "A Living area");
		rooms[1] = two;

		Room three = new Room("Study", "Lots of books", "A desk and lots of bookshelves");
		rooms[2] = three;

		Room four = new Room("Kitchen", "Tempting scents...", "Pots and pans");
		rooms[3] = four;

		Room five = new Room("Upstairs", "Stairs", "Top of the stairs");
		rooms[4] = five;
		five.setLocks(1,0,0,0,0,0);
		
		Room six = new Room("Bedroom", "Strange noises...", "What are you doing here?!?");
		six.setLocks(0,1,0,0,0,0);
		rooms[5] = six;

		one.setExits(rooms[1], null, rooms[2], null, rooms[4], null);
		two.setExits(rooms[3], rooms[0], null, null, null, null);
		three.setExits(null, null, null, rooms[0], null, null);
		four.setExits(null, rooms[1], null, null, null, null);
		five.setExits(rooms[5], null, null, null, null, rooms[0]);
		six.setExits(null, rooms[4], null, null, null, null);

		startingRoom = rooms[0];
	}
	Room getStart() {
		return startingRoom;
	}
}
