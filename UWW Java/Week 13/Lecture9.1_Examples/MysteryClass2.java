//Recursion Example-2: MysteryClass2.java
public class MysteryClass2 {
   public static String mystery(int[] array2, int x) {
      if (x < array2.length) {
         return String.format(
            "%s%d ", mystery(array2, x + 1), array2[x]);
      }
      else { 
         return "";
      }
   } 
   public static void main(String[] args) {
      int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      String results = mystery(array, 0);
	  String results2 = mystery(array, array.length);
      System.out.println("results: " + results);
	  System.out.println("results2: " + results2);
   }
}

