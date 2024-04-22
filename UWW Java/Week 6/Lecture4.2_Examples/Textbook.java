/**
 * This Textbook class holds data about a textbook
 *
 */
public class Textbook {

	private String title;	// title of the book
	private String author;	// author of the book
	private String publisher; //publisher of the book
	
	/** 
	 * This Constructor initializes the text book information 
	 *  @param  title The title of the book
	 *  @param  author The author of the book
	 *  @param  publisher The publisher of the book
	 */
	public Textbook (String title, String author, String publisher)
	{
		this.title = title;  
		this.author = author;
		this.publisher = publisher;
	}
	
	/** 
	 * The copy constructor initialize a Textbook object
	 * as a copy of another Textbook object
	 * @param text The Textbook object to copy
	 */
	public Textbook (Textbook text)
	{
		title = text.title;
		author = text.author;
		publisher = text.publisher;
	}
	
	/**
	 * The reset method sets a value for each field,
	 *  @param  title The title of the book
	 *  @param  author The author of the book
	 *  @param  publisher The publisher of the book
	 */
	public void reset(String title, String author, String publisher)
	{
		this.title = title;  
		this.author = author;
		this.publisher = publisher;
	}
	
	/**
	 * toString method
	 * @return A string containing a Textbook object information.
	 */
	public String toString()
	{
		//Create a string representing the information about object.
		String str = "\n Title: " + title + "\n Author: " + author +
				"\n Publisher: " + publisher;
		//return the string
		return str;
	}
}
