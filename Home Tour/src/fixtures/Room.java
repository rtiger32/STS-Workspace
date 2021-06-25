package fixtures;

public class Room extends Fixture {

	private Room[] exits = new Room[6]; //Store the exits to a room by room object

	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}

	public Room() {
		super();
	}

	public void setExits(Room a, Room b, Room c, Room d, Room e, Room f) {
		exits[0] = a;
		exits[1] = b;
		exits[2] = c;
		exits[3] = d;
		exits[4] = e;
		exits[5] = f;
	}

	public Room[] getExits() {
		return exits;
	}

	public Room getExit(String direction) {

		switch (direction) {
		case "north":
			return exits[0];
		case "south":
			return exits[1];
		case "east":
			return exits[2];
		case "west":
			return exits[3];
		case "up":
			return exits[4];
		case "down":
			return exits[5];
		default:
			System.out.println("Sorry, I do not recognize that direction");
			return null;
		}

	}
}
