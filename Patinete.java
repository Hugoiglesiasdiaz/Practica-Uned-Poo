/**
 * Representa un patinete, que es un tipo específico de vehículo con un atributo adicional: la base donde se encuentra.
 * 
 * La clase extiende de Vehiculo, añadiendo un campo adicional para almacenar la base donde se encuentra el patinete.
 * 
 * @author Hugo
 * @version 1.0
 */
public class Patinete extends Vehiculo {
    private Base baseActual;

    /**
     * Constructor para crear un nuevo patinete con sus atributos.
     * 
     * @param id          Identificador único del patinete.
     * @param tipo        Tipo de vehículo (en este caso, patinete).
     * @param estado      Estado del vehículo (por ejemplo, operativo, en mantenimiento).
     * @param ubicacion   Coordenada donde se encuentra el patinete.
     * @param bateria     Porcentaje de batería del patinete.
     * @param x           Valor adicional asociado a la ubicación o alguna otra característica del patinete.
     * @param baseActual  Base donde se encuentra el patinete.
     * @param disponible  Indica si el patinete está disponible para ser usado.
     */
    public Patinete(int id, String tipo, String estado, Coordenada ubicacion, float bateria, int x, Base baseActual, boolean disponible) {
        super(id, tipo, estado, ubicacion, bateria, disponible);
        this.baseActual = baseActual;
    }

    /**
     * Obtiene la base actual donde se encuentra el patinete.
     * 
     * @return Base actual del patinete.
     */
    public Base getBaseActual() {
        return baseActual;
    }

    /**
     * Establece la base actual donde se encuentra el patinete.
     * 
     * @param baseActual Base donde se va a asignar el patinete.
     */
    public void setBaseActual(Base baseActual) {
        this.baseActual = baseActual;
    }
}
