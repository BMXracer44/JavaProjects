
// Programming Practice 8.3.1
import java.util.*;

public class CollectionsPractice2Final {
   public static void main(String[] args) {
	   
      String[] colorVotes = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN", "YELLOW", "BLUE", "RED", "GREEN", "ORGANGE"};
    
      //(1) Create a List collection (e.g., ArrayList) and add elements from colorVotes array to the list
      List<String> colorList = new ArrayList<String>(Arrays.asList(colorVotes));
      
      //(2-1) call outputList method to print out colorList
      outputList("colo list", colorList);
      
      //(3-1) call addColors method to ask user to add more colors to the color list
      addColors(colorList, new Scanner(System.in));  
      
      //create a remove color list
      List<String> removeList =  Arrays.asList("RED", "WHITE", "BLUE");
      System.out.println(removeList.getClass()); //what is the class name of the removeList:  
      System.out.println(removeList instanceof ArrayList); //get class name of the object
      
      //(4-1) call outputList method to print out remove color list
      outputList("remove color list", removeList);

      //(4-2) call removeColors method to remove colors in color list based on the remove color list: removeList 
      removeColors(colorList, removeList);
      
     // 6-1: call sortColors method to sort colors in descending order
     sortColors("ascending", colorList);
     
     sortColors("descending", colorList);
     
     
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
   /*private static void sortColors(List<String> colorList) {
        //add code here
	   colorList.sort(null); //sort colors by using natural order of string data (A->Z)
	   outputList("after sort", colorList);
   }
   */
   //step 6: complete sortColors() method to sort colors 
   private static void sortColors(String order, List<String> colorList) {
	         Collections.sort(colorList); //natural order of sort Strings, ascending order
	         if(order.equalsIgnoreCase("descending")) {
	        	 Collections.reverse(colorList);
	         }
	         outputList("after sort", colorList);
   }

   //7: Call searchColors method to search colors
   searchColors(colorList);

   //8: Call countColors method
   countColors(colorList);

   //step 7, add a searchColors() method
   public static void searchColors(List<String> colorList){
      Scanner s = new Scanner(System.in);
      while(true){
         System.out.println("Enter the color(s) you want to search: ");
         String input = s.nextLine().trim().toUpperCase();
         String[] colors = input.split("\\s+");
         System.out.println("Colors that you want to search: " + Arrays.toString(colors));

         Collections.sort(colorList) ;//Sort color list before search
         outputList("Color list before search: ", colorList);

         for(String color : colors){
            System.out.println("Search for " + color);
            int result = Collections.binarySearch(colorList, color);
            if(result >= 0){
               System.out.println("Find matched color(" + color + ") at index =" + result);
            }
            else{
               System.out.println("Did not find matched color");
            }

            System.out.println("Want to search again? (y=yes, n = no)");
            if(s.nextLine().trim().equalsIgnoreCase("n")) break;
         }

      }
   }

   //step 8: add countColors() method
   public static void countColors(List<String> colorList){
      Map<String, Integer> frequencyMap = new HashMap<>();
      for (String s : colorList){
         frequencyMap.put(s, Collections.frequency(colorList, s));
         System.out.printf("%-10s%10d%n", s, frequencyMap.get(s));
      }
      Set<String> keys = frequencyMap.keySet();
      for(String s: keys){
         System.out.printf("%-10s%10d%n", s, frequencyMap.get(s));
      }
   }
    
}

