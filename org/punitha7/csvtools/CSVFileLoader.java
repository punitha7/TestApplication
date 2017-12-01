package org.punitha7.csvtools;

import java.io.File;

/**
 * Static methods to load CSV files
 * 
 * @author Jesse Pospisil <posmicanomaly@gmail.com>
 *
 */
public abstract class CSVFileLoader {
	
	/**
	 * Load a CSV file from disk
	 * @param filepath
	 * @return file CSVFile
	 */
	public static CSVFile loadFile(String filepath) {
		CSVFile result = null;
		
		File file = new File(filepath);
		if(file.exists()) {
			result = new CSVFile(file);
		} else {
			System.out.println("error: " + filepath + " is not found");
		}
		return result;
	}
}
