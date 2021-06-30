package game;

import fixtures.Item;
import fixtures.Room;

public class Player {

	Item[] inventory = new Item[4]; // What items you have
	Room currentRoom; // Where the player is
	int carry = 0; // How many items you have

	void currentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	void getInventory() {
		System.out.println("You are carrying:\n");

		if (carry == 0) {
			System.out.println("Nothing \n\n");
		} else {
			for (int i = 0; i < carry; i++) {
				System.out.println(inventory[i]);

			}
		}
	}

	void addItem(Item item) {
		if (carry == 4) {
			System.out.println("You cannot carry more items");
		} else {
			inventory[carry] = item;
			carry++;
		}
	}

	void removeItem(Item item) {
		if (carry == 0) {
			System.out.println("You are not carrying anything");
		} else {
//			int check = -1;
			for (int i = 0; i < carry; i++) {

			}

		}
	}

}