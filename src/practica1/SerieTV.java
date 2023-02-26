package practica1;
/**
 * Clase objeto de Serie TV que implementa la interfaz Coleccionable
 * @author Juan Marcos Galindo Mendoza
 * @version 1.0 22/02/2023
 */
import java.util.Arrays;

public class SerieTV implements Coleccionable {
	
	/**
	 * String nombreSerie: el nombre de la serie de tv
	 * int temporadas: almacena el número de temporadas de la serie correspondiente
	 * int[] capitulosTemporada: array que almacena el número de capitulos de una temporada correspondiente
	 */
	private String nombreSerie;
	private int temporadas;
	private int[] capitulosTemporada= new int[temporadas];
	
	/**
	 * Constructor sin parámetros
	 */
	public SerieTV() {
		super();
	}
	
	/**
	 * Constructor con todos los parámetros de la clase
	 * @param nombreSerie
	 * @param temporadas
	 * @param capitulosTemporada
	 */
	public SerieTV(String nombreSerie, int temporadas, int[] capitulosTemporada) {
		super();
		this.nombreSerie = nombreSerie;
		this.temporadas = temporadas;
		this.capitulosTemporada = capitulosTemporada;
	}

	/**
	 * Métodos getter y setter de cada atributo
	 */
	public String getNombreSerie() {
		return nombreSerie;
	}

	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int[] getCapitulosTemporada() {
		return capitulosTemporada;
	}

	public void setCapitulosTemporada(int[] capitulosTemporada) {
		this.capitulosTemporada = capitulosTemporada;
	}
	
	/**
	 * Método mostrar implementado de Coleccionable para visializar los datos de la Serie de TV
	 * @return String: los dato de la serie almacenados en un string
	 */
	@Override
	public String mostrar() {
		
		return SERIE_TV+"\n"+nombreSerie+"\n"+temporadas+" temporadas\n"+ Arrays.toString(capitulosTemporada) +" capítulos";
	}
}