package com.examples.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class FileIO<T> {

	private String filename;
	
	public FileIO(String filename) {
		this.filename = filename;
	}
	
	public ArrayList<T> readObject() throws FileNotFoundException, IOException {
		ArrayList<T> ret;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		try {
			ret = (ArrayList<T>) ois.readObject();
			return ret;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		}
	}

