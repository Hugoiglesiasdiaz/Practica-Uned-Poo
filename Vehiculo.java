
/**
 * Write a description of class Vehículo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Vehiculo
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
        return "ID "+id+  " " +getClass().getSimpleName();
    }

    public Coordenada getUbicacion() {
        return ubicacion;
    }
    
    public void addProblema(String mensaje) {
        if (this.problema == null || this.problema.trim().isEmpty()) {
            this.problema = mensaje; // Si no hay problema previo, solo asigna el mensaje
        } else {
            this.problema += " | " + mensaje; // Agrega el nuevo mensaje con un separador
        }
    }

    public void setUbicacion(Coordenada ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public void realizarViaje(int bateriaGastada){
        this.bateria = bateria-bateriaGastada;
        if(bateria<0){
            bateria=0;
        }
    }
}
