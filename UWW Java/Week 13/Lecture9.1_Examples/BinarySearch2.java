import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySearch2 {
   public static int binarySearch(List<String> data, String key) {
      int mid;
      int low;
      int high;
      
      low = 0;
      high = data.size() - 1;

      while ( (data.get(high)).compareTo(data.get(low)) >= 0) {
         mid = (high + low) / 2;
      System.out.println("high index:" + high);
      System.out.println("low index:" + low);
      System.out.println("mid index:" + mid);
      System.out.println("mid:" + data.get(mid));
         if ((data.get(mid)).compareTo(key) < 0) {
            low = mid + 1;          
         } 
         else if ((data.get(mid)).compareTo(key) > 0) {
            high = mid - 1;
         } 
         else {
            return mid;
         }
      }

      return -1; // not found
   }

   public static void main(String [] args) {
	      Scanner scnr = new Scanner(System.in);
	      String[] names = {"Smith", "Aaron", "Sue", "Bob", "Jack", "Tina", "Wallton"};
	      List<String> nameList = new ArrayList<String>(Arrays.asList(names));
	      String key;
	      int keyIndex;

	      System.out.print("Enter a value: ");
	      key = scnr.nextLine();
 
	      nameList.sort(null); //sort the list first
	      System.out.print("names: ");
	      for (String n: nameList) {
	         System.out.print(n + " ");
	      }
	      System.out.println();
	      keyIndex = binarySearch(nameList, key);

	      if (keyIndex == -1) {
	         System.out.println(key + " was not found.");
	      } 
	      else {
	         System.out.println("Found " + key + " at index " + keyIndex + ".");
	      }
	      
	      scnr.close();
	   }
   
}