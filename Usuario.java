import java.util.List;

/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario extends Persona   
{
    // instance variables - replace the example below with your own
    private int x;
    private String tipoUsuario;
    private int saldo;
    private List<Viaje> historialViajes ;

    /**
     * Constructor for objects of class Usuario
     */
    public Usuario()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
