// Restaurant.java
public class Restaurant extends Business {
   private int rating;
   
   
   public void setRating(int rating) { 
	   this.rating = rating;  
   }
   
   public int getRating(){
	   return rating;
   }
   
   @Override
   public String toString() {  
	   return super.toString() + "\n  Rating: " + rating;
   }
}