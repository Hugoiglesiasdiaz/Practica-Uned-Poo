import java.util.ArrayList;
import java.util.List;

/**
 * Representa una base donde se almacenan vehículos.
 * Cada base tiene un identificador, nombre, ubicación geográfica (coordenadas), 
 * una capacidad máxima de vehículos y una lista de vehículos asociados.
 * También permite el seguimiento de problemas y el número de usos.
 * 
 * @author (Hugo) 
 * @version (1.0)
 */
public class Base {
    private List<Vehiculo> vehiculos;
    private int id;
    private String nombre;
    private Coordenada coordenadas;
    private int capacidad;
    private int ocupacionActual;
    private String problema; // Nuevo atributo para problemas
    private int usos;

    /**
     * Constructor de la clase Base.
     * 
     * @param id          Identificador único de la base.
     * @param nombre      Nombre de la base.
     * @param coordenadas Coordenadas geográficas de la base.
     * @param capacidad   Capacidad máxima de vehículos en la base.
     * @param vehiculos   Lista de vehículos que inicialmente tiene la base.
     */
    public Base(int id, String nombre, Coordenada coordenadas, int capacidad, List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.coordenadas = coordenadas;
        this.capacidad = capacidad;
        this.vehiculos = vehiculos;
        this.problema = ""; // Inicialmente sin problemas
        this.usos = 0;
    }

    /**
     * Constructor de la clase Base sin lista de vehículos inicial.
     * 
     * @param id          Identificador único de la base.
     * @param nombre      Nombre de la base.
     * @param coordenadas Coordenadas geográficas de la base.
     * @param capacidad   Capacidad máxima de vehículos en la base.
     */
    public Base(int id, String nombre, Coordenada coordenadas, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.coordenadas = coordenadas;
        this.capacidad = capacidad;
        this.vehiculos = new ArrayList<>();
        this.problema="";
        this.usos = 0;
    }

    /**
     * Agrega un vehículo a la base.
     * 
     * @param vehiculo Vehículo a agregar.
     */
    public void addVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     * Muestra el estado actual de la base, incluyendo su capacidad, ocupación y problemas.
     */
    public void mostrarEstado() {
        ocupacionActual=vehiculos.size();
        StringBuilder imprimir = new StringBuilder();
        int disponible = capacidad - ocupacionActual;
        imprimir.append("Base ID: ").append(id)
                .append(" Nombre: ").append(nombre)
                .append(" Cantidad de vehículos: ").append(ocupacionActual)
                .append(" Quedan ").append(disponible).append(" huecos ");

        if (!problema.isEmpty()) {
            imprimir.append("Problemas: ").append(problema);
        } else {
            imprimir.append("No hay problemas.");
        }
        System.out.println(imprimir);
    }

    /**
     * Obtiene el nombre de la base.
     * 
     * @return Nombre de la base.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la base.
     * 
     * @param nombre Nuevo nombre de la base.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Calcula y devuelve la ocupación actual de la base.
     * 
     * @return Número de espacios ocupados en la base.
     */
    public int getOcupacion() {
        return capacidad - vehiculos.size();
    }

    /**
     * Representación en cadena de la base.
     * 
     * @return Cadena que representa la base con su nombre y coordenadas.
     */
    @Override
    public String toString() {
        return "Base [nombre=" + nombre + ", coordenadas=" + coordenadas + "]";
    }

    /**
     * Obtiene las coordenadas de la base.
     * 
     * @return Coordenadas de la base.
     */
    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    /**
     * Establece nuevas coordenadas para la base.
     * 
     * @param coordenadas Nuevas coordenadas de la base.
     */
    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }

    /**
     * Obtiene el identificador de la base.
     * 
     * @return ID de la base.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece un nuevo identificador para la base.
     * 
     * @param id Nuevo ID de la base.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Aumenta el contador de usos de la base.
     */
    public void aumentarUsos() {
        this.usos++;
    }

    /**
     * Obtiene la cantidad de usos de la base.
     * 
     * @return Número de veces que se ha utilizado la base.
     */
    public int getUsos() {
        return usos;
    }
}
