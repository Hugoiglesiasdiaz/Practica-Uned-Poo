
/**
 * Write a description of class Moto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moto extends Vehiculo
{
    // instance variables - replace the example below with your own
    private String cilindrada;
    /**
     * Constructor for objects of class Moto
     */
    public Moto(int id, String tipo, String estado, Coordenada ubicacion, float bateria, String cilindrada,boolean disponible) {
        super(id, tipo, estado, ubicacion, bateria,disponible);
        this.cilindrada = cilindrada;
    }
    
    
    
}
