import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Mecanico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mecanico extends Trabajador
{
    // instance variables - replace the example below with your own
    private Base base;
    private List<Vehiculo> vehiculos;
    private List<Vehiculo> vehiculosReparados = new ArrayList<>();
    /**
     * Constructor for objects of class Mecanico
     */
    public Mecanico(int id, String nombre, String apellidos, String dni, Base base,
        List<Vehiculo> vehiculos) {
        super(id, nombre, apellidos, dni);
        this.base = base;
        this.vehiculos = vehiculos;
        
    }
    
    

    public Mecanico(int id, String nombre, String apellidos, String dni) {
        super(id, nombre, apellidos, dni);
        this.base = null; // Inicializa en null si no se pasa
        this.vehiculos = new ArrayList<>(); // Inicializa una lista vacía
        this.vehiculosReparados = new ArrayList<>();
    }



    public Mecanico(Trabajador trabajador){
        super(trabajador.getId(), trabajador.getNombre(), trabajador.getApellidos(), trabajador.getDni());
        this.base = null; 
        this.vehiculos = new ArrayList<>(); // Inicializa una lista vacía
    }

    @Override
    public void asignarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    public void asignarBase(Base base){
        this.base = base;
    }



    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }



    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void repararVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }



    public Base getBase() {
        return base;
    }



    public void setBase(Base base) {
        this.base = base;
    }
    
    public void addVehiculoReparado(Vehiculo vehiculo){
        vehiculosReparados.add(vehiculo);
    }



    public List<Vehiculo> getVehiculosReparados() {
        return vehiculosReparados;
    }

    
}
