package Takehome_A6;

import java.util.ArrayList;
import java.util.*;

public class PhoneBook {
     //define a private field which is an ArrayList of ResidentPhone objects
	private static ArrayList <ResidentPhone> phoneList = new ArrayList<>();


     //public method: addPhone
     public void addPhone(String firstName, String lastName, String number){
          phoneList.add(new ResidentPhone(firstName, lastName, number));
     }
     
     //public method: searchPhone
     //Return arraylist of resident phone objects
     public List <ResidentPhone> searchPhone(String key){
          ArrayList <ResidentPhone> returnList = new ArrayList<>();
          for(ResidentPhone phone : phoneList){
               if(phone.getFirstName().contains(key) || phone.getLastName().contains(key) || phone.getPhoneNumber().contains(key)){
                    returnList.add(phone);
               }
          }
          return returnList;
     }
     
     
     //public method: print
     public void print(){
          for(ResidentPhone phone : phoneList){
               System.out.println(phone.getLastName() + ", " + phone.getFirstName() + ", " + phone.getPhoneNumber());
          }
     }
     
}
