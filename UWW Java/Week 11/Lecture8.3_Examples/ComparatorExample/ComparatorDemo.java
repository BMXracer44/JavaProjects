package ComparatorExample;
import java.util.*;

public class ComparatorDemo {

	 public static void main(String args[]){  
	  
	ArrayList<Student> al=new ArrayList<Student>();  
	al.add(new Student(101,"Vijay",23));  
	al.add(new Student(106,"Ajay",27));  
	al.add(new Student(105,"Jai",21));  
	  
	System.out.println("Sorting by Name");  
	  
	Collections.sort(al,new NameComparator()); 
	al.sort(new NameComparator());
	for(Student st: al){  
		System.out.println(st.rollno+" "+st.name+" "+st.age);  
	}  
  
	System.out.println("Sorting by age");   
	Collections.sort(al,new AgeComparator());  
	for(Student st: al){  
		System.out.println(st.rollno+" "+st.name+" "+st.age);  
	}  
	
	System.out.println("Sorting by roll number"); 
	Collections.sort(al,new RollNumComparator());  
	for(Student st: al){  
		System.out.println(st.rollno+" "+st.name+" "+st.age);  
	}  
	
	 }  
} 

class Student
{  
	int rollno;  //package access
	String name;   //package access
	int age; 
	
	Student(int rollno,String name,int age){  
		this.rollno=rollno;  
		this.name=name;  
		this.age=age;  
	} 
	
	
}  

//create separate class to implement Comparator interface
class AgeComparator implements Comparator<Student>
{  
	public int compare(Student s1,Student s2){  
		if(s1.age==s2.age)  
			return 0;  
		else if(s1.age>s2.age)  
			return 1;  
		else  
			return -1;  
	}  
}  

class NameComparator implements Comparator<Student>
{  
	public int compare(Student s1,Student s2){  
	return s1.name.compareTo(s2.name);  
	}  
}  

class RollNumComparator implements Comparator<Student>
{
	public int compare(Student s1,Student s2){  
		if(s1.rollno==s2.rollno)  
			return 0;  
		else if(s1.rollno>s2.rollno)  
			return 1;  
		else  
			return -1;    
		} 
}
