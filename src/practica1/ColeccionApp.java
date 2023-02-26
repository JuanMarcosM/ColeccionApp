package practica1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Main donde utilizamos los métodos de la clase biblioteca
 * @author Juan Marcos Galindo Mendoza
 * @version 2.5 25/02/2023
 */
public class ColeccionApp {
	
	/**
	 * Creamos un objeto estático del escaner para utilizarlo a lo largo de la clase y los métodos
	 * Array que contiene las plataformas de videojuego compatibles con la biblioteca
	 */
	static Scanner sc = new Scanner(System.in);
	static String[] plataformas = {"PC", "Playstation", "XBOX", "Switch", "Mobile", "Other"};
	
	/**
	 * Método main donde ocurre el programa principal e invocamos los métodos creados
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * int comando: la solucitud de ejecución del usuario
		 * Instanciamos un objeto la clase biblioteca
		 */
		int comando=0;
		Biblioteca biblio = new Biblioteca();
		
		System.out.println("— APP COLECCIONABLE —");
		System.out.println("Dime tu nombre:");
		/**
		 * Utilizamos el método set para establecer el propietario de la biblioteca
		 */
		biblio.setPropietario(sc.nextLine());
		
		/**
		 * Creamos un bucle do-while para ejecutar el programa hasta que el usuario decida salir
		 */
		do {
			
			/**
			 * Mostramos el menú principal con el método correspondiente
			 */
			menu();
			
			/**
			 * Intentamos leer el comando introducido por el usuario y ejecutar los métodos correspondientes
			 * Invocamos los métodos correspondientes en una estructura switch
			 * Atrapamos la excepción InputMismatchException en caso de que el usuario introduzca un valor no valido en int
			 * 
			 */
			try {
				comando = sc.nextInt();
				switch(comando) {
				case 1:
					altaLibro();
					break;
				case 2:
					altaSerie();
					break;
				case 3:
					altaVideojuego();
					break;
				case 4:
					biblio.elementos();
					break;
				case 5:
					biblio.contenido();
					break;
				case 6:
					System.out.println("FIN DEL PROGRAMA");
					break;
				default:
					System.out.println("Comando incorrecto\n");
					break;
				}
				
			} catch (InputMismatchException e1) {
				System.out.println("Debes introducir un número\n");
				sc.nextLine();
			}
			
			
		} while (comando!=6);
		/**
		 * Al salir del bucle se da por terminado el programa
		 */
		sc.close();
	}
	
	/**
	 * Método para visualizar el menú principal del programa
	 */
	private static void menu() {
		
		System.out.println("— MENÚ DE BIBLIOTECA —");
		System.out.println("1. Introducir Libro");
		System.out.println("2. Introducir SerieTV");
		System.out.println("3. Introducir Videojuego");
		System.out.println("4. Inventario de la biblioteca");
		System.out.println("5. Mostrar contenido de la bilioteca");
		System.out.println("6. Salir");
	}
	
	/**
	 * Método para crear un objeto de la clase Libro
	 */
	private static void altaLibro() {
		
		/**
		 * Creamos una instancia de la clase libro e introducimos los valores directamente con los métodos set correspondientes
		 */
		Libro newLibro = new Libro();
		
		System.out.println("Introducir Libro");
		System.out.print("\tDime el título: ");
		sc.nextLine();
		newLibro.setTitulo(sc.nextLine());
		System.out.print("\tDime el autor del libro: ");
		newLibro.setAutor(sc.nextLine());
		System.out.print("\tDime la editorial del libro: ");
		newLibro.setEditorial(sc.nextLine());
		System.out.print("\tDime el número de páginas: ");
		newLibro.setNumPaginas(sc.next());
		
		/**
		 * Llamamos al método estático añadirColeccionable de la clase Biblioteca
		 * Pasamos como argumento el objeto creado
		 */
		Biblioteca.añadirColeccionable(newLibro);
		
		System.out.println("\nSe ha añadido un nuevo libro\n");	
	}
	
	/**
	 * Método para crear un objeto de la clase SerieTV
	 */
	private static void altaSerie() {
		
		/**
		 * Pedimos al usuario los valores correspondientes y los introducimos en variables
		 */
		System.out.println("Introducir SerieTV");
		sc.nextLine();
		System.out.print("\tDime el nombre de la serie: ");
		String nombreSerie = sc.nextLine();
		
		System.out.print("\tDime las temporadas de la serie: ");
		
		/**
		 * Intentamos leer el valor de las temporadas y capitulos como int
		 * Atrapamos la excepción InputMismatchException en caso de introducir un tipo de dato incorrecto
		 * En caso de que los datos sean correctos creamos un objeto de SerieTV pasando como argumentos las variables correspondientes
		 * Pasamos el objeto creado como argumento al método estático añadirColeccionable de la clase Biblioteca
		 */
		try {
			int temporadas = sc.nextInt();
			int[] capitulos = new int[temporadas];
			
			for(int i=0; i<temporadas; i++) {
				
				System.out.print("\tDime los capitulos de la temporada " + (i+1) + ": ");
				capitulos[i] = sc.nextInt();
			}
			
			SerieTV nuevaSerie = new SerieTV(nombreSerie, temporadas, capitulos);
			
			Biblioteca.añadirColeccionable(nuevaSerie);
			
			System.out.println("\nSe ha añadido una nueva serie\n");
			
		} catch (InputMismatchException e1) {
			System.out.println("Debes introducir un número, se ha cancelado la operación\n");
			sc.nextLine();
		}	
	}
	
	/**
	 * Método para crear un objeto de la clase VideoJuego
	 */
	private static void altaVideojuego() {
		
		/**
		 * Introducimos los datos en variables compatibles
		 */
		System.out.println("Introducir Videojuego");
		System.out.print("\tDime el nombre del videojuego: ");
		sc.nextLine();
		String juego = sc.nextLine();
		
		System.out.print("\tDime la plataforma del videojuego: ");
		String plataforma = sc.next();
		
		/**
		 * Organizamos el array de plataformas
		 * Comprobamos que la plataforma del videojuego introducida por el usuario esté dentro de las válidas en la biblioteca
		 * Repetimos esta acción hasta que la plataforma sea correcta
		 */
		Arrays.sort(plataformas);
		while(Arrays.binarySearch(plataformas, plataforma) < 0) {
			
			System.out.println("\nPlataforma incorrecta, debes elegir una de las plataformas válidas:");
			System.out.println("\t"+Arrays.toString(plataformas));
			
			System.out.print("\n\tDime una plataforma válida: ");
			plataforma = sc.next();
		}
		
		/**
		 * Creamos un objeto de VideoJuego pasando como argumento las variables correspondientes
		 * Pasamos el objeto instanciado al método estático añadirColeccionable de la clase biblioteca
		 */
		VideoJuego nuevoJuego = new VideoJuego(juego, plataforma);
		Biblioteca.añadirColeccionable(nuevoJuego);
		System.out.println("\nSe ha añadido un nuevo videojuego\n");	
	}
}