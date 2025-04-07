/**
 * Representa una coordenada en un sistema bidimensional.
 * 
 * Esta clase almacena las coordenadas X e Y y permite manipularlas.
 * 
 * @author (Hugo) 
 * @version (1.0)
 */
public class Coordenada {
    private double x;
    private double y;

    /**
     * Constructor que inicializa una coordenada con valores específicos.
     * 
     * @param x Valor de la coordenada en el eje X.
     * @param y Valor de la coordenada en el eje Y.
     */
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Devuelve la representación en cadena de la coordenada.
     * 
     * @return Una cadena con el formato "Coordenada [x=valor, y=valor]".
     */
    @Override
    public String toString() {
        return "Coordenada [x=" + x + ", y=" + y + "]";
    }

    /**
     * Obtiene el valor de la coordenada en el eje X.
     * 
     * @return Valor de X.
     */
    public double getX() {
        return x;
    }

    /**
     * Establece un nuevo valor para la coordenada en el eje X.
     * 
     * @param x Nuevo valor de X.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Obtiene el valor de la coordenada en el eje Y.
     * 
     * @return Valor de Y.
     */
    public double getY() {
        return y;
    }

    /**
     * Establece un nuevo valor para la coordenada en el eje Y.
     * 
     * @param y Nuevo valor de Y.
     */
    public void setY(double y) {
        this.y = y;
    }
}
