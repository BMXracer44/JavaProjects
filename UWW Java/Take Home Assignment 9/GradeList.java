import java.util.*;

public class GradeList {
	public static void main(String[] args) {

		//step-1.1: create a LinkedList object 
		//use a generic List reference variable to reference the LinkedList object
		//call getStudentGrade() method to return student grades as an array and use that grades array to 
		//initialize grades in the LinkedList object

		LinkedList<Integer> linkedlist = new LinkedList<>(); //Initializes linked list

		//Adds all the items to the linked list
		for(int grade : getStudentGrade()){
			linkedlist.add(grade);
		}
		

		//step-1.2: print the student grades in the LinkedList to console
		for(int grade : linkedlist){
			System.out.println(grade);
		}
		

		//step-4: call getTotalGrade() method to get and print total grade to console
		System.out.println("\nSum of all grades: " + getTotalGrade(linkedlist));
		System.out.println("\nAverage of all grades: " + (getTotalGrade(linkedlist) / linkedlist.size()) + "\n");

		

		//step-6: call insertAndRankGrade() method enter a grade and get its rank in the grade list
		System.out.println(insertAndRankGrade(linkedlist));

	} //end of the main method
	
	
	//step-2: define getStudentGrade() method here
	public static int[] getStudentGrade(){
		
		//Creates an array with 25 positions
		int[] grades = new int[25];
		Random rand = new Random();

		//Puts random grades into the array
		for(int i = 0; i < grades.length; i++){
			grades[i] = rand.nextInt(100);
		}

		return grades;

	}

	//step-3: define getTotalGrade() method here
	public static int getTotalGrade(List<Integer> grades){
		int total = 0;
		//Adds all the grades in the list to give me the total 
		for (Integer integer : grades) {
			total = total + integer;
		}

		return total;
	}

	
	//step-5: define insertAndRankGrade() method here
	public static String insertAndRankGrade(List<Integer> grades){ //Possibly clean up this method?
		Scanner input = new Scanner(System.in);
		int number = 0;
		int result = 0;
		//Asks the user for their input
		System.out.print("Enter a number between 0 and 100: ");

		try {
			number = Integer.parseInt(input.nextLine());

			//If number is out of bounds, handles exception correctly so the program works as intended
			if(number < 0 || number > 100){
				throw new IllegalArgumentException();
			}
			else{
				grades.add(number);
				input.close();
			}
			//If number is not an integer, handles exception correctly so the program works as intended
		} catch (NumberFormatException e){
			System.out.println("Invalid number!");
			insertAndRankGrade(grades);	
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid number!");
			insertAndRankGrade(grades);
		} catch(Exception e){
			System.out.println("Invalid number!");
			insertAndRankGrade(grades);
		}

		//Sorts the grades so the Binary Search works properly
		Collections.sort(grades);

		//Searches for the number input and gives a rank
		for(int grade : grades){
			result = Collections.binarySearch(grades, number);
		}

		String endString =  "Inputted grade: " + number + "\nGrade rank: " + (grades.size() - result);

		return endString;
	}
	
}
