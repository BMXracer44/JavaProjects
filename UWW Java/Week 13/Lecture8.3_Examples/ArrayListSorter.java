//use Collections.sort() method to sort Integers in ArrayList
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSorter {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      final int NUM_ELEMENTS = 5;                             // Number of items in array
      ArrayList<Integer> userInts = new ArrayList<Integer>(); // Array of user defined values
      int i;                                                  // Loop index

      // Prompt user for input, add values to array
      System.out.println("Enter " + NUM_ELEMENTS + " numbers...");
      for (i = 1; i <= NUM_ELEMENTS; ++i) {
         System.out.print(i + ": ");
         userInts.add(scnr.nextInt());
      }

      // Sort ArrayList of Comparable elements
      //Collections.sort(userInts);
      Collections.sort(userInts, Collections.reverseOrder());
      
      // Print sorted array
      System.out.print("\nSorted numbers: ");
      for (i = 0; i < NUM_ELEMENTS; ++i) {
         System.out.print(userInts.get(i) + " ");
      }
     
      System.out.println("");
  //  userInts.sort(null);  //will sort Integers in userInts ArrayList by natural order
      userInts.sort(Comparator.naturalOrder());
      userInts.sort(Comparator.reverseOrder());
      System.out.println( Arrays.toString(userInts.toArray()));
   }
}
