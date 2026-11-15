package ud03;

import java.util.Scanner;

public class Tienda2ver2 {

    // Método para comprobar si el array está completamente vacío
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

    // Método para buscar la posición de un artículo (insensible a mayúsculas/minúsculas)
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

    // 1. Añadir artículos y precios
    public static void introducirProPre(String[] aArticulos, double[] aPrecios, Scanner sc) {
        String respuesta;
        boolean seguir = true;
        int i;
        int posLibre;
        String nombreArticulo;
        double precioArticulo;
        boolean encontradoLibre = false;

        while (seguir) {
            posLibre = -1;
            i = 0;
            encontradoLibre = false;
            
            // Buscar la primera posición libre (null)
            while (i < aArticulos.length && !encontradoLibre) {
                if (aArticulos[i] == null) {
                    posLibre = i;
                    encontradoLibre = true;
                }
                i++;
            }

            if (posLibre == -1) {
                System.out.println("No hay espacio libre.");
                seguir = false;
            } else {
                System.out.print("Introduce el nombre del artículo:\n> ");
                nombreArticulo = sc.nextLine();
                System.out.print("Introduce el precio del producto:\n> ");
                precioArticulo = sc.nextDouble();
                sc.nextLine(); // Limpiar el buffer

                aArticulos[posLibre] = nombreArticulo;
                aPrecios[posLibre] = precioArticulo;
                System.out.println("El artículo ha sido introducido.");

                System.out.print("¿Quieres introducir más artículos? (si/no): ");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("no")) {
                    seguir = false;
                }
            }
        }
    }

    // 2. Mostrar productos de la tienda
    public static void mostrarProductos(String[] aArticulos, double[] aPrecios) {
        int i;
        
        if (estaVacio(aArticulos)) {
            System.out.println("No hay productos en la tienda.");
        } else {
            i = 0;
            while (i < aArticulos.length) {
                if (aArticulos[i] != null) {
                    System.out.println("El precio del artículo " + aArticulos[i] + " es de " + aPrecios[i] + " €");
                }
                i++;
            }
        }
    }

    // 3. Obtener el precio de un producto
    public static void mostrarPrecio(Scanner sc, String[] aArticulos, double[] aPrecios) {
        String articulo;
        int pos;
        
        if (estaVacio(aArticulos)) {
            System.out.println("No hay artículos en la tienda.");
        } else {
            System.out.print("¿Cuál es el nombre del artículo?\n ");
            articulo = sc.nextLine();
            pos = buscarPos(aArticulos, articulo);
            
            if (pos == -1) {
                System.out.println("El artículo no existe.");
            } else {
                System.out.println("El precio del artículo " + aArticulos[pos] + " es de " + aPrecios[pos] + " €");
            }
        }
    }

    // 4. Obtener el IVA de un producto (21%)
    public static void obtenerIva(Scanner sc, String[] aArticulos, double[] aPrecios) {
        String articulo;
        int pos;
        double iva;
        
        if (estaVacio(aArticulos)) {
            System.out.println("No hay artículos en la tienda.");
        } else {
            System.out.print("¿Cuál es el nombre del artículo?\n> ");
            articulo = sc.nextLine();
            pos = buscarPos(aArticulos, articulo);
            if (pos == -1) {
                System.out.println("El artículo no existe.");
            } else {
                iva = aPrecios[pos] * 0.21;
                System.out.println("El IVA del artículo " + aArticulos[pos] + " es " + iva + "€");
            }
        }
    }

    // 5. Modificar el precio de un producto
    public static void modPrecio(Scanner sc, String[] aArticulos, double[] aPrecios) {
        String articulo;
        int pos;
        double nuevoPrecio;
        
        if (estaVacio(aArticulos)) {
            System.out.println("No hay artículos en la tienda.");
        } else {
            System.out.print("¿Cuál es el nombre del artículo?\n> ");
            articulo = sc.nextLine();
            pos = buscarPos(aArticulos, articulo);
            if (pos == -1) {
                System.out.println("El artículo no existe.");
            } else {
                System.out.print("Introduce el nuevo precio del producto:\n> ");
                nuevoPrecio = sc.nextDouble();
                sc.nextLine(); // Limpiar el buffer
                aPrecios[pos] = nuevoPrecio;
                System.out.println("El precio del " + aArticulos[pos] + " ha sido modificado.");
            }
        }
    }

    // 6. Eliminar un producto
    public static void eliminar(String[] aArticulos, double[] aPrecios, Scanner sc) {
        String articulo;
        int pos;
        String confirmacion;
        
        if (estaVacio(aArticulos)) {
            System.out.println("No hay artículos en la tienda.");
        } else {
            System.out.print("¿Cuál es el nombre del artículo que quieres eliminar?\n> ");
            articulo = sc.nextLine();
            pos = buscarPos(aArticulos, articulo);
            if (pos == -1) {
                System.out.println("El artículo no existe.");
            } else {
                System.out.print("¿Estás segur@ de que quieres eliminarlo?\n> ");
                confirmacion = sc.nextLine();
                if (confirmacion.equalsIgnoreCase("Si") || confirmacion.equalsIgnoreCase("Sí")) {
                    aArticulos[pos] = null;
                    aPrecios[pos] = 0.0;
                    System.out.println("Producto eliminado correctamente");
                } else {
                    System.out.println("Eliminación cancelada.");
                }
            }
        }
    }

    // 7. Salir del programa
    public static void salir() {
        System.out.println("Saliendo del programa. ¡Hasta pronto!");
    }

// Método principal MAIN------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] aArticulos = new String[50];
        double[] aPrecios = new double[50];
        int opcion = 0;

        do {
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
            sc.nextLine(); //limpiar el buffer

            switch (opcion) {
                case 1:
                    introducirProPre(aArticulos, aPrecios, sc);
                    break;
                case 2:
                    mostrarProductos(aArticulos, aPrecios);
                    break;
                case 3:
                    mostrarPrecio(sc, aArticulos, aPrecios);
                    break;
                case 4:
                    obtenerIva(sc, aArticulos, aPrecios);
                    break;
                case 5:
                    modPrecio(sc, aArticulos, aPrecios);
                    break;
                case 6:
                    eliminar(aArticulos, aPrecios, sc);
                    break;
                case 7:
                    salir();
                    break;
                default:
                    System.out.println("Opción no válida, inténtalo de nuevo.");
            }
        } while (opcion != 7);

        sc.close();
    }
}