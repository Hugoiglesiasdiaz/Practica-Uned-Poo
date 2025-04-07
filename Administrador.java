/**
 * Representa a un Administrador, que es un tipo de Trabajador con permisos adicionales.
 * Extiende la clase {@code Trabajador}.
 * 
 * @author (Hugo) 
 * @version (1.0)
 */
public class Administrador extends Trabajador {

    /**
     * Constructor de la clase Administrador.
     * 
     * @param id        Identificador único del administrador.
     * @param nombre    Nombre del administrador.
     * @param apellidos Apellidos del administrador.
     * @param dni       Documento Nacional de Identidad del administrador.
     */
    public Administrador(int id, String nombre, String apellidos, String dni) {
        super(id, nombre, apellidos, dni);
    }

    /**
     * Constructor que crea un Administrador a partir de un objeto {@code Trabajador}.
     * 
     * @param trabajador Objeto de tipo Trabajador del cual se extraen los datos.
     */
    public Administrador(Trabajador trabajador) {
        super(trabajador.getId(), trabajador.getNombre(), trabajador.getApellidos(), trabajador.getDni());
    }
}
