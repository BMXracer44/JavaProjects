import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortMapDemo {

	public static void main(String[] args) {
		Map<String, String> unsortedMap = new HashMap<>();
		
		unsortedMap.put("key_b", "banana");
		unsortedMap.put("key_a", "apple");
		unsortedMap.put("key_c", "orange");
		unsortedMap.put("key_e", "strawberry"); 
		unsortedMap.put("key_d", "blueberry");
		unsortedMap.put("key_f", "plum"); 
		
		System.out.println("unsorted map: " + unsortedMap);
		
		//Method-1: Convert HashMap to a TreeMap, which automatically sort a HashMap by its keys
		//Requires the keys implement Comparable interface
		//here the keys are String variables, String implements Comparable interface and compareTo() method
		//https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html#compareTo(java.lang.String)
		Map<String, String> sortedMap = new TreeMap<>();
		sortedMap.putAll(unsortedMap); //sort data in unsortedMap by the keys
		System.out.println("sorted map: " + sortedMap);
		
         
        //Method-2: Convert Map to a List of Entries and then use Collections.sort() method
		Map<String[], String> unsortedPhoneMap = new HashMap<>();
		unsortedPhoneMap.put(new String[] {"Cao", "Tina"}, 		"6087123456");
		unsortedPhoneMap.put(new String[] {"Smith", "Pei"}, 	"6086712345");
		unsortedPhoneMap.put(new String[] {"Smith", "Morgan"}, 	"6089331421"); 
		unsortedPhoneMap.put(new String[] {"Smith", "William"}, "5191234567");
		unsortedPhoneMap.put(new String[] {"Java", "Program"}, 	"9207994561");
		unsortedPhoneMap.put(new String[] {"James", "Jean"}, 	"9204321560");
		unsortedPhoneMap.put(new String[] {"Harison", "Rose"}, 	"9207994561");
		unsortedPhoneMap.put(new String[] {"Andson", "Janne"}, 	"5195589083");
		for (String[] key: unsortedPhoneMap.keySet()) {
			System.out.println("\nunsorted phone map: " + Arrays.toString(key) + 
					": " + unsortedPhoneMap.get(key));
		}
		
		
		//version-1: sort keys alone, and then use sorted keys to find values
		List<String[]> phoneNames = new ArrayList<>(unsortedPhoneMap.keySet());
        Collections.sort(phoneNames, (a,b) -> (a[0]+a[1]).compareTo(b[0]+b[1])); //compare Strings to sort names in ascending order
        //Collections.sort(phoneNames, (a,b) -> Arrays.compare(b, a)); //use Arrays.compare() method to sort names in descending order
        
        System.out.println("\nsorted phone map (version-1): ");
        for (String[] s: phoneNames) {
        	System.out.println(Arrays.toString(s) + ": " +unsortedPhoneMap.get(s));
        }
        
        //version-2: get Map entries, and then create a list to hold all Map entries.
        //can sort by keys or by values
		List<Entry<String[], String>> phoneEntries = new ArrayList<>(unsortedPhoneMap.entrySet());
		Collections.sort(phoneEntries, new Comparator<Entry<String[], String>>(){	
        	@Override
        	public int compare(Entry<String[], String> e1, Entry<String[], String> e2) {
        		return (e1.getKey()[0]+e1.getKey()[1]).compareTo(e2.getKey()[0]+e2.getKey()[1]); //sort by the keys (last_name + first_name)
        		//return (e1.getKey()[1]+e1.getKey()[0]).compareTo(e2.getKey()[1]+e2.getKey()[0]); //sort by the keys (first_name + last_name)
        		//return e1.getValue().compareTo(e2.getValue()); //sort by the values (phone numbers)   	
        		} 
        	}
			/*	(e1, e2)-> (e1.getKey()[0]+e1.getKey()[1]).compareTo(e2.getKey()[0]+e2.getKey()[1])
		
			 */
        );
		System.out.println("\nsorted phone map (version-2): ");
        for (Entry<String[], String> e: phoneEntries) {
        	System.out.println(Arrays.toString(e.getKey()) + ": " + e.getValue());
        }
       
	}
}


