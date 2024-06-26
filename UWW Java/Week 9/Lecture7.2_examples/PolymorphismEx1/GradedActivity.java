package PolymorphismEx1;
/**
 * a class that holds a grade for a graded activity
 *
 */
public class GradedActivity {
	
	private double score; // numerical score

	/** The setScore method sets the score field,
	 *  @param s The value to score in score.
	 */
	public void setScore(double s)
	{ score = s;  }
	
	/** The getScore method returns the score
	 * @return The value stored in the score field
	 */
	public double getScore()
	{  return score; }
	
	/** The getGrade method returns the score
	 * @return The value stored in the score field
	 */
	public char getGrade()
	{
		char letterGrade;
		if (score >=90)
			letterGrade = 'A';
		else if (score >=80)
			letterGrade = 'B';
		else if (score >=70)
			letterGrade = 'C';
		else if (score >=60)
			letterGrade = 'D';
		else
			letterGrade = 'F';
		
		return letterGrade;
	}
}
