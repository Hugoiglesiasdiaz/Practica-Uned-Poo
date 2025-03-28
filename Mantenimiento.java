import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Mantenimiento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mantenimiento extends Trabajador
{
    private List<Vehiculo> vehiculos;
    private List<Vehiculo> vehiculosReparados;

    public Mantenimiento(int id, String nombre, String apellidos, String dni) {
        super(id, nombre, apellidos, dni);
        vehiculos=new ArrayList<>();
        vehiculosReparados=new ArrayList<>();
    }

    public Mantenimiento(Trabajador trabajador){
        super(trabajador.getId(), trabajador.getNombre(), trabajador.getApellidos(), trabajador.getDni());
        vehiculos=new ArrayList<>();
        vehiculosReparados=new ArrayList<>();
    }
    
    @Override
    public void asignarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public void realizarMantenimiento(Vehiculo vehiculo){
        vehiculosReparados.add(vehiculo);
    }

    public List<Vehiculo> getVehiculosReparados() {
        return vehiculosReparados;
    }

    
}
