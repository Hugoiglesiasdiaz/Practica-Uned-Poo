/**
 * Clase abstracta que representa una persona con los atributos básicos de identificación.
 * 
 * Esta clase sirve como base para crear tipos específicos de personas, como trabajadores, usuarios, etc.
 * 
 * @author Hugo
 * @version 1.0
 */
public abstract class Persona {
    private int id;
    private String nombre;
    private String apellidos;
    private String dni;

    /**
     * Constructor para crear una nueva persona con sus atributos.
     * 
     * @param id        Identificador único de la persona.
     * @param nombre    Nombre de la persona.
     * @param apellidos Apellidos de la persona.
     * @param dni       Documento Nacional de Identidad de la persona.
     */
    public Persona(int id, String nombre, String apellidos, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    /**
     * Establece el nombre de la persona.
     * 
     * @param nombre Nombre de la persona.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la persona.
     * 
     * @return Nombre de la persona.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Obtiene el DNI de la persona.
     * 
     * @return DNI de la persona.
     */
    public String getDni(){
        return this.dni;
    }

    /**
     * Obtiene el ID de la persona.
     * 
     * @return ID de la persona.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la persona.
     * 
     * @param id Identificador único de la persona.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene los apellidos de la persona.
     * 
     * @return Apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos de la persona.
     * 
     * @param apellidos Apellidos de la persona.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Establece el DNI de la persona.
     * 
     * @param dni Documento Nacional de Identidad de la persona.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
}
