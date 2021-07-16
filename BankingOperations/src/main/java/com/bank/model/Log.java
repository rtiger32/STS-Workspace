package com.bank.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Log {

	File file;
	FileWriter f = null;
	BufferedWriter b = null;
	//PrintWriter p = null;
	
	public Log(File file) {
		this.file = file;
	}

	public void log (String text) {
		try {
			f = new FileWriter(file);
			b = new BufferedWriter(f);
			//PrintWriter p = new PrintWriter(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String text) {
		try {
			b.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
