package org.punitha7.csvtools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Representation of a loaded CSV file
 * 
 * @author Jesse Pospisil <posmicanomaly@gmail.com>
 *
 */
public class CSVFile {

	// Need enum for HEADER and NOHEADER
	
	private ArrayList<String> header;
	private ArrayList<HashMap<String, String>> rows;

	/**
	 * Build a CSVFile from a File object
	 * @param file File object of a CSV file
	 */
	public CSVFile(File file) {
		rows = loadCSVFile(file);
	}
	
	private ArrayList<String> parseHeader(String line) {
		ArrayList<String> result = new ArrayList<>();
		
		String[] splitLine = line.split(",");
		
		for(String s : splitLine) {
			result.add(s);
		}
		
		return result;
	}
	
	/**
	 * Count how many values are in a line. Can be used to help make a default header
	 * @param line
	 * @return
	 */
	private int countValues(String line) {
		int count = 0;
		
		return count;
	}
	
	/**
	 * Create a default header for when there is no header
	 * @param columns
	 * @return
	 */
	private ArrayList<String> createDefaultHeader(int columns) {
		ArrayList<String> result = new ArrayList<>();
		
		return result;
	}
	
	private HashMap<String, String> parseLine(String line) {
		HashMap<String, String> result = new HashMap<String, String>();
		
		String[] splitLine = line.split(",");
		
		for(int i = 0; i < header.size(); i++) {
			result.put(header.get(i), splitLine[i]);
		}
		
		return result;
	}
	
	
	private ArrayList<HashMap<String, String>> loadCSVFile(File file) {

		ArrayList<HashMap<String, String>> result = new ArrayList<>();
		Scanner scanner = null;
		//todo: need to add check if we need to make a default header before adding rows
		boolean headerRow = true;
		try {
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				if(headerRow) {
					header = parseHeader(line);
					headerRow = false;
				} else {
					HashMap<String, String> parsedLine = parseLine(line);
					result.add(parsedLine);
				}
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
		
		for(String s : header) {
			result += "[" + s + "] ";
		}
		result += System.lineSeparator();
		
		for(HashMap<String, String> row : rows) {
			
			for(String s : header) {
				result += "[" + row.get(s) + "] ";
			}
			
			result += System.lineSeparator();
		}
		
		return result;
	}
	
	public ArrayList<String> getColumnValues(String columnName) {
		ArrayList<String> result = new ArrayList<>();
		
		for(HashMap<String, String> row : rows) {
			result.add(row.get(columnName));
		}
		
		return result;
	}
	
}
