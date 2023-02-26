package practica1;
/**
 * Clase objeto de Libro que implementa la interfaz Coleccionable
 * @author Juan Marcos Galindo Mendoza
 * @version 1.0 22/02/2023
 */
public class Libro implements Coleccionable {
	
	/**
	 * String titulo: el nombre del libro
	 * String autor: el nombre del autor del libro
	 * String editorial: nombre de la editorial del libro
	 * String numPaginas: número de páginas del libro en un string ya que no se modificará este dato
	 */
	private String titulo;
	private String autor;
	private String editorial;
	private String numPaginas;
	
	/**
	 * Constructor sin parámetros de la clase
	 */
	public Libro() {
		super();
	}
	
	/**
	 * Constructor con todos los parámetros de la clase
	 * @param titulo
	 * @param autor
	 * @param editorial
	 * @param numPaginas
	 */
	public Libro(String titulo, String autor, String editorial, String numPaginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.numPaginas = numPaginas;
	}
	
	/**
	 * Métodos getter y setter de cada atributo
	 */
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(String numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	/**
	 * Método mostrar implementado de Coleccionable para visializar los datos del libro
	 * @return String: los datos del libro almacenados en un string
	 */
	@Override
	public String mostrar() {
		return LIBRO+"\n"+titulo+"\n"+autor+"\n"+editorial+"\n"+numPaginas+" páginas";
	}
}