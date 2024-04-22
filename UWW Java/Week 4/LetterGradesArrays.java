
//Letter Grades using arrays example
import java.util.Arrays; //for using Arrays class
import java.util.Collections; //for using Collections class
import java.util.Scanner; 

public class LetterGradesArrays {
   public static void main(String[] args) {
      // get user input grades  
      int[] gradesArray= getInputGrades();
      if (gradesArray.length == 0) 
      {
    	  System.out.println("no grades entered!");
    	  System.exit(0);
      }
      // get grades count
      final char[] letterGrade = {'A', 'B', 'C', 'D', 'F'};     
      int[] countGrades = getGradesCount(gradesArray, letterGrade);
      
      // display grade report
      displayReport(gradesArray, letterGrade, countGrades);
      
      
      // sort grades in gradesArray
      System.out.println("before sorting: " + Arrays.toString(gradesArray));
     
      Arrays.sort(gradesArray); 
      //to get reversed order of elements in an array:  Collections.reverse(Arrays.asList(gradesArray));
      //Collections.reverse(Arrays.asList(gradesArray));
      System.out.println("after sorting: " + Arrays.toString(gradesArray));
      
      //search grade in gradesArray
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter a grade that you want to search: ");
      int searchG = keyboard.nextInt();
      
      int index = Arrays.binarySearch(gradesArray, searchG);
      if (index >=0) 
    	  System.out.println("find that grade in the grades array, at gradesArray["+index+"]: " + gradesArray[index]);
      else   
    	  System.out.println("Did not find that grade");
       
   } //end of the main method

  /**
   * getInputGrades: to get user input numerical grades
   * @return int[] a numerical grade array
   */
   public static int[] getInputGrades() 
   {
	   Scanner input = new Scanner(System.in);
       System.out.println("How many grades that you want to input? ");   
       int numGrades = input.nextInt();
   
       int[] scoreArray = new int[numGrades]; 
   
      System.out.println("Enter " + numGrades + " grades, separate them by whitespace");
       
      for (int i=0; i<numGrades; i++) { 
          int grade = input.nextInt(); // read grade
          if (grade < 0 && grade > 100){
        	  System.out.println("invalid input!"); 
        	  System.exit(1);
          }
          scoreArray[i] = grade;
      }
      
      return scoreArray;
   }
   
   /**
    * getGradesCount: to count grades in each grade range: A (90-100), B (80-89), C (70-79), D (60-69), F (<60)
    * @param gradesArray
    * @param letterGrade
    * @return
    */
   public static int[] getGradesCount(int[] gradesArray, char[] letterGrade)
   {   
	   int[] countGrades = new int[letterGrade.length];
	   for (int grade: gradesArray) 
	   {
		   switch (grade / 10) {                          
			   case 9:  // grade was between 90              
			   case 10: // and 100, inclusive                
			      ++countGrades[0];                               
			      break; // exits switch                  
			   case 8: // grade was between 80 and 89        
				   ++countGrades[1];                               
			      break; // exits switch                      
			   case 7: // grade was between 70 and 79        
				   ++countGrades[2];                              
			      break; // exits switch                      
			   case 6: // grade was between 60 and 69        
				   ++countGrades[3];                               
			      break; // exits switch                      
			   default: // grade was less than 60            
				   ++countGrades[4];                               
			      break; // optional; exits switch anyway 
		   } //end of switch-case 
        } // end of the for loop
	   
	   return countGrades;
   }
   
   /**
    * displayReport:  print out: total and average grade, and grades distribution 
    * @param gradesArray
    * @param letterGrade
    * @param countGrades
    */
   public static void displayReport(int[] gradesArray, char[] letterGrade, int[] countGrades)
   {
	   System.out.printf("%nGrade Report:%n");
	   // calculate average of all grades entered
	   int total = 0;
	   for (int grade: gradesArray)
	   {
		   total += grade;
	   }
       double average = (double) total / gradesArray.length;  

       // output summary of results
       System.out.printf("Total of the %d grades entered is %d%n", 
          gradesArray.length, total);
       System.out.printf("Class average is %.2f%n", average);
       System.out.println("Number of students who received each grade:");
       for (int i=0; i<letterGrade.length; i++) {
          System.out.printf("%s: %d %s%n", 
            "Grade "+ letterGrade[i], countGrades[i], "*".repeat(countGrades[i]));  // display number of each grade counted
       } 
   }
   
}


