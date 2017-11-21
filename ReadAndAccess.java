import java.io.File;
import java.util.Scanner;


public class ReadAndAccess {
	 public static void main (String[] args) throws java.lang.Exception
	    {
	       File file = new File("C:\\GFApps\\employee.csv");
	        Scanner sc = new Scanner(file);
	        
	        while (sc.hasNextLine())
	      System.out.println(sc.nextLine());
	        sc.close();
	        
	        
	    }
}
