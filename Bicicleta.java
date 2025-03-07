
/**
 * Write a description of class Bicicleta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bicicleta extends Vehiculo
{
    private Base baseActual;
    /**
     * Constructor for objects of class Bicicleta
     */
    public Bicicleta(int id, String tipo, String estado, Coordenada ubicacion, float bateria, Base baseActual) {
        super(id, tipo, estado, ubicacion, bateria);
        this.baseActual = baseActual;
    }
    
}
