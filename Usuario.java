import java.util.ArrayList;
import java.util.List;

/**
 * Representa un usuario que hereda de la clase Persona. Los usuarios tienen un tipo, saldo,
 * historial de viajes y un contador de viajes realizados.
 * 
 * @author Hugo
 * @version 1.0
 */
public class Usuario extends Persona {
    // Variables de instancia
    private String tipoUsuario;
    private double saldo;
    private List<Viaje> historialViajes = new ArrayList<>();
    private int contadorViajes;

    /**
     * Constructor para crear un usuario con su ID, nombre, apellidos, DNI y tipo de usuario.
     * 
     * @param id          Identificador único del usuario.
     * @param nombre      Nombre del usuario.
     * @param apellidos   Apellidos del usuario.
     * @param dni         Documento Nacional de Identidad del usuario.
     * @param tipoUsuario Tipo de usuario (ej. "normal", "premium").
     */
    public Usuario(int id, String nombre, String apellidos, String dni, String tipoUsuario) {
        super(id, nombre, apellidos, dni);
        this.tipoUsuario = tipoUsuario;
        contadorViajes = 0;
    }

    /**
     * Muestra la información del usuario.
     */
    public void mostrarInfo() {
        System.out.println("Nombre:" + getNombre() + " apellidos:" + getApellidos() + " dni:" + getDni() + " TipoUsuario:" + getTipoUsuario());
    }

    /**
     * Establece el tipo de usuario.
     * 
     * @param tipoUsuario El tipo de usuario a asignar.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Obtiene el tipo de usuario.
     * 
     * @return El tipo de usuario.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Obtiene el saldo actual del usuario.
     * 
     * @return El saldo actual del usuario.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo del usuario.
     * 
     * @param saldo El saldo a establecer.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Aumenta el saldo del usuario en una cantidad determinada.
     * 
     * @param aumento El valor a aumentar al saldo.
     */
    public void aumentarSaldo(double aumento) {
        this.saldo += aumento;
    }

    /**
     * Obtiene el historial de viajes del usuario.
     * 
     * @return El historial de viajes.
     */
    public List<Viaje> getHistorialViajes() {
        return historialViajes;
    }

    /**
     * Establece el historial de viajes del usuario.
     * 
     * @param historialViajes El historial de viajes a asignar.
     */
    public void setHistorialViajes(List<Viaje> historialViajes) {
        this.historialViajes = historialViajes;
    }

    /**
     * Registra un nuevo viaje en el historial del usuario.
     * 
     * @param viaje El viaje que se va a registrar.
     */
    public void realizarViaje(Viaje viaje) {
        getHistorialViajes().add(viaje);
        contadorViajes++;
    }

    /**
     * Devuelve una representación en cadena del usuario.
     * 
     * @return Una cadena con el nombre y apellidos del usuario.
     */
    @Override
    public String toString() {
        return getNombre() + " " + getApellidos();
    }
}
