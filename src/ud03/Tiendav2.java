package ud03;

import java.util.Scanner;

public class Tiendav2 {

	public static void main(String[] args) {
		//variables
		Scanner teclado = new Scanner(System.in);
		String productos[] = new String[50];
		int precio[] = new int[50];
		int opciones;

		do {
			System.out.println("\nBienvenido.");
			System.out.println("1.- Añadir articulo y precios");
			System.out.println("2.- Mostrar productos de la tienda.");
			System.out.println("3.- Obtener precio de un producto.");
			System.out.println("4- Obtener IVA de un producto");
			System.out.println("5.- Modificar precio de un producto.");
			System.out.println("6.- Eliminar un producto");
			System.out.println("7.- Salir del programa.");
			System.out.print("Introduce una opcion:");

			opciones = teclado.nextInt();

			switch (opciones) {
			case 1:
				introducirProducto(productos, precio, teclado);
				break;
			case 2:
				mostrarProductosyPrecios(productos, precio, teclado);
				break;
			case 3:
				mostrarPrecio(productos, precio, teclado);
				break;
			case 4:
				mostrarIva(productos, teclado);
				break;
			case 5:
				cambiarPrecio(productos, precio, teclado);
				break;
			case 6:
				eliminarProducto(productos, precio, teclado);
				break;
			case 7:
				System.out.println("Has cerrado el programa");
				break;
			default:
				System.out.println("Has introducido una opcion no valida,intentalo de nuevo.");
				break;
			}

		} while (opciones != 7);

		teclado.close();
	}

	public static void introducirProducto(String[] productos, int[] precio, Scanner teclado) {
		int precios = 0;
		boolean encontrado=false, vacio=false;
		System.out.println("Dime el nombre del producto que quieras añadir:");
		String producto = teclado.next();

		for (int i = 0; i < productos.length; i++) {
			if (productos[i]==null) {
				vacio=true;
			}
		}
		if (vacio) {
			for (int i = 0; i < productos.length && !encontrado; i++) {
				if (productos[i]==null) {
					productos[i] = producto;
					System.out.println("Que precio quieres ponerle al producto?");
					precios = teclado.nextInt();
					precio[i] = precios;
					System.out.println("Producto añadido correctamente en la posicion " + (i + 1));
					encontrado=true;
				}
			}
		}else {
			System.out.println("La tienda esta llena");
		}
	}

	public static void mostrarProductosyPrecios(String[] productos, int[] precio, Scanner teclado) {
		boolean vacio=true;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i]!=null) {
				vacio = false;
			}
		}if(!vacio) {
			for (int i = 0; i < productos.length; i++) {
				if (productos[i]!=null) {
					System.out.println(productos[i] + " tiene un precio de " + precio[i] + "$");
				}
			}
		}else {
			System.out.println("La tienda esta vacia");
		}
	}

	public static void mostrarPrecio(String[] productos, int[] precio, Scanner teclado) {
		boolean vacio=true;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i]!=null) {
				vacio = false;
			}
		}if(!vacio) {
			System.out.println("De que producto quieres saber el precio?");
			String producto = teclado.next();
			boolean encontrado = false;
			for (int i = 0; i < productos.length && !encontrado; i++) {
				if (productos[i].equalsIgnoreCase(producto)) {
					System.out.println("El producto: " + productos[i] + " vale: " + precio[i] + "$");
					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println("Producto no encontrado.");
			}
		}else {
			System.out.println("La tienda esta vacia");
		}
	}

	public static void mostrarIva(String[] productos, Scanner teclado) {
		boolean vacio=true;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i]!=null) {
				vacio = false;
			}
		}if(!vacio) {
			System.out.println("De que producto quieres saber el IVA?");
			String producto = teclado.next();
			boolean encontrado = false;
			for (int i = 0; i < productos.length && !encontrado; i++) {
				if (productos[i].equalsIgnoreCase(producto)) {
					System.out.println("El producto: " + productos[i] + " tiene un IVA de 0.21");
					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println("Producto no encontrado.");
			}
		}
		else {System.out.println("La tienda esta vacia");
		}
	}

	public static void cambiarPrecio(String[] productos, int precio[], Scanner teclado) {
		boolean vacio=true;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i]!=null) {
				vacio = false;
			}
		}if(!vacio) {
			System.out.println("Dime el producto que le quieras cambiar el precio:");
			int precios = 0;
			boolean encontrado = false;
			String producto = teclado.next();
			for (int i = 0; i < productos.length && !encontrado; i++) {
				if (producto.equalsIgnoreCase(productos[i])) {
					System.out.println("Que precio quieres ponerle a " + producto);
					precios = teclado.nextInt();
					precio[i] = precios;
					System.out.println("Precio cambiado con exito");
					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println("No existe el producto en la tienda");
			}
		}
		else {System.out.println("La tienda esta vacia");
		}
	}

	public static void eliminarProducto(String[] productos, int[] precio, Scanner teclado) {
		boolean vacio=true;
		for (int i = 0; i < productos.length; i++) {
			if (productos[i]!=null) {
				vacio = false;
			}
		}if(!vacio) {
			String producto;
			boolean encontrado = false;
			System.out.println("Dime el nombre del producto que quieres eliminar:");
			producto = teclado.next();
			for (int i = 0; i < productos.length&&!encontrado; i++) {
				if (producto.equalsIgnoreCase(productos[i])) {
					productos[i] = null;
					precio[i]=0;
					System.out.println("Producto eliminada");
					encontrado = true;
				}
			}
			if (!encontrado) {
				System.out.println("No existe el producto");
			}
		}
		else {System.out.println("La tienda esta vacia");
		}

	}

}