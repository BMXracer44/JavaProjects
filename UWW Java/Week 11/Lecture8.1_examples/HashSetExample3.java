import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
public class HashSetExample3{

	public static void main(String[] args) {

        //Creating a set using the HashSet class
		//HashSet is an concrete class in Java collections frame work
		//that implements the Set interface
		//It stores the data (unordered) into a hash table
        Set<Integer> footballSet = new HashSet<>();
        Set<Integer> baseballSet = new HashSet<>();
        Set<Integer> basketballSet = new HashSet<>();
        
        // Create a footballSet
        Integer[] playFootball_ids = {2,3,4,5,9,10,15}; //use an array to hold data
        // Use collections.addAll() to add data from an array to a set
        Collections.addAll(footballSet, playFootball_ids);
        System.out.printf("%d students play football: %s\n", footballSet.size(), footballSet);

       // Create a baseballSet
        Integer[] playBaseball_ids = {1,2,3,7,8,10,13}; 
        Collections.addAll(baseballSet, playBaseball_ids);
        System.out.printf("%d students play baseball: %s\n", baseballSet.size(), baseballSet);

        // Create a basketballSet
        Integer[] playBasketball_ids = {1,3,6,11,12,14}; 
        Collections.addAll(basketballSet, playBasketball_ids);
        System.out.printf("%d students play basketball: %s\n", basketballSet.size(), basketballSet);
        
        
        // Union of two sets:
        Set<Integer> union = null;
        ArrayList<Set<Integer>> sets = new ArrayList<Set<Integer>>();
        sets.add(footballSet);
        sets.add(basketballSet);
       
        union = getUnion(sets);
        System.out.printf("%d students who play football and/or play basketball: \n%s\n", union.size(), union);
        
        sets.remove(basketballSet);
        sets.add(baseballSet);
        union = getUnion(sets);
        System.out.printf("%d students who play football and/or play baseball: \n%s\n", union.size(), union);

        sets.remove(footballSet);
        sets.add(basketballSet);
        union = getUnion(sets);
        System.out.printf("%d students who play basketball and/or play baseball: \n%s\n", union.size(), union);
        
        // Union of three sets:
        sets.add(footballSet);
        union = getUnion(sets);
        System.out.printf("%d students who play football, and/or basketball, and/or baseball: \n%s\n", union.size(), union);
        
        // Intersection of two sets:
        Set<Integer> intersection = null;       
        sets = new ArrayList<Set<Integer>>();
        sets.add(footballSet);
        sets.add(basketballSet);
        intersection = getIntersection(sets);
        System.out.printf("%d students who play both football and basketball: \n%s\n", intersection.size(), intersection);
        
        sets.remove(basketballSet);
        sets.add(baseballSet);
        intersection = getIntersection(sets);
        System.out.printf("%d students who play both football and baseball: \n%s\n", intersection.size(), intersection);
       
        sets.remove(footballSet);
        sets.add(basketballSet);
        intersection = getIntersection(sets);
        System.out.printf("%d students who play both basketball and baseball: \n%s\n", intersection.size(), intersection);
        
        sets.add(footballSet);
        intersection = getIntersection(sets);
        System.out.printf("%d students who play all three sports (football, basketball, and baseball): \n%s\n", intersection.size(), intersection);

	}
	
	public static Set<Integer> getUnion(ArrayList<Set<Integer>> sets ){
		int numSets = sets.size();
		if (numSets > 0) {
		   System.out.println("\nThe union of " + numSets + " sets");
		   Set<Integer> union = new HashSet<Integer>();
			for (Set<Integer> data: sets) {
			   union.addAll(data);
			}
			return union;
		}
		else
		   return null;
	}
	
	public static Set<Integer> getIntersection(ArrayList<Set<Integer>>sets){
		int numSets = sets.size();
		if (numSets >0) { 
			System.out.println("\nThe intersection of " + numSets + " sets");
			Set<Integer> intersection = new HashSet<Integer>();
			intersection.addAll(sets.get(0));
	        for (int i=1; i< numSets; i++) {
			   intersection.retainAll(sets.get(i)); //https://docs.oracle.com/javase/8/docs/api/java/util/Set.html#retainAll-java.util.Collection-
			   //Retains only the elements in this set that are contained in the specified collection (optional operation).
	        }
	        
	        return intersection;
		}
		else
			return null;
		
	}
	
	//version-2: use varargs, but not recommended as generic array is not allowed in java 
	/*public static Set<Integer> getIntersection(Set<Integer>... sets){
		int numSets = sets.length; //sets is treated as an array of Set<Integer>
		if (numSets >0) { 
			System.out.println("\nThe intersection of " + numSets + " sets");
			Set<Integer> intersection = new HashSet<Integer>();
			intersection.addAll(sets[0]);
	        for (int i=1; i< numSets; i++) {
			   intersection.retainAll(sets[i]);
	        }
	        
	        return intersection;
		}
		else
			return null;
	}
	*/
}
