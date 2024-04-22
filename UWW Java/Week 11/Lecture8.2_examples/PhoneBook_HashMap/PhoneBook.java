package PhoneBook_HashMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class PhoneBook {
     //Step-1: define a private field which is a HashMap contains 
	 //String array of names as key and String of phone number as value
    private HashMap<String[], String> phoneList2 = new HashMap<>();
	
     //step-2, public method: addPhone   
    public void addPhone(String[] name, String phoneNum) {
      phoneList2.put(name, phoneNum); //add name and phone number as a pair to the HashMap phone list
    }
     
   //step-3:public method: searchPhone, return a HashMap containing the phone info that matched search key
    public HashMap<String[], String> searchPhone(String search){
      HashMap<String[], String> result = new HashMap<>();
      Set<String[]> names =  phoneList2.keySet(); //Return all names in a set
      for(String[] n : names){ //get each name (including first and last name) as a String array from name set
        for(String s : n){ //get first name or last name from n: the name
          if(s.toLowerCase().startsWith(search.toLowerCase())){
            result.put(n, phoneList2.get(n));
          }
        }  
      }

      return result;
	 }
     
     //step-4: public method: print
	public void print(){
		for(HashMap.Entry<String[], String> entry : phoneList2.entrySet()){
      System.out.println(Arrays.toString(entry.getKey()) + ": " + entry.getValue());
    }
	}
  
     
}
