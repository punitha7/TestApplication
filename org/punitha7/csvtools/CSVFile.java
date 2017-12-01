package org.punitha7.csvtools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representation of a loaded CSV file
 * 
 * @author Jesse Pospisil <posmicanomaly@gmail.com>
 *
 */
public class CSVFile {
	private ArrayList<String> rows;

	/**
	 * Build a CSVFile from a File object
	 * @param file File object of a CSV file
	 */
	public CSVFile(File file) {
		rows = loadCSVFile(file);
	}
	
	
	private ArrayList<String> loadCSVFile(File file) {
		ArrayList<String> result = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				result.add(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("error: creating scanner failed for this file");
		} finally {
			scanner.close();
		}
		return result;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for(String s : rows) {
			result += s + System.lineSeparator();
		}
		
		return result;
	}
}
