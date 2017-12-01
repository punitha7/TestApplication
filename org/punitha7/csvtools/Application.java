package org.punitha7.csvtools;

public class Application {
	
	public Application() {
		
	}
	
	private void run() {
		String filepath = "employee_header.csv";
		
		CSVFile csvFile = CSVFileLoader.loadFile(filepath);
		
		if(csvFile != null) {
			System.out.println(csvFile);
			
			for(String s : csvFile.getColumnValues("name")) {
				System.out.println("Name=> " + s);
			}
		} else {
			System.out.println("error: csvfile is null =(");
		}
	}
	
	public static void main(String[] args) {
		Application app = new Application();
		app.run();
	}
}
