package fixtures;

public class Room extends Fixture {

	private Room[] exits = new Room[6]; // Store the exits to a room by room object
//	private Item[] inventory; // What items are in the room
	private int[] locked = new int[6]; // Is the room locked?

	// Constructors
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
	}

	public Room() {
		super();
	}

	protected void print() {
		System.out.println(getName() + "\n");
		System.out.println(getLongDescription() + "\n");
	}
	
	public String getName() {
		return getName();
	}

	public void setName(String name) {
		this.setName(name);
	}

	public String getShortDescription() {
		return getShortDescription();
	}

	public void setShortDescription(String shortDescription) {
		this.setShortDescription(shortDescription);
	}

	public String getLongDescription() {
		return getLongDescription();
	}

	public void setLongDescription(String longDescription) {
		this.setLongDescription(longDescription);
	}
	

	// Set the exits of the room
	public void setExits(Room a, Room b, Room c, Room d, Room e, Room f) {
		exits[0] = a;
		exits[1] = b;
		exits[2] = c;
		exits[3] = d;
		exits[4] = e;
		exits[5] = f;
	}

	// Find and print out the room exits
	public void getExits() {
		System.out.println("");
		if (exits[0] != null) System.out.println("North: " + exits[0].getShortDescription());
		if (exits[1] != null) System.out.println("South: " + exits[1].getShortDescription());
		if (exits[2] != null) System.out.println("East: " + exits[2].getShortDescription());
		if (exits[3] != null) System.out.println("West: " + exits[3].getShortDescription());
		if (exits[4] != null) System.out.println("Up: " + exits[4].getShortDescription());
		if (exits[5] != null) System.out.println("Down: " + exits[5].getShortDescription());
	}

	// Get a specific exit
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
			//System.out.println("GE Sorry, I do not recognize that command \n");
			return null;
		}
	}

	public void setLocks(int a, int b, int c, int d, int e, int f) {
		locked[0] = a;
		locked[1] = b;
		locked[2] = c;
		locked[3] = d;
		locked[4] = e;
		locked[5] = f;
	}

	// Is the room locked?
	public int getLock(String direction) {
		switch (direction) {
		case "north":
			return locked[0];
		case "south":
			return locked[1];
		case "east":
			return locked[2];
		case "west":
			return locked[3];
		case "up":
			return locked[4];
		case "down":
			return locked[5];
		default:
			System.out.println("Sorry, I do not recognize that command \n");
			return -1;

		}
	}

	// Lock the door
	public void lock(String direction, Room nextRoom) {
		switch (direction) {
		case "north":
			nextRoom.locked[1] = 1;
			locked[0] = 1;
			break;
		case "south":
			nextRoom.locked[0] = 1;
			locked[1] = 1;
			break;
		case "east":
			nextRoom.locked[3] = 1;
			locked[2] = 1;
			break;
		case "west":
			nextRoom.locked[2] = 1;
			locked[3] = 1;
			break;
		case "up":
			nextRoom.locked[5] = 1;
			locked[4] = 1;
			break;
		case "down":
			nextRoom.locked[4] = 1;
			locked[5] = 1;
			break;
		default:
			System.out.println("Sorry, I do not recognize that command \n");
			break;
		}
	}

	// Unlock the door
	public void unlock(String direction, Room nextRoom) {
		switch (direction) {
		case "north":
			nextRoom.locked[1] = 0;
			locked[0] = 0;
			break;
		case "south":
			nextRoom.locked[0] = 0;
			locked[1] = 0;
			break;
		case "east":
			nextRoom.locked[3] = 0;
			locked[2] = 0;
			break;
		case "west":
			nextRoom.locked[2] = 0;
			locked[3] = 0;
			break;
		case "up":
			nextRoom.locked[5] = 0;
			locked[4] = 0;
			break;
		case "down":
			nextRoom.locked[4] = 0;
			locked[5] = 0;
			break;
		default:
			System.out.println("Sorry, I do not recognize that command \n");
			break;
		}
	}

	// Break the door
	public void breakLock(String direction, Room nextRoom) {
		switch (direction) {
		case "north":
			nextRoom.locked[1] = -1;
			locked[0] = -1;
			break;
		case "south":
			nextRoom.locked[0] = -1;
			locked[1] = -1;
			break;
		case "east":
			nextRoom.locked[3] = -1;
			locked[2] = -1;
			break;
		case "west":
			nextRoom.locked[2] = -1;
			locked[3] = -1;
			break;
		case "up":
			nextRoom.locked[5] = -1;
			locked[4] = -1;
			break;
		case "down":
			nextRoom.locked[4] = -1;
			locked[5] = -1;
			break;
		default:
			System.out.println("Sorry, I do not recognize that command \n");
			break;
		}

	}

}
