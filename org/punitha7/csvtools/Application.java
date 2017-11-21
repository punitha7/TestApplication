package org.punitha7.csvtools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	private String filepath;
	private ArrayList<String> fileContents;
	
	public Application() {
		
	}
	
	private void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	private String getFilepath() {
		return this.filepath;
	}
	
	/**
	 * Load the CSV file stored in filepath into fileContents
	 * 
	 * @return the success of the operation
	 */
	private boolean loadCSVFile() {
		// filepath must be set first with setFilepath
		if(this.filepath == null) {
			System.out.println("error: filepath is null");
			return false;
		}
		
		File file = new File(this.filepath);
		if(!file.exists()) {
			System.out.println("error: file not found (" + this.filepath + ")");
			return false;
		}
		
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			this.fileContents = new ArrayList<String>();
			while(sc.hasNextLine()) {
				fileContents.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("error: creating scanner failed for " + this.filepath);
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
		// fileContents will either be empty or null if an exception occurred at this point. Empty is ok, file might be empty.
		return fileContents != null;
	}
	
	/**
	 * Print the CSV file loaded into fileContents to the console
	 * 
	 */
	private void printCSVFile() {
		if(this.fileContents == null) {
			System.out.println("error: fileContents is null");
		} else {
			for(String s : this.fileContents) {
				System.out.println(s);
			}
		}
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.setFilepath("employee.csv");
		if(app.loadCSVFile()) {
			System.out.println("info: loaded " + app.getFilepath());
			app.printCSVFile();
		} else {
			System.out.println("error: could not load file");
		}
	}
}
