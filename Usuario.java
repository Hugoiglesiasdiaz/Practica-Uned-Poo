import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario extends Persona   
{
    // instance variables - replace the example below with your own
    private String tipoUsuario;
    private int saldo;
    private List<Viaje> historialViajes =new ArrayList<>();

    /**
     * Constructor for objects of class Usuario
     */
    public Usuario(int id,String nombre,String apellidos,String dni,String tipoUsuario)
    {super(id,nombre,apellidos,dni);
        this.tipoUsuario=tipoUsuario;
    }    
    
    public void mostrarInfo(){
        System.out.println("Nombre:" + getNombre() + " apellidos:" + getApellidos() + " dni:" + getDni() + " TipoUsuario:" + getTipoUsuario());
    }
    
    public void setTipoUsuario(String tipoUsuario){
        this.tipoUsuario=tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public List<Viaje> getHistorialViajes() {
        return historialViajes;
    }

    public void setHistorialViajes(List<Viaje> historialViajes) {
        this.historialViajes = historialViajes;
    }
    
    public void realizarViaje(Viaje viaje){
        getHistorialViajes().add(viaje);
    }
}
