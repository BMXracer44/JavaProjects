/** This program demonstrates the Countable class and how to use static fields.
 */
public class StaticDemo {

	public static void main(String[] args) {

		//create three instances of the Countable class
		Countable obj1 = new Countable("table");
		Countable obj2 = new Countable("chair");
		Countable obj3 = new Countable("computer");
		Countable obj4 = new Countable("obj");
		Countable obj5 = new Countable("obj");
		
        Countable[] objs = {obj1, obj2, obj3, obj4, obj5 };
		//Countable[] objs = {new Countable("table"), new Countable("chair"), new Countable("computer"), new Countable("obj"), new Countable("obj") };
		for (int i=0; i< objs.length; i++) {
			System.out.println ("objs[" + i + "]'s instance id: " + objs[i].getObjectId());
			
		}
		//Get the number of instances from the class's static field
		//use Class to access public static field
		System.out.println (Countable.count + 
				" object instances of the class were created");

		//individual object instance to access public static field
		System.out.println (obj1.count + 
				" object instances of the class were created");
		
		System.out.println ("get private static field \"id\": " + Countable.getId()); //any problem here? even though it's static, it's private
		//Use public static method getid() to get private static variable id
		
	}	

}