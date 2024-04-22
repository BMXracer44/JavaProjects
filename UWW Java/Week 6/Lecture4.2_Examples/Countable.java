/** This class demonstrates a static field
 */
public class Countable {
	public static int count = 0;  //set up a static field, public
	private static int id = 1;    //set up a static field, private
	private String instanceId;
	
	/** The constructor increments the static field instanceCount.
	 * This keeps track of the number of instances of this class that are created
	 */
	public Countable(String name) {
		count++; 
		instanceId = name + id;
		increaseId(); //call increaseId() method
	}
	
	/** The getobjectId method 
	 * @return instanceId
	 */
	public String getObjectId() 
	{ return instanceId; }
	
	/** The increaseId method 
	 * increase id by 1
	 */
	private void increaseId()
	{  ++id; }
	
	/** The increaseId method 
	 * @return value of id
	 */
	public static int getId()
	{  return id; }

}


