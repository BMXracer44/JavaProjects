// Program count the frequency of the elements in a list
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapExample1 {
   
	       public static void main(String[] args)
	       {
	           List<String> list = Arrays.asList("B", "A", "A", "C", "B", "A");
	    
	           Map<String, Integer> frequencyMap = new HashMap<>(); 
	           for (String s: list)
	           {
		           Integer count = frequencyMap.get(s);
		           frequencyMap.put(s, (count == null) ? 1 : count + 1);
	           }
	           
	           Set<String> keys = frequencyMap.keySet(); // get keys
	           for (String key : keys) {
	               System.out.printf("%-10s%10s%n", key, frequencyMap.get(key));
	            }
	           
	       }
} 



