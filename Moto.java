/**
 * Representa una moto, que es un tipo específico de vehículo con un atributo adicional: la cilindrada.
 * 
 * La clase extiende de Vehiculo, añadiendo un campo adicional para almacenar la cilindrada de la moto.
 * 
 * @author Hugo
 * @version 1.0
 */
public class Moto extends Vehiculo {
    private String cilindrada;

    /**
     * Constructor para crear una nueva moto con sus atributos.
     * 
     * @param id          Identificador único de la moto.
     * @param tipo        Tipo de vehículo (en este caso, moto).
     * @param estado      Estado del vehículo (por ejemplo, operativo, en mantenimiento).
     * @param ubicacion   Coordenada donde se encuentra la moto.
     * @param bateria     Porcentaje de batería de la moto.
     * @param cilindrada  Cilindrada del motor de la moto.
     * @param disponible  Indica si la moto está disponible para ser usada.
     */
    public Moto(int id, String tipo, String estado, Coordenada ubicacion, float bateria, String cilindrada, boolean disponible) {
        super(id, tipo, estado, ubicacion, bateria, disponible);
        this.cilindrada = cilindrada;
    }
}
