//CollectionFirstExample.java
//First Example: illustrate how to use interfaces and classes with generic in Java collections framework
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CollectionFirstExample {
   public static void main(String[] args) {
	  List<Double> list = new ArrayList<>();  //Starting from Java 7, new ArrayList<>() is allowed. 
	
      System.out.println("This collection is empty? " + list.isEmpty()); //Check whether the list is empty, without any member or not.
      System.out.println("How many members in this collection? " + list.size()); //size() method to find how many members in the collection
      
      list.add(10.0); //add a double type number 10
      list.add(100.0); //add a double type number 100
      list.add(15.8);  //add a double type number 15.8
      
      //print out the entire collection, which is an ArrayList object in this example
      System.out.println(list);  //By default, the toString() method from java.util.AbstractCollection is called to print out the ArrayList object as an array
      System.out.println("This collection is empty? " + list.isEmpty()); //use isEmpty() method to check whether the list is empty, without any member or not.
      System.out.println("How many members in this collection? " + list.size()); //size() method to find how many members in the collection
      
      //print out individual member in the collection, there are two ways:
      //(1) use iterator() method, which returns an iterator over the elements in this collection. 
      Iterator<Double> i = list.iterator(); //create and return an Iterator<Double> object
      while (i.hasNext()) {  
    	  System.out.println("i=" + i.next()); 
      }
      //(2) use enhanced for loop
      for (Object member: list){ 
    	  System.out.println("member=" + member); 
      }
      
      //call toArray()method defined in ArrayList class
      //use static deepToString() method from Arrays class to convert an Array to Strings
      System.out.println(Arrays.deepToString(list.toArray()) ); 
      
      //No need to do type casting
       double a = list.get(0); 
       System.out.println(a);   
   } 
} 


