import java.time.LocalDate;
import java.util.Date;

/**
 * Write a description of class Viaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Viaje
{
    private int id;
    private Usuario usuario;
    private Vehiculo vehiculo;
    private Coordenada inicio;
    private Coordenada fin;
    private double coste;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    
    /**
     * Constructor for objects of class Viaje
     */
    
    public Viaje(int id, Usuario usuario, Vehiculo vehiculo, Coordenada inicio, Coordenada fin, double coste,LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.inicio = inicio;
        this.fin = fin;
        this.coste = coste;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
    }

    @Override
    public String toString() {
        return "Viaje [id=" + id + ", usuario=" + usuario + ", vehiculo=" + vehiculo + ", inicio=" + inicio + ", fin="
                + fin + ", coste=" + coste + "]";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public Coordenada getInicio() {
        return inicio;
    }
    public void setInicio(Coordenada inicio) {
        this.inicio = inicio;
    }
    public Coordenada getFin() {
        return fin;
    }
    public void setFin(Coordenada fin) {
        this.fin = fin;
    }
    public double getCoste() {
        return coste;
    }
    public void setCoste(float coste) {
        this.coste = coste;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
    
    
}
