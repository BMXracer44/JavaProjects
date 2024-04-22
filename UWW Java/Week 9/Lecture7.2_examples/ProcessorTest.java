
import java.util.Arrays;

public class ProcessorTest {

	public static void main(String[] args) {
		Processor p1 = new Processor();
		p1.process(1, 3);
		p1.process(new int[] {10, 11, 12});
		p1.process(new Object[] {20, "test", 30});
		
        Mathprocessor p2 = new Mathprocessor();
    	p2.process(1, 3);
		p2.process(new int[] {10, 11, 12});
		p2.process(new Object[] {20, "test", 30});
	}

}

class Processor {
	//process function: version-1
	public void process(int i, int j) {
		System.out.printf("Processing two integers: %d, %d", i, j);
	}
	
	//process function: version-2
	public void process(int[] ints) {
		System.out.printf("\nProcessing integer array: " + Arrays.toString(ints));

	}
	
	//process function: version-3
	public void process(Object[] Ints) {
		System.out.printf("\nProcessing Object array: " + Arrays.toString(Ints));
	}
}

class Mathprocessor extends Processor{
	
	@Override
	public void process(int i, int j) { //version-1
		System.out.printf("\n=>Add two integers: %d + %d = %d ", i, j, i+j);
	}
	
	@Override
	public void process(int[] ints) { //version-2
		System.out.printf("\n=>Add integers from an array: " + Arrays.toString(ints));
		int sum = 0;
		for (int data: ints)   { sum += data;}
		System.out.printf("\n=>sum = %d", sum);
	}
	
	@Override
	public void process(Object[] Ints) { //version-3
		System.out.printf("\n=>Add Integer data from an Object array: " + Arrays.toString(Ints));
		int sum = 0;
		for (Object data: Ints)   { 
			//version-1
			try {
				sum += (Integer) data; 
				//when type casting Object class's object instance to object instance of the other class type
				//ClassCastException may thrown if the Object's object instance can not be type casted to the other class type 
			}
			catch(ClassCastException e) {
			    System.out.println("\n***find an non-integer data, ignore it!");
			}
			
			//version-2
			/*if (data instanceof Integer) 
				sum += (Integer) data; 
			else
				System.out.println("\n***find an non-integer data, ignore it!");	
			*/
		}
		System.out.printf("=>Add all integers together: %d", sum);
	}
}

