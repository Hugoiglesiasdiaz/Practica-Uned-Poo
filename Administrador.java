
/**
 * Write a description of class Administrador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Administrador extends Trabajador
{
    public Administrador(int id, String nombre, String apellidos, String dni) {
        super(id, nombre, apellidos, dni);
    }

    public Administrador(Trabajador trabajador){
        super(trabajador.getId(), trabajador.getNombre(), trabajador.getApellidos(), trabajador.getDni());
    }
}
