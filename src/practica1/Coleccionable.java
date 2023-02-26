package practica1;
/**
 * Interfaz de coleccionable
 * @author Juan Marcos Galindo Mendoza
 * @version 2.0 25/02/2023
 */
public interface Coleccionable {
	
	/**
	 * LIBRO: constante que se implementa clase correspondiente
	 * SERIE_TV: constante que se implementa en la clase correspondiente
	 * VIDEOJUEGO: constante que se implementa en la clase correspondiente
	 */
	public static final String LIBRO="Libro";
	public static final String SERIE_TV="Serie de TV";
	public static final String VIDJUEGO="Videojuego";
	
	/**
	 * Método abstracto que se implementará en las diferentes clases sobrescribiendo el método
	 * @return String: la información correspondiente a la clase donde se implemente el método de esta interfaz
	 */
	public abstract String mostrar();
}
