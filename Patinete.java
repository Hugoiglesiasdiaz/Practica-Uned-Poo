
/**
 * Write a description of class Patinete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Patinete extends Vehiculo
{
    // instance variables - replace the example below with your own
    private Base baseActual;
    /**
     * Constructor for objects of class Patinete
     */
    public Patinete(int id, String tipo, String estado, Coordenada ubicacion, float bateria, int x, Base baseActual, boolean disponible) {
        super(id, tipo, estado, ubicacion, bateria,disponible);
    
        this.baseActual = baseActual;
    }
    
}
