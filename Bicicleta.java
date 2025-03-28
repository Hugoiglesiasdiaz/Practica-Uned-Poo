
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
    public Bicicleta(int id, String tipo, String estado, Coordenada ubicacion, float bateria, Base baseActual,boolean disponible) {
        super(id, tipo, estado, ubicacion, bateria,disponible);
        this.baseActual = baseActual;
    }
    public Base getBaseActual() {
        return baseActual;
    }
    public void setBaseActual(Base baseActual) {
        this.baseActual = baseActual;
    }
    
    
}
