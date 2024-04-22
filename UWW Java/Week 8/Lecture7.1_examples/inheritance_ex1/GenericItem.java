package inheritance_ex1;

public class GenericItem {
		   private String itemName;
		   private int itemQuantity;

		   public void setName(String newName) {
		      itemName = newName;
		   }

		   public void setQuantity(int newQty) {
		      itemQuantity = newQty;
		   }

		   //add public interface for supclass to access private member itemName
		   public String getName(){
			return itemName;
		   }

		   //add public interface for supclass to access private member itemQuantity
		   /*protected*/ public int getQuantity(){
			return itemQuantity;
		   }
		   
		   public void printItem() {
		      System.out.println(itemName + " " + itemQuantity);
		   }

}
