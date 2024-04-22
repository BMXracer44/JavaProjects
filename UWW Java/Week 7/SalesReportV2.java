import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/** This program demonstrates how exception handlers can be used to recover from errors
 */
public class SalesReportV2 {

	public static void main(String[] args) {
		
		
		int months = 0;
		double totalSales = 0.0;
		double averageSales = 0.0;
		
		ArrayList<Double> sales = new ArrayList<Double>();
		
		//Attempt to open the file by calling the openFile method.
		
		Scanner inputFile = null;
		while(true) {
			System.out.println("Enter a file name:");
			Scanner kreader = new Scanner(System.in);
			String filename = kreader.nextLine().trim();
		    try {
			  inputFile = openFile(filename); 
			  break;
		    }
		    catch(FileNotFoundException e) {
	    	   System.out.println(filename + " File not found! Try again? (Press q to quit, others continue)");
	    	   if (kreader.hasNextLine()) {
	    	     char quit = kreader.nextLine().strip().toUpperCase().charAt(0);
	    	     if (quit == 'Q' )
	    		   System.exit(1);  
		       }
	    	   else
	    		   continue;
		    }
		}
		
		//call getData() method and getTotalSales() method
		if (getData(inputFile, sales))
		{
			
			
			//Calculate the average
			
			
			//Display the results
			System.out.printf("Number of months: %d\n" + "Total Sales: $%,.2f\n" + "Average Sales: $%,.2f\n ",
								months, totalSales, averageSales);
		}
		else
			System.out.println("No valid sales data! Check your sales data file.");
		
		//Close the file
		inputFile.close();
	} //end of main
	
	/**
	 * The opeFile method opens the specified file and returns a reference to a Scanner object.
	 * @param filename The name of the file to open.
	 * @return A Scanner reference, if the file exists Otherwise, null is returned 
	 */
	public static Scanner openFile(String filename) throws FileNotFoundException
	{   
		File file = new File(filename);
		Scanner scan = new Scanner(file);  //add exception handler or throws clause: FileNotFoundException
		return scan;
	 }//end of openFile
	
	/**
	 * Read data from input file
	 * @param inputFile
	 * @param sales
	 * @return boolean
	 */
	public static boolean getData(Scanner inputFile, ArrayList<Double> sales) {
		//process the contents of the file.
		double data= 0;
		while(inputFile.hasNext())
		{
			try {
				data = inputFile.nextDouble();
				sales.add(data); //if get valid data, add to the array list
			}
			catch(InputMismatchException e) { //if a data read in can not be convert to double 
				System.out.println("A non-numerical data found in the file. will ignore that data" + inputFile.next());
			}
		}
		
		if (sales.size() > 0)  
			return true;
		else 
		    return false;
	}
	
	/**
	 * calculate and return total sales 
	 * @param sales
	 * @return double 
	 */
	public static double getTotalSales(ArrayList<Double> sales) {
		double totalSales = 0;
		
		return totalSales;

	}
	
}//end of class
