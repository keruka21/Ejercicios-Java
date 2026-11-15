package ud03;

/*PDF Tienda 2.

Vamos a crear un programa para gestionar nuestra tienda utilizando los métodos de java.
Al iniciar el programa se crearán 2 arrays de 50 posiciones.
El primer array contendrá los nombres de los artículos y el segundo el precio de los mismos.

El programa principal tendrá el siguiente menú:

    Añadir artículos y precios
    Mostrar productos de la tienda
    Obtener el precio de un producto
    Obtener el IVA de un producto
    Modificar el precio de un producto
    Eliminar un producto
    Salir ¿Qué quieres hacer?

1.- Añadir artículos y precios.

Se le pedirá al usuario que introduzca el nombre y el precio de un nuevo artículo.
En caso de que el array esté lleno, se mostrará un mensaje de error.
Daremos opción al usuario de introducir más de un artículo con su correspondiente precio.

2.- Mostrar productos de la tienda.

Se le mostrarán los nombres y precios de los artículos.
En caso de que el array no tenga datos, se mostrará un mensaje informativo. Ejemplo:

3.- Obtener el precio de un producto.

Se le pedirá al usuario el nombre de un producto y se mostrará su precio.
En caso de que el array no tenga datos, se mostrará un mensaje informativo.
Si el producto no se encuentra en el array, se le mostrará un mensaje de error.

4.- Obtener el iva de un producto.

Se le pedirá al usuario el nombre de un producto y se mostrará su iva (21%).
En caso de que el array no tenga datos, se mostrará un mensaje informativo.
Si el producto no se encuentra en el array, se le mostrará un mensaje de error.


5.- Modificar el precio de un producto.

Se le pedirá al usuario el nombre de un producto y el nuevo precio.
En caso de que el array no tenga datos, se mostrará un mensaje informativo.
Si el producto no se encuentra en el array, se le mostrará un mensaje de error.

6.- Eliminar un producto.

Se le pedirá al usuario el nombre de un producto y se le pedirá confirmación antes de borrarlo.
En caso de que el array no tenga datos, se mostrará un mensaje informativo.
Si el producto no se encuentra en el array, se le mostrará un mensaje de error.


7.- Salir del programa.*/

import java.util.Scanner;

public class Tienda2 {

	//comprobar si el array está completamente vacío
	public static boolean estaVacio(String[] aArticulos) {
		boolean vacio = true;
		int i = 0;
		while (i < aArticulos.length && vacio) {
			if (aArticulos[i] != null) {
				vacio = false;
			}
			i++;
		}
		return vacio;
	}

	//buscar la posición de un artículo
	public static int buscarPos(String[] aArticulos, String articulo) {
		int posEncontrado = -1;
		int i = 0;
		boolean encontrado = false;
		
		while (i < aArticulos.length && !encontrado) {
			if (aArticulos[i] != null && aArticulos[i].equalsIgnoreCase(articulo)) {
				posEncontrado = i;
				encontrado = true;
			}
			i++;
		}
		return posEncontrado;
	}

	// 1- añadir artículos y precios
	public static void introducirProPre(String[] aArticulos, double[] aPrecios, Scanner sc, String articulo, double precio) {
		int i = 0;
		int posLibre = -1;
		boolean encontradoLibre = false;
		
		//buscar la primera posición libre
		while (i < aArticulos.length && !encontradoLibre) {
			if (aArticulos[i] == null) {
				posLibre = i;
				encontradoLibre = true;
			}
			i++;
		}
		
		//no hay espacio libre
		if (posLibre == -1) {
			System.out.println("No hay espacio libre.");
		} else {
			System.out.println("Introduce el nombre del artículo:");
			articulo = sc.next();
			aArticulos[posLibre] = articulo;
			
			System.out.println("Introduce el precio del producto:");
			precio = sc.nextDouble();
			aPrecios[posLibre] = precio;
			
			System.out.println("El artículo ha sido introducido.");
		}
	}
	
	// 2- mostrar productos de la tienda
	public static void mostrarProductos(String[] aArticulos, double[] aPrecios) {
		if (estaVacio(aArticulos)) {
			System.out.println("No hay productos en la tienda.");
		} else {
			int i = 0;
			while (i < aArticulos.length) {
				if (aArticulos[i] != null) {
					System.out.println("El precio del artículo " + aArticulos[i] + " es de " + aPrecios[i] + " €");
				}
				i++;
			}
		}
	}

