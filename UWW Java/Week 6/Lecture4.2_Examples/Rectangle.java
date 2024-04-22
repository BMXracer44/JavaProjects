
public class Rectangle {


		private double width;
		private double height;

		public Rectangle() {
			width = 1.0; height = 1.0;
		}
		
		public Rectangle(double width, double height)
				{this.width = width; this.height = height;}

		public Rectangle(Rectangle s) { this.width = s.getWidth(); this.height = s.getHeight(); }
		
	    public double getArea() {return width * height;}
	    
	    public double getWidth() {return width; }
	    public double getHeight() {return height; }


}
