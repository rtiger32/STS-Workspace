package game;

import fixtures.Room;

public class RoomManager {

	// Library to store all rooms
	// on init, create a room object for every room in this list
	// add all rooms to a master array

	public Room[] rooms = new Room[2];  //Master list of rooms
	public Room startingRoom; // The first room for the player

	public void init() {
		Room one = new Room("Test1", "ShortTest1", "LongTest1");
		rooms[0] = one;
		

		Room two = new Room("Test2", "ShortTest2", "LongTest2");
		rooms[1] = two;
		
		one.setExits(rooms[1], null, null, null, null, null);
		one.setExits(null, rooms[0], null, null, null, null);

		startingRoom = one;
	}

}
