import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un trabajador de mantenimiento encargado de reparar vehículos.
 * 
 * Un trabajador de mantenimiento puede tener asignados vehículos para revisión
 * y un historial de vehículos reparados.
 * 
 * @author Hugo
 * @version 1.0
 */
public class Mantenimiento extends Trabajador {
    private List<Vehiculo> vehiculos;
    private List<Vehiculo> vehiculosReparados;

    /**
     * Constructor que inicializa un trabajador de mantenimiento con sus datos personales.
     * 
     * @param id        Identificador único del trabajador.
     * @param nombre    Nombre del trabajador.
     * @param apellidos Apellidos del trabajador.
     * @param dni       Documento de identidad del trabajador.
     */
    public Mantenimiento(int id, String nombre, String apellidos, String dni) {
        super(id, nombre, apellidos, dni);
        vehiculos = new ArrayList<>();
        vehiculosReparados = new ArrayList<>();
    }

    /**
     * Constructor que inicializa un trabajador de mantenimiento a partir de un objeto Trabajador.
     * 
     * @param trabajador Objeto de tipo Trabajador que contiene los datos personales.
     */
    public Mantenimiento(Trabajador trabajador) {
        super(trabajador.getId(), trabajador.getNombre(), trabajador.getApellidos(), trabajador.getDni());
        vehiculos = new ArrayList<>();
        vehiculosReparados = new ArrayList<>();
    }

    /**
     * Asigna un vehículo al trabajador de mantenimiento para su revisión o reparación.
     * 
     * @param vehiculo Vehículo a asignar.
     */
    @Override
    public void asignarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     * Obtiene la lista de vehículos asignados para mantenimiento.
     * 
     * @return Lista de vehículos en mantenimiento.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Marca un vehículo como reparado y lo agrega a la lista de vehículos reparados.
     * 
     * @param vehiculo Vehículo que ha sido reparado.
     */
    public void realizarMantenimiento(Vehiculo vehiculo) {
        vehiculosReparados.add(vehiculo);
    }

    /**
     * Obtiene la lista de vehículos que han sido reparados.
     * 
     * @return Lista de vehículos reparados.
     */
    public List<Vehiculo> getVehiculosReparados() {
        return vehiculosReparados;
    }
}
