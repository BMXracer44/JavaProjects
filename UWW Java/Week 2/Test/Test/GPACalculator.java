package Test;

import java.util.*;

public class GPACalculator {

	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//Step 1 - Get user input grade for each class
		//prompt user to enter grade for each class by using keyboard
		//prompt user to enter units for each class by using keyboard
        String grade = ""; //for user input grade for each class
        int units = 0; //for user input units for each class

		double gpa = 0;
        double honorPoints = 0; //for honor points converted from each grade
        double gradePoints = 0, totalGradePoints = 0, totalUnits = 0;		
		//implementation: create a Scanner class object to get user keyboard input
		//Use a while loop to allow user to enter grades and units for multiple classes
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a grade for your class: ");
		grade = input.next();
		System.out.println("Input grade: " + grade);

		System.out.println("Enter units for your class: ");
		units = input.nextInt();
		System.out.println("Input units: " + units);
		if(units <= 0 ){
			System.out.println("Invalid inputs!");
			System.exit(1);
		}
		
		units = getUnits(input); //Use scanner object as the argument in the method call
		//Step 2 - Determine Honor Points for each class
		honorPoints = getHonorPoints(grade);
		if(honorPoints < 0){
			continue;
		}
		else{
			System.out.println("honorPoints: " + honorPoints);			
		}


		//get total grade points and units for all classes
		totalGradePoints += (honorPoints * units);
		totalUnits += units;

		//Ask user if they want to add more classes
		System.out.println("Enter Y/y if you want to add more classes. ");
		if(!input.next().equalsIgnoreCase("Y")){
			break;
		} //If user does not want to add more classes, exit the loop

		//Step 3 – Calculate GPA
		gpa = totalGradePoints / totalUnits;
		
		//Step 4 - Output GPA 
		System.out.printf("");
		
		
	}
	
 //Define getUnits() method       
	public static int getUnits(Scanner keyboard) {
		int units = 3;
		//prompt user to enter units for a class
		//....
		while(true) {
			System.out.println("Enter number of units for a class: ");
			try{ //add try block
				units = keyboard.nextInt(); 
			}
			catch(InputMismatchException e){
				System.out.println("Invalid input! Enter an integer");
				keyboard.nextLine(); // read in all user input (which is the invalid data), ignore
				continue; //Continue the loop from the beginning
			}
			System.out.println("input units: " + units);
		
		//If user didn't enter valid numerical data, then the system will throw an exception error
		//which is called input mismatch exception

		if(units <= 0){
			System.out.println("Invalid input!");
			System.exit(1);
		}
		else{
			break; //Get valid user input units, exit the loop
		}
	}
		return units;
	}
	
//Define getHonorPoints() method
	public static double getHonorPoints() {
	   double honorPoints = -1;
	   //prompt user to enter grade for a class
	    //.....
		switch (grade.toUpperCase()) {
			case "A+" :
				

			case "F" :
	    return honorPoints;
	}
}
