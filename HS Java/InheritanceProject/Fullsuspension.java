package InheritanceProject;

public class Fullsuspension extends Mountainbike{
    private int amtOfTravel;
    private boolean lockout;

    public Fullsuspension(String name, double price, int amtOfTravel, boolean lockout) {
        super(name, price);
        this.amtOfTravel = amtOfTravel;
        lockout = true;
    }
}
