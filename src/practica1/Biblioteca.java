package practica1;
/**
 * Clase de Bibilioteca: desarrollamos una bibiloteca con un array de coleccionable 
 * podiendo instanciar cualquier clase que implemente de esta
 * @author Juan Marcos Galindo Mendoza 
 * @version 1.5 24/02/2023 
 */
import java.util.Objects;
public class Biblioteca {
	
	/**
	 * String propietario: indica el nombre del usuario que utilizará la aplicación
	 * Coleccionable[] lista: un array de interfaz Coleccionable siendo este compatible con las clases que implementen de esta
	 */
	private String propietario;
	private static Coleccionable[] lista = new Coleccionable[100];
	
	/**
	 * Constructor sin parámetros
	 */
	public Biblioteca() {
		super();
	}
	
	/**
	 * Constructor atributo de la clase
	 * @param propietario
	 */
	public Biblioteca(String propietario) {
		super();
		this.propietario = propietario;
	}
	
	/**
	 * Métodos getter y setter de cada atributo
	 */
	
	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public Coleccionable[] getLista() {
		return lista;
	}
	
	/**
	 * Método para contabilizar los objetos creados en el array
	 */
	public void elementos() {
		
		/**
		 * Variables para contar las instancias creadas
		 */
		int libros=0;
		int series=0;
		int vidj=0;
		
		/**
		 * Intentamos ejecutar el recorrido del array
		 * Atrapamos la excepción NullPointerException
		 * Finalmente mostramos el contenido de la biblioteca
		 */
		try {
			
			for(int i=0; i<lista.length; i++) {
		
				if(lista[i] instanceof Libro) {
					libros++;
				}
				if(lista[i] instanceof SerieTV) {
					series++;
				}
				if(lista[i] instanceof VideoJuego) {
					vidj++;
				}
			}
			
		} catch (NullPointerException e) {
			
		} finally {
			System.out.println("\n— Biblioteca de " + propietario + " —");
			System.out.println("Libros: " + libros);
			System.out.println("Series de TV: " + series);
			System.out.println("Videojuegos: " + vidj);
			System.out.println();
		}
	}
	
	/**
	 * Método para añadir un coleccionable al array de la clase
	 * @param nuevoObjeto: recibe un objeto de Coleccionable como parámetro para introducirlo
	 */
	static public void añadirColeccionable(Coleccionable nuevoObjeto) {
		
		/**
		 * Boolean encontrado: valor para saber hasta donde se debe recorrer el array 
		 * Creamos un bucle for para recorrer el array
		 * Al encontrar un hueco en el array se almacenará en este el objeto recibido como parámetro, luego salimos del bucle
		 */
		boolean encontrado=false;
		
		for(int i=0; i<lista.length && !encontrado; i++) {
			if(Objects.isNull(lista[i])) {
				lista[i] = nuevoObjeto;
				encontrado=true;
			}
		}
	}
	
	/**
	 * Método para mostrar el contenido de la biblioteca
	 */
	public void contenido() {
		
		/**
		 * Comprobamos si se han creado objetos en el array
		 */
		if(Objects.isNull(lista[0])) {
			
			System.out.println("\nNo hay contenido en la biblioteca\n");
		
		/**
		 * Si se encuentran objetos en el array pasamos a mostrarlos por pantalla
		 */
		} else {
			System.out.println("\n— Contenido de la biblioteca de " + propietario + " —\n");
			
			/**
			 * Intentamos recorrer el array accediendo al método mostrar implementado en las clases correspondientes
			 * Atrapamos la excepción NullPointerException he informamos el final del contenido
			 */
			try {
				for(int i=0; i<lista.length; i++) {				
					
					System.out.println(lista[i].mostrar());
					System.out.println();
				}
			} catch (NullPointerException e) {
				System.out.println("Fin del contenido de la biblioteca\n");
			}
		}		
	}
}