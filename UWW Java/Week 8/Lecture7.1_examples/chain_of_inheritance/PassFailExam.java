package chain_of_inheritance;
/**
 * a class that determines a passing or failing grade for an exam
 *
 */
public class PassFailExam extends PassFailActivity {
	
	private int numQuestions; // number of questions
	private double pointsEach;  //points for each question
	private int numMissed; // Questions missed

	/** The constructor sets the number of questions on the
	 * exam and the number of questions missed
	 * @param questions The number of questions
	 * @param missed The number of questions missed
	 */
	public PassFailExam(int questions, int missed, double minPassing)
	{
		//Call the superclass constructor
		super(minPassing);
		
		//Declare a local variable for the score
		double numericScore;
		
		//set the numQuestions and numMissed fields
		numQuestions = questions;
		numMissed = missed;
		
		//Calculate the points for each question and the 
		//numeric score for this exam.
		pointsEach = 100.0 / questions;
		numericScore = 100.0 - (missed*pointsEach);
		
		//Call the inherited setScore method to set the numeric score
		setScore(numericScore);
	}
	
	/** The getPointsEach method returns the
	 * number of points each question is worth.
	 * @return The value in the pointsEach field
	 */
	public double getPointsEach()
	{
		return pointsEach;
	}
	
	/**The getNumMissed method returns the
	 * number of questions missed
	 * @return The value in the numMissed field
	 */
	public int getNumMissed()
	{
		return numMissed;
	}
	
	
}
