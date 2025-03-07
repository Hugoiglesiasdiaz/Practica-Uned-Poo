public class Trabajador extends Persona implements Comparable<Trabajador>{

    public Trabajador(int id, String nombre, String apellidos, String dni) {
        super(id,nombre,apellidos,dni);
    }

    public void mostrarInfo() {
        System.out.println("ID: " + getId() + ", Nombre: " + getNombre() + " Apellidos:" + getApellidos() + ", DNI: " + getDni() + " " + getClass().getSimpleName());
    }

    @Override
    public int compareTo(Trabajador otro) {
        return Integer.compare(this.getId(), otro.getId());
    }

    public void asignarVehiculo(Vehiculo vehiculo){

    }

    public void asignarBase(Base base){

    }
}

