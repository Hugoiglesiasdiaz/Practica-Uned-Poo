/**
 * Representa una bicicleta dentro del sistema de gestión de vehículos.
 * Una bicicleta es un tipo de vehículo que puede estar asociada a una base específica.
 * 
 * Hereda de la clase {@code Vehiculo}.
 * 
 * @author (Hugo) 
 * @version (1.0)
 */
public class Bicicleta extends Vehiculo {
    private Base baseActual;

    /**
     * Constructor para crear una nueva bicicleta.
     * 
     * @param id         Identificador único de la bicicleta.
     * @param tipo       Tipo de bicicleta.
     * @param estado     Estado actual de la bicicleta.
     * @param ubicacion  Coordenadas de la ubicación actual de la bicicleta.
     * @param bateria    Nivel de batería de la bicicleta.
     * @param baseActual Base en la que se encuentra la bicicleta.
     * @param disponible Indica si la bicicleta está disponible para uso.
     */
    public Bicicleta(int id, String tipo, String estado, Coordenada ubicacion, float bateria, Base baseActual, boolean disponible) {
        super(id, tipo, estado, ubicacion, bateria, disponible);
        this.baseActual = baseActual;
    }

    /**
     * Obtiene la base actual en la que se encuentra la bicicleta.
     * 
     * @return Base en la que está estacionada la bicicleta.
     */
    public Base getBaseActual() {
        return baseActual;
    }

    /**
     * Establece una nueva base para la bicicleta.
     * 
     * @param baseActual Nueva base donde se encuentra la bicicleta.
     */
    public void setBaseActual(Base baseActual) {
        this.baseActual = baseActual;
    }
}
