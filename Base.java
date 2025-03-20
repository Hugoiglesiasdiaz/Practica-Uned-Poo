import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Base here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Base {
    List<Vehiculo> vehiculos = new ArrayList();
    private int id;
    private String nombre;
    private Coordenada coordenadas;
    private int capacidad;
    private int ocupacionActual;
    private String problema; // Nuevo atributo para problemas

    public Base(int id, String nombre, Coordenada coordenadas, int capacidad,List<Vehiculo> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.coordenadas = coordenadas;
        this.capacidad = capacidad;
        this.vehiculos=vehiculos;
        this.problema = ""; // Inicialmente sin problemas
    }
    
    
    public Base(int id, String nombre, Coordenada coordenadas, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.coordenadas = coordenadas;
        this.capacidad = capacidad;
    }

    public void addVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }

    public void mostrarEstado(){
        StringBuilder imprimir = new StringBuilder();
        int disponible = capacidad-ocupacionActual; 
        imprimir.append("Base id:" + id + " Nombre:" + nombre + " Cantidad vehículos:" + ocupacionActual + " quedan " + disponible + " huecos ");
        if(problema!=""){
            imprimir.append("Problemas:" + problema);
        }else{
            imprimir.append("No hay problemas");
        }
        System.out.println(imprimir);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getOcupacion(){
        int ocupacion;
        ocupacion=capacidad -vehiculos.size();
        return ocupacion;
    }


    @Override
    public String toString() {
        return "Base [nombre=" + nombre + ", coordenadas=" + coordenadas + "]";
    }


    public Coordenada getCoordenadas() {
        return coordenadas;
    }


    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    
}   
