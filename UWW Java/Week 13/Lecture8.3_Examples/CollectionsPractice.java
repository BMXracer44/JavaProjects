
// Programming Practice 8.3.1
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class CollectionsPractice {
   public static void main(String[] args) {
	   
      
      String[] colorVotes = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN", "YELLOW", "BLUE", "RED", "GREEN", "ORGANGE"};
     //(1) Create a List collection (e.g., ArrayList) and add elements from colorVotes array to the list
    
      
      //(2-1) call outputList method to print out colorList
      
      
      //(3-1) call addColors method to ask user to add more colors to the color list
     
      
      //create a remove color list
      List<String> removeList =  Arrays.asList("RED", "WHITE", "BLUE");
      System.out.println(removeList.getClass()); //what is the class name of the removeList:  
      System.out.println(removeList instanceof ArrayList); //get class name of the object
      
      //(4-1) call outputList method to print out remove color list
      

      //(4-2) call removeColors method to remove colors in color list based on the remove color list: removeList 
      
      
     // 6-1: call sortColors method to sort colors in descending order
     
   }
   
   //2-2: complete outputList() method to print out a given list to console
   private static void outputList(String s, List<String> list) { 
	      System.out.printf("%s: ", s);
	      for (int count = 0; count < list.size(); count++) {
	         System.out.printf("%s ", list.get(count));
	      }	      
	      System.out.println();
   }
   
   //3-2: complete addColors() method to ask user to add one or more than one colors
   private static void addColors(List<String> colorList, Scanner s) {
	   //add code here
	   System.out.println("Enter your color choice(s), separate by space: ");
	   String input = s.nextLine().toUpperCase();
	   String[] colors = input.split(" ");
	   colorList.addAll(Arrays.asList(colors));
	   outputList("updated color list", colorList);
	  
   }
   
   //4-3: complete removeColors() method to remove colors specified in removeList from colorList
   private static void removeColors(List<String> colorList, List<String> removeList) {
       //add code here
        colorList.removeAll(removeList); 
        outputList("after remove, color list" ,  colorList);
   }
   
   //5-2: complete sortColors() method to sort colors in colorList
   private static void sortColors(List<String> colorList) {
        //add code here
	   colorList.sort(null); //sort colors by using natural order of string data (A->Z)
	   outputList("after sort", colorList);
   }
   
   //step 6: complete sortColors() method to sort colors 

    
}

