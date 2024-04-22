package interfaceExample2;
/**
 * This is Displayable interface
 *
 */
public interface Displayable {
	
	//void displayInPopupWindow(String s);  //by default, this method is a public abstract method
	default void displayInConsole(String s)  //default method is implemented in the interface as a public method
	{
		System.out.println(s + " class object instance is displayable in console area.");
	}
	
}