	// 3- obtener el precio de un producto
	public static void mostrarPrecio(Scanner sc, String[] aArticulos, double[] aPrecios, String articulo, double precio) { 
		if (estaVacio(aArticulos)) {
			System.out.println("No hay artículos en la tienda.");
		} else {
			System.out.println("¿Cuál es el nombre del artículo?");
			articulo = sc.next();
			
			int posicion = buscarPos(aArticulos, articulo);
			if (posicion != -1) {
				precio = aPrecios[posicion];
				System.out.println("El precio del artículo " + aArticulos[posicion] + " es de " + precio + " €");
			} else {
				System.out.println("El artículo no existe.");
			}
		}
	}
	
	// 4- obtener el iva de un producto
	public static void obtenerIva(Scanner sc, String[] aArticulos, double[] aPrecios, String articulo, double precio) {
		if (estaVacio(aArticulos)) {
			System.out.println("No hay artículos en la tienda.");
		} else {
			System.out.println("¿Cual es el nombre del artículo?");
			articulo = sc.next();
			
			int posicion = buscarPos(aArticulos, articulo);
			if (posicion != -1) {
				precio = aPrecios[posicion];
				double iva = precio * 0.21;
				System.out.println("El IVA del artículo " + aArticulos[posicion] + " es " + iva + "€");
			} else {
				System.out.println("El artículo no existe.");
			}
		}
	}
	
	// 5.modificar el precio de un producto
	public static void modPrecio(Scanner sc, String[] aArticulos, double[] aPrecios, String articulo, double precio) {
		if (estaVacio(aArticulos)) {
			System.out.println("No hay artículos en la tienda.");
		} else {
			System.out.println("¿Cuál es el nombre del artículo?");
			articulo = sc.next();
			
			int posicion = buscarPos(aArticulos, articulo);
			if (posicion != -1) {
				System.out.println("Introduce el nuevo precio del producto:");
				precio = sc.nextDouble();
				aPrecios[posicion] = precio;
				System.out.println("El precio del " + aArticulos[posicion] + " ha sido modificado.");
			} else {
				System.out.println("El artículo no existe.");
			}
		}
	}
	
	// 6- eliminar un producto
	public static void eliminar(String[] aArticulos, double[] aPrecios, Scanner sc, String articulo) {
		if (estaVacio(aArticulos)) {
			System.out.println("No hay artículos en la tienda.");
		} else {
			System.out.println("¿Cuál es el nombre del artículo que quieres eliminar?");
			articulo = sc.next();
			
			int posicion = buscarPos(aArticulos, articulo);
			if (posicion != -1) {
				System.out.println("¿Estás segur@ de que quieres eliminarlo?");
				String confirmacion = sc.next();
				
				if (confirmacion.equalsIgnoreCase("Si")) {
					aArticulos[posicion] = null;
					aPrecios[posicion] = 0.0;
					System.out.println("Producto eliminado correctamente");
				} else {
					System.out.println("Operación cancelada.");
				}
			} else {
				System.out.println("El artículo no existe.");
			}
		}
	}
	
	// 7.- Salir del programa
	public static void salir() {
		// Método de cierre estructurado
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] aArticulos = new String[50];
		double[] aPrecios = new double[50];
		int opcion = 0;
		String articulo = "";
		double precio = 0;
		
		do{
			System.out.println("***********************************************");
			System.out.println("1.- Añadir artículos y precios");
			System.out.println("2.- Mostrar productos de la tienda");
			System.out.println("3.- Obtener el precio de un producto");
			System.out.println("4.- Obtener el IVA de un producto");
			System.out.println("5.- Modificar el precio de un producto");
			System.out.println("6.- Eliminar un producto");
			System.out.println("7.- Salir");
			System.out.println("¿Qué quieres hacer?");
			
			opcion = sc.nextInt();
			
			switch(opcion) {
			case 1:
				introducirProPre(aArticulos, aPrecios, sc, articulo, precio);
				break;
			case 2:
				mostrarProductos(aArticulos, aPrecios);
				break;
			case 3:
				mostrarPrecio(sc, aArticulos, aPrecios, articulo, precio);
				break;
			case 4:
				obtenerIva(sc, aArticulos, aPrecios, articulo, precio);
				break;
			case 5:
				modPrecio(sc, aArticulos, aPrecios, articulo, precio);
				break;
			case 6:
				eliminar(aArticulos, aPrecios, sc, articulo);
				break;
			case 7:
				salir();
				break;
			default:
				System.out.println("Opción no válida, inténtalo de nuevo.");
			}
		}while(opcion != 7) ;
		
		sc.close();
	}
}