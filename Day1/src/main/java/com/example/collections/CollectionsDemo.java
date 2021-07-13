package com.example.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CollectionsDemo {

	public static void main(String[] args) {
		
	
	//Lists
	List<User> userArrayList = new ArrayList<User>();
	
	// add user
	userArrayList.add(new User("Summer", "Smith", "sssumertime"));
	userArrayList.add(new User("Summer2", "Smith2", "sssumertime2"));
	userArrayList.add(new User("Summer3", "Smith3", "sssumertime3"));
	
	
	//use like array
	System.out.println("Regular old for loop with ArrayList");
	for(int i=0; i<userArrayList.size(); i++) {
		System.out.println(userArrayList.get(i));
	}
	
	System.out.println();
	
	//Linked List
	List<User> userLinkedList = new LinkedList<User>();
	userLinkedList.add(new User("Summer", "Smith", "sssumertime"));
	userLinkedList.add(new User("Summer2", "Smith2", "sssumertime2"));
	userLinkedList.add(new User("Summer3", "Smith3", "sssumertime3"));
	
	Iterator<User> linkedListIterator = userLinkedList.iterator();
	
	System.out.println("Iterating with Iterator");
	while(linkedListIterator.hasNext()) {
		System.out.println(linkedListIterator.next());
	}
	System.out.println();
	//Sets
	Set <User>userSet = new HashSet<User>();
	
	User beth = new User("1","2","3");
	
	userSet.add(beth);
	userSet.add(beth);
	
	System.out.println("Looping the set");
	for(User user : userSet) {
		System.out.println(user);
	}
	
	//Queue
	ArrayDeque<User> userQueue = new ArrayDeque<User>();
	
	// add a User to the beginning
	userQueue.push(beth);
	System.out.println(userQueue);
	
	// add a User to the end with .add
	userQueue.add(new User("2","3","4"));
	System.out.println(userQueue);
}
}