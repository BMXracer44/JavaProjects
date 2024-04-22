
public class RectangleTest {

	public static void main(String[] args) {
		 
		Rectangle kitchen = new Rectangle();
		Rectangle livingroom = new Rectangle(5.0, 10.0);
		Rectangle studyRoom = new Rectangle(livingroom);

		System.out.println("Kitchen size: " + kitchen.getArea());
		System.out.println("Living Room size: " + livingroom.getArea());
		System.out.println("study Room size: " + studyRoom.getArea());
	}

}
