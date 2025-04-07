/**
 * Representa un trabajador, que es una persona con capacidades adicionales relacionadas
 * con su trabajo. Implementa la interfaz Comparable para comparar trabajadores por su ID.
 * 
 * @author Hugo
 * @version 1.0
 */
public class Trabajador extends Persona implements Comparable<Trabajador> {

    /**
     * Constructor para crear un trabajador con su ID, nombre, apellidos y DNI.
     * 
     * @param id        Identificador único del trabajador.
     * @param nombre    Nombre del trabajador.
     * @param apellidos Apellidos del trabajador.
     * @param dni       Documento Nacional de Identidad del trabajador.
     */
    public Trabajador(int id, String nombre, String apellidos, String dni) {
        super(id, nombre, apellidos, dni);
    }

    /**
     * Muestra la información del trabajador.
     */
    public void mostrarInfo() {
        System.out.println("ID: " + getId() + ", Nombre: " + getNombre() + " Apellidos:" + getApellidos() + ", DNI: " + getDni() + " " + getClass().getSimpleName());
    }

    /**
     * Compara dos trabajadores por su ID.
     * 
     * @param otro Otro trabajador con el que se compara.
     * @return Un valor negativo si el ID de este trabajador es menor, 0 si son iguales, 
     *         y un valor positivo si el ID de este trabajador es mayor.
     */
    @Override
    public int compareTo(Trabajador otro) {
        return Integer.compare(this.getId(), otro.getId());
    }

    /**
     * Asigna un vehículo al trabajador. Este método está vacío en esta clase base.
     * 
     * @param vehiculo El vehículo a asignar.
     */
    public void asignarVehiculo(Vehiculo vehiculo) {
        // Implementación vacía
    }

    /**
     * Asigna una base al trabajador. Este método está vacío en esta clase base.
     * 
     * @param base La base a asignar.
     */
    public void asignarBase(Base base) {
        // Implementación vacía
    }
}
