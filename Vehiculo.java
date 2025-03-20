
/**
 * Write a description of class Vehículo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vehiculo
{
    private int id;
    
    private String estado;
    private Coordenada ubicacion;
    private float bateria;
    private String problema;
    private boolean disponible;
    /**
     * Constructor for objects of class Vehículo
     */
    public Vehiculo(int id,String tipo,String estado,Coordenada ubicacion,float bateria,boolean disponible)
    {
        this.id=id;
        this.estado=estado;
        this.ubicacion = ubicacion;
        this.bateria = bateria;
        this.problema="";
        this.disponible = disponible;
    }

    public void consultarBatería(){
        System.out.println("Vehiculo nº" + id + " tipo:" + getClass().getSimpleName() + " batería:" + bateria);
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getBateria() {
        return bateria;
    }

    public void setBateria(float bateria) {
        this.bateria = bateria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return id+  " " +getClass().getSimpleName();
    }

    public Coordenada getUbicacion() {
        return ubicacion;
    }
    
    
}
