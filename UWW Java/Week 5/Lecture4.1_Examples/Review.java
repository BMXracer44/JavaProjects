
public class Review {

	private int rating = -1;  
	private String comment = "NoComment";
	
	public void setRatingAndComment (int revRating, String revComment) {
		rating = revRating;
		comment = revComment;
	}

	public int getRating() {return rating; }
	
	public String getComment() {return comment; }
	
	//add a toString() method to return a string contains all info about a review
	public String toString() {
		return String.format("%d:%s", rating, comment);
	}
}
