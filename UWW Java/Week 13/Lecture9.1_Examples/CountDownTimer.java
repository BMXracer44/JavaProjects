

public class CountDownTimer {

	public static void countDown(int countInt) {
		if(countInt <=0) //part-1: base case
			System.out.println("Go!");
		else
		{
			System.out.println(countInt);
			countDown(countInt - 1); //countDown() method with reduced size countInt-1
		}
	}
	
	public static void main(String[] args) {
		countDown(2);

	}

}
