
/**
 * The ComSciStudent class
 */
public class ComSciStudent extends Student {
	
	//Required hours
	private final int MATH_HOURS = 20;   //math hours
	private final int CS_HOURS = 40;     //comp sci hours
	private final int GEN_ED_HOURS = 60; // Gen ed hours
	
	//hours taken
	private int mathHours;
	private int csHours;
	private int genEdHours;
	
	/** The Constructor sets the the student's name, id and year admitted
	 */
	public ComSciStudent (String n, String id, int year)
	{
		super(n, id, year);
	}
	
	/** The setCsHours method sets the number of cs hours taken
	 */
	public void setCsHours(int cs)
	{
		csHours = cs;
	}
	
	/** The setMathHours method sets the number of math hours taken
	 */
	public void setMathHours(int ms)
	{
		mathHours = ms;
	}
	
	/** The setGenEdHours method sets the number of genEd hours taken
	 */
	public void setGenEdHours(int gen)
	{
		genEdHours = gen;
	}
	
	/** The getRemainingHours method returns the number of hours 
	 * remaining to be taken. 
	 * It override the abstract method in Student class 
	 * @return The hours remaining for the student
	 */
	public int getRemainingHours() {
		int regHours, remainingHours; 
	//Calculate the require hours.
		regHours = MATH_HOURS + CS_HOURS + GEN_ED_HOURS;
	//Calculate remaining hours.
		remainingHours = regHours - (mathHours + csHours + genEdHours);
		
		return (remainingHours < 0) ? 0:remainingHours;
	}
	
}
