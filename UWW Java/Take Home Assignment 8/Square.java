public class Square extends Rectangle{
    
    //constructor to create a square
    public Square(double sideLength){
        super(sideLength, sideLength);
    }

    //Overrides the getName method from the Rectangle class
    //So the name of the square is square
    @Override
    public String getName(){
        return "Square";
    }
}