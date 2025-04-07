/**
 * Clase abstracta que representa un vehículo. Los vehículos tienen un identificador,
 * estado, ubicación, batería, un problema asociado, y disponibilidad.
 * 
 * @author Hugo
 * @version 1.0
 */
public abstract class Vehiculo {
    private int id;
    private String estado;
    private Coordenada ubicacion;
    private float bateria;
    private String problema;
    private boolean disponible;

    /**
     * Constructor para objetos de la clase Vehículo.
     * 
     * @param id          El identificador único del vehículo.
     * @param tipo        El tipo de vehículo (por ejemplo, moto, patinete).
     * @param estado      El estado actual del vehículo.
     * @param ubicacion   La ubicación del vehículo.
     * @param bateria     La cantidad de batería disponible en el vehículo.
     * @param disponible  Indica si el vehículo está disponible para uso.
     */
    public Vehiculo(int id, String tipo, String estado, Coordenada ubicacion, float bateria, boolean disponible) {
        this.id = id;
        this.estado = estado;
        this.ubicacion = ubicacion;
        this.bateria = bateria;
        this.problema = "";
        this.disponible = disponible;
    }

    /**
     * Muestra la cantidad de batería del vehículo.
     */
    public void consultarBatería() {
        System.out.println("Vehiculo nº" + id + " tipo:" + getClass().getSimpleName() + " batería:" + bateria);
    }

    /**
     * Obtiene el problema asociado al vehículo.
     * 
     * @return El problema asociado al vehículo.
     */
    public String getProblema() {
        return problema;
    }

    /**
     * Establece el problema asociado al vehículo.
     * 
     * @param problema El problema a establecer.
     */
    public void setProblema(String problema) {
        this.problema = problema;
    }

    /**
     * Obtiene el identificador del vehículo.
     * 
     * @return El identificador del vehículo.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el estado actual del vehículo.
     * 
     * @return El estado del vehículo.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del vehículo.
     * 
     * @param estado El estado a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la cantidad de batería disponible en el vehículo.
     * 
     * @return La batería disponible.
     */
    public float getBateria() {
        return bateria;
    }

    /**
     * Establece la cantidad de batería disponible en el vehículo.
     * 
     * @param bateria La cantidad de batería a establecer.
     */
    public void setBateria(float bateria) {
        this.bateria = bateria;
    }

    /**
     * Indica si el vehículo está disponible para su uso.
     * 
     * @return true si el vehículo está disponible, false en caso contrario.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece la disponibilidad del vehículo.
     * 
     * @param disponible true para marcarlo como disponible, false en caso contrario.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Devuelve una representación en cadena del vehículo.
     * 
     * @return Una cadena con la ID y el tipo del vehículo.
     */
    @Override
    public String toString() {
        return "ID " + id + " " + getClass().getSimpleName();
    }

    /**
     * Obtiene la ubicación del vehículo.
     * 
     * @return La ubicación del vehículo.
     */
    public Coordenada getUbicacion() {
        return ubicacion;
    }

    /**
     * Añade un nuevo mensaje de problema al vehículo. Si ya existe un problema,
     * el nuevo mensaje se añade con un separador.
     * 
     * @param mensaje El mensaje del nuevo problema.
     */
    public void addProblema(String mensaje) {
        if (this.problema == null || this.problema.trim().isEmpty()) {
            this.problema = mensaje; // Si no hay problema previo, solo asigna el mensaje
        } else {
            this.problema += " | " + mensaje; // Agrega el nuevo mensaje con un separador
        }
    }

    /**
     * Establece la ubicación del vehículo.
     * 
     * @param ubicacion La nueva ubicación del vehículo.
     */
    public void setUbicacion(Coordenada ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Realiza un viaje y actualiza la batería del vehículo en función de la cantidad
     * gastada durante el viaje.
     * 
     * @param bateriaGastada La cantidad de batería gastada durante el viaje.
     */
    public void realizarViaje(int bateriaGastada) {
        this.bateria = bateria - bateriaGastada;
        if (bateria < 0) {
            bateria = 0;
        }
    }
}
