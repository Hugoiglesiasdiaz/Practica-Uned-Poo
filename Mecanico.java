import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un mecánico encargado del mantenimiento y reparación de vehículos.
 * 
 * Un mecánico puede estar asignado a una base y manejar una lista de vehículos 
 * que necesita reparar, además de un historial de vehículos reparados.
 * 
 * @author Hugo
 * @version 1.0
 */
public class Mecanico extends Trabajador {
    private Base base;
    private List<Vehiculo> vehiculos;
    private List<Vehiculo> vehiculosReparados;

    /**
     * Constructor que inicializa un mecánico con su base y lista de vehículos asignados.
     * 
     * @param id        Identificador único del mecánico.
     * @param nombre    Nombre del mecánico.
     * @param apellidos Apellidos del mecánico.
     * @param dni       Documento de identidad del mecánico.
     * @param base      Base a la que está asignado el mecánico.
     * @param vehiculos Lista de vehículos asignados para su mantenimiento.
     */
    public Mecanico(int id, String nombre, String apellidos, String dni, Base base, List<Vehiculo> vehiculos) {
        super(id, nombre, apellidos, dni);
        this.base = base;
        this.vehiculos = vehiculos;
        this.vehiculosReparados = new ArrayList<>();
    }

    /**
     * Constructor que inicializa un mecánico sin una base específica y sin vehículos asignados.
     * 
     * @param id        Identificador único del mecánico.
     * @param nombre    Nombre del mecánico.
     * @param apellidos Apellidos del mecánico.
     * @param dni       Documento de identidad del mecánico.
     */
    public Mecanico(int id, String nombre, String apellidos, String dni) {
        super(id, nombre, apellidos, dni);
        this.base = null; // Inicializa en null si no se pasa
        this.vehiculos = new ArrayList<>();
        this.vehiculosReparados = new ArrayList<>();
    }

    /**
     * Constructor que inicializa un mecánico a partir de un objeto Trabajador.
     * 
     * @param trabajador Objeto de tipo Trabajador con los datos personales.
     */
    public Mecanico(Trabajador trabajador) {
        super(trabajador.getId(), trabajador.getNombre(), trabajador.getApellidos(), trabajador.getDni());
        this.base = null;
        this.vehiculos = new ArrayList<>();
        this.vehiculosReparados = new ArrayList<>();
    }

    /**
     * Asigna un vehículo al mecánico para su reparación.
     * 
     * @param vehiculo Vehículo a asignar.
     */
    @Override
    public void asignarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     * Asigna una base al mecánico.
     * 
     * @param base Base a la que se asignará el mecánico.
     */
    public void asignarBase(Base base) {
        this.base = base;
    }

    /**
     * Obtiene la lista de vehículos que tiene asignados el mecánico.
     * 
     * @return Lista de vehículos asignados.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece una nueva lista de vehículos asignados.
     * 
     * @param vehiculos Lista de vehículos a asignar.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Marca un vehículo como reparado, eliminándolo de la lista de vehículos asignados.
     * 
     * @param vehiculo Vehículo reparado.
     */
    public void repararVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

    /**
     * Obtiene la base a la que está asignado el mecánico.
     * 
     * @return Base del mecánico.
     */
    public Base getBase() {
        return base;
    }

    /**
     * Establece una nueva base para el mecánico.
     * 
     * @param base Nueva base a asignar.
     */
    public void setBase(Base base) {
        this.base = base;
    }

    /**
     * Agrega un vehículo al historial de vehículos reparados.
     * 
     * @param vehiculo Vehículo que ha sido reparado.
     */
    public void addVehiculoReparado(Vehiculo vehiculo) {
        vehiculosReparados.add(vehiculo);
    }

    /**
     * Obtiene la lista de vehículos reparados por el mecánico.
     * 
     * @return Lista de vehículos reparados.
     */
    public List<Vehiculo> getVehiculosReparados() {
        return vehiculosReparados;
    }
}
