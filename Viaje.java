import java.time.LocalDate;

/**
 * Representa un viaje realizado por un usuario utilizando un vehículo, 
 * incluyendo información como las coordenadas de inicio y fin, el coste del viaje 
 * y las fechas de inicio y fin.
 * 
 * @author Hugo
 * @version 1.0
 */
public class Viaje {
    private int id;
    private Usuario usuario;
    private Vehiculo vehiculo;
    private Coordenada inicio;
    private Coordenada fin;
    private double coste;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    /**
     * Constructor para objetos de la clase Viaje.
     * 
     * @param id          El identificador único del viaje.
     * @param usuario     El usuario que realiza el viaje.
     * @param vehiculo    El vehículo utilizado en el viaje.
     * @param inicio      Las coordenadas de inicio del viaje.
     * @param fin         Las coordenadas de fin del viaje.
     * @param coste       El coste del viaje.
     * @param fechaInicio La fecha de inicio del viaje.
     * @param fechaFin    La fecha de fin del viaje.
     */
    public Viaje(int id, Usuario usuario, Vehiculo vehiculo, Coordenada inicio, Coordenada fin, double coste, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.inicio = inicio;
        this.fin = fin;
        this.coste = coste;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Devuelve una representación en cadena del viaje.
     * 
     * @return Una cadena con los detalles del viaje.
     */
    @Override
    public String toString() {
        return "Viaje [id=" + id + ", usuario=" + usuario + ", vehiculo=" + vehiculo + ", inicio=" + inicio + ", fin="
                + fin + ", coste=" + coste + "]";
    }

    /**
     * Obtiene el identificador del viaje.
     * 
     * @return El identificador del viaje.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del viaje.
     * 
     * @param id El identificador del viaje.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el usuario que realizó el viaje.
     * 
     * @return El usuario que realizó el viaje.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realizó el viaje.
     * 
     * @param usuario El usuario que realizó el viaje.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el vehículo utilizado en el viaje.
     * 
     * @return El vehículo utilizado en el viaje.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo utilizado en el viaje.
     * 
     * @param vehiculo El vehículo utilizado en el viaje.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene las coordenadas de inicio del viaje.
     * 
     * @return Las coordenadas de inicio del viaje.
     */
    public Coordenada getInicio() {
        return inicio;
    }

    /**
     * Establece las coordenadas de inicio del viaje.
     * 
     * @param inicio Las coordenadas de inicio del viaje.
     */
    public void setInicio(Coordenada inicio) {
        this.inicio = inicio;
    }

    /**
     * Obtiene las coordenadas de fin del viaje.
     * 
     * @return Las coordenadas de fin del viaje.
     */
    public Coordenada getFin() {
        return fin;
    }

    /**
     * Establece las coordenadas de fin del viaje.
     * 
     * @param fin Las coordenadas de fin del viaje.
     */
    public void setFin(Coordenada fin) {
        this.fin = fin;
    }

    /**
     * Obtiene el coste del viaje.
     * 
     * @return El coste del viaje.
     */
    public double getCoste() {
        return coste;
    }

    /**
     * Establece el coste del viaje.
     * 
     * @param coste El coste del viaje.
     */
    public void setCoste(float coste) {
        this.coste = coste;
    }

    /**
     * Obtiene la fecha de inicio del viaje.
     * 
     * @return La fecha de inicio del viaje.
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Obtiene la fecha de fin del viaje.
     * 
     * @return La fecha de fin del viaje.
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }
}
