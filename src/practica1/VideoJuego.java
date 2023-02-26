package practica1;
/**
 * Clase objeto de Videojuego que implementa la interfaz Coleccionable
 * @author Juan Marcos Galindo Mendoza
 * @version 1.0 22/02/2023
 */
public class VideoJuego implements Coleccionable  {
	
	/**
	 * String nombreJuego: almacena el titulo del juego
	 * String plataformas: almacena la plataforma del juego
	 */
	private String nombreJuego;
	private String plataformas;
	
	/**
	 * Constructor sin parámetros
	 */
	public VideoJuego() {
		super();
	}
	
	/**
	 * Constructor con todos los parámetros de la clase
	 * @param nombreJuego
	 * @param plataformas
	 */
	public VideoJuego(String nombreJuego, String plataformas) {
		super();
		this.nombreJuego = nombreJuego;
		this.plataformas = plataformas;
	}
	
	/**
	 * Métodos getter y setter de cada atributo
	 */
	
	public String getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	public String getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(String plataformas) {
		this.plataformas = plataformas;
	}
	
	/**
	 * Método mostrar implementado de Coleccionable para visializar los datos del videojuego
	 * @return String: los dato del videojuego almacenados en un string
	 */
	@Override
	public String mostrar() {

		return VIDJUEGO+"\n"+nombreJuego+"\n"+plataformas;
	}	
}