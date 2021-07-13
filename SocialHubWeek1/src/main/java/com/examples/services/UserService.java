package com.examples.services;

import java.util.ArrayList;

import com.examples.dao.FileIO;
import com.examples.models.User;

public class UserService {

	private String file;
	private FileIO<User> io;
	
	public UserService(String file) {
		this.file = file;
		this.io = new FileIO<User>(file);
	}
	
	public User signUp(String firstName, String lastName, String password) {
		ArrayList<User> users;
		
		try {
			users = io.readObject();
		} catch (FileNotFoundException e) {
			users = new ArrayList<User>();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		User u = new User(firstName, lastName, password);
		
		for(int i=1; i<users.size(); i++) {
			if(users.get(i).getUserName().equals(u.getUserName())) {
				System.out.println("Username is in use");
				return null;
			}
		}
		
		users.add(u);
		io.writeObject(users);
		return u;
	}
	
	
	public User login(String username, String password) throws InvalidCredentialsException {
		ArrayList<User> users;
		
		try {
			user = io.readObject();
		}catch(FileNotFoundException e) {
			users = new ArrayList<User>();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).gerUserName().equals(username) ) {
				if users.get(i).getPassword().equals(password) {
					System.out.println("User signed in");
					return users.get(i);
				}else {
					throw new invalidCredentialsException e) {
				}
			}
			
		}throw new InvalidCredentialsException();
		
	}
	
	public List<User> getAllUsers() {
		ArrayList<User> users;
		try {
			users = io.readObject();
		}catch(Exception e) {
			users = new ArrayList
		}
	}
}
