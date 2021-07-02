package game;

import fixtures.Item;
import fixtures.Room;

public class Player {

	private Item[] inventory = new Item[4]; // What items you have
	private Room currentRoom; // Where the player is
	private int carry = 0; // How many items you have

	protected void currentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	protected void getInventory() {
		System.out.println("You are carrying:\n");

		if (carry == 0) System.out.println("Nothing \n\n");
		else {
			for (int i = 0; i < carry; i++) {
				System.out.println(inventory[i]);

			}
		}
	}

	protected boolean move(Room nextRoom) {
		if (nextRoom != null) {			
			currentRoom = nextRoom;
			return true;
		} else 
			return false;
				
	}
		

	protected void addItem(Item item) {
		if (carry == 4) System.out.println("You cannot carry more items");
		else {
			inventory[carry] = item;
			carry++;
		}
	}

	protected void removeItem(Item item) {
		if (carry == 0) {
			System.out.println("You are not carrying anything");
		} else {
//			int check = -1;
			for (int i = 0; i < carry; i++) {

			}

		}
	}

}