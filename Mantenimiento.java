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
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Mantenimiento(int id, String nombre, String apellidos, String dni) {
        super(id, nombre, apellidos, dni);
        
    }

    public Mantenimiento(Trabajador trabajador){
        super(trabajador.getId(), trabajador.getNombre(), trabajador.getApellidos(), trabajador.getDni());
    }
    
    @Override
    public void asignarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    
    
}
