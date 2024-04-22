
import java.util.Scanner;

public class Restaurant {
   private String name;
   private Reviews reviews = new Reviews();
   
   public void setName(String restaurantName) {
      name = restaurantName;
   }
   
   //add getName method
   public String getName()
   {
	   return name;
   }
   
      
   public void addReviews(Scanner scnr) {
	  System.out.println("Type rating + comments. To end: -1");
      reviews.inputReviews(scnr);
   }
   
   public void printCommentsByRating() { 
      System.out.println("Comments for each rating level: ");
      for (int i = 1; i <= 5; ++i) {
         System.out.println(i + ":");
         reviews.printCommentsForRating(i);
      }
   }
   
   //Add a method:  getAvgRating() which returns the average rating of a restaurant
   
   public double getAvgRating() {
	   return reviews.getAverageRating();
   }
   
}