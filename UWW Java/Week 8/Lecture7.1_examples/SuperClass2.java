//to demonstrate how superclass and subclass constructors work

public class SuperClass2 {
	/* constructor #1*/
	public SuperClass2()
	{
		System.out.println("This is a superclass no-arg constructor.");
	}
	/*constructor #2*/
	public SuperClass2(int arg)
	{
		System.out.println("The following argument was passed to the superclass constructor with one arg: "+ arg);
	}
	
}
