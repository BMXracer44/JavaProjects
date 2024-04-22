package ComparableExample;
//Java program to sort student
//data according to their marks

import java.util.*;

//Base class implements the Comparable interface 
class StudentData implements Comparable<StudentData> {

	String name;
	int marks;

	// Constructor
	StudentData(String name, int marks)
	{
		this.name = name;
		this.marks = marks;
	}

	// overriding method to sort
	// the student data
	public int compareTo(StudentData sd) //define the natural order for sorting StudentData
	{
		return this.marks - sd.marks;
	}
}

//Driver class
public class ComparableDemo {
	public static void main(String[] args)
	{

		ArrayList<StudentData> list
			= new ArrayList<StudentData>();

		// Inserting data
		list.add(new StudentData("Ram", 98));
		list.add(new StudentData("Shyam", 84));
		list.add(new StudentData("Lokesh", 90));

		Collections.sort(list); //the objects in ArrayList implements the comparable interface
		//list.sort(null);
        //so we can sort the objects in the list
		// Displaying data
		for (StudentData sd : list)
			System.out.println(sd.name + " " + sd.marks);
	}
}

