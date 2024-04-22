import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
public class HashSetExample2 {

	public static void main(String[] args) {

	        List<String> list = Arrays.asList("B", "A", "A", "C", "B", "A");
	 
	        Set<String> distinct = new HashSet<>(list);
	        
	        for (String s: distinct) {
	            System.out.println(s + ": " + Collections.frequency(list, s));
	        }
	}

}
