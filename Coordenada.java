
/**
 * Write a description of class Coordenada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coordenada
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    /**
     * Constructor for objects of class Coordenada
     */
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "Coordenada [x=" + x + ", y=" + y + "]";
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }

    
    
}
