
// Use 2D arrays to store grades for multiple grade items

import java.util.Arrays;
import java.util.Scanner; 

public class LetterGrades2DArrays {
	
   private static final double[] WEIGHTS = {0.3, 0.4, 0.3};  //30%, 40%, and 30%
   private static final String[] GRADEITEMS = {"Assignments", "Exams", "Labs"}; //three grading items
   
   public static void main(String[] args) {
	  // a student has six assignment grades (30%, 5% each), two exam grades (40%, 20% each), ten lab practice grades (30%, 3% each) 
	  int numAss = 6; 
	  int numExam = 2;
	  int numLab = 10;

	  
	  // get user input grades 
      int[][] gradesArray= getInputGrades(numAss, numExam, numLab); 
      
	  for (int[] grade: gradesArray) 
	  {
		  if (grade.length == 0) {
			  System.out.println("no grades entered!");
    	      System.exit(0);
		  }	  
	  }
           
	  //Storing those grades, and find average grade for each grade item, and calculate total weighted grade
      // display grades
	  displayReport(gradesArray);

      
      
   } //end of the main method

	/**
	 * displayReport: display total, average and weighted average and final letter grade
	 * @param gradesArray
	 */
   public static void displayReport(int[][] gradesArray){
	   
       int[] total = new int[GRADEITEMS.length]; 
       double[] average = new double[GRADEITEMS.length];
       
	   for (int row = 0; row < gradesArray.length; row++) {
		   System.out.print(GRADEITEMS[row]+ ": ");
		   //System.out.println(Arrays.toString(gradesArray[row]));
		   
		   for (int col = 0; col < gradesArray[row].length; col++) {
			   System.out.print(gradesArray[row][col] + " ");
			   total[row] += gradesArray[row][col];
		   }
		   
		   System.out.println("\nTotal Score: " + total[row]);
		   
		   average[row] = total[row]/gradesArray[row].length;
		   System.out.printf("Average Score: %.2f\n", average[row]);
		   System.out.println ("-".repeat(20));
	   }
		  //calculate weight average grade
		   double weightedAvg = 0;
		   for (int row= 0; row < gradesArray.length; row++){
			   weightedAvg += WEIGHTS[row]*average[row]; 
		   }
		   System.out.printf("\nWeighted Average Grade: %.2f\n", weightedAvg); 
		   System.out.printf("Final Letter Grade: %s\n", getLetterGrade(weightedAvg)); 
	   
	   
   }
   
   /**
    * getLetterGrade: find letter grade based on weighted avg grade
    * @param weightedAvg
    * @return
    */
   public static String getLetterGrade(double weightedAvg) {
	   String letterGrade = "";
	   int avgScore = (int)weightedAvg/10;
	   if ( avgScore >= 9) 
		   letterGrade = "A";
	   else if (avgScore == 8)
		   letterGrade = "B";
	   else if (avgScore == 7)
		   letterGrade = "C"; 
	   else if (avgScore == 6)
		   letterGrade = "D"; 
	   else
		   letterGrade = "F";
	   
	   return letterGrade;
			   		   
   }
   
   /**
    * getInputGrades: to get user input numerical grades
    * @param numAss
    * @param numExam
    * @param numLab
    * @return int[][] //a 2D array
    */

   public static int[][] getInputGrades(int... item) //int... is known as variable argument, which allows to accept one or more than one integer arguments
   {
       //declare a 2D array
	   int numItem = GRADEITEMS.length;
	   int[][] scoreArrays = new int[numItem][]; //create an 2D array, and specified size of first dimension
       for (int i= 0; i<numItem; i++) {
    	   scoreArrays[i] = new int[item[i]]; //parameter item is accessed as an array
    	   scoreArrays[i] = getScores(item[i], GRADEITEMS[i]); //call getScores method to get scores for each grade item
       }
   
       return scoreArrays;
    }
   
   /**
    * getScores: to get user input numerical grades for each grade item 
    * @param numGrades
    * @param item
    * @return int[] a score array
    */
   //
   public static int[] getScores(int numGrades, String item) {
	   Scanner input = new Scanner(System.in);
       System.out.println("Enter " + numGrades + "  "+ item + " grades, separate them by whitespace");
       int[] scoreArray= new int[numGrades];
       
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
   
  
   
  }


