package ud03;

import java.util.Scanner;

public class TiendaLibrosEstaticos {

    // Método auxiliar: contar cuántos libros hay registrados (posiciones no nulas)
    public static int contarLibros(String[] titulos) {
        int contador = 0;
        
        for (int i = 0; i < titulos.length; i++) {
            if (titulos[i] != null) {
                contador++;
            }
        }
        return contador;
    }

    // Método auxiliar: buscar la posición de un libro por su título
    public static int buscarLibro(String[] titulos, String tituloBuscado) {
        int posicion = -1;
        boolean encontrado = false;

        for (int i = 0; i < titulos.length && !encontrado; i++) {
            if (titulos[i] != null && titulos[i].equalsIgnoreCase(tituloBuscado)) {
                posicion = i;
                encontrado = true;
            }
        }
        return posicion;
    }

    // 1. Mostrar el título de todos los libros
    public static void mostrarTitulos(String[] titulos) {
        int total = contarLibros(titulos);
        
        if (total == 0) {
            System.out.println("No hay libros en la tienda.");
        } else {
            for (int i = 0; i < titulos.length; i++) {
                if (titulos[i] != null) {
                    System.out.println("- " + titulos[i]);
                }
            }
        }
    }

    // 2. Mostrar el título y el precio de todos los libros
    public static void mostrarTitulosYPrecios(String[] titulos, int[] precios) {
        int total = contarLibros(titulos);
        
        if (total == 0) {
            System.out.println("No hay libros en la tienda.");
        } else {
            for (int i = 0; i < titulos.length; i++) {
                if (titulos[i] != null) {
                    System.out.println("El precio del libro \"" + titulos[i] + "\" son " + precios[i] + " euros.");
                }
            }
        }
    }

    // 3. Mostrar el precio de un libro
    public static void mostrarPrecioLibro(String[] titulos, int[] precios, Scanner sc) {
        int total = contarLibros(titulos);
        
        if (total == 0) {
            System.out.println("No hay libros en la tienda.");
        } else {
            System.out.println("¿Cuál es el título del libro?");
            System.out.print("> ");
            String titulo = sc.nextLine();

            int pos = buscarLibro(titulos, titulo);
            if (pos == -1) {
                System.out.println("El libro no existe.");
            } else {
                System.out.println("El precio del libro \"" + titulos[pos] + "\" son " + precios[pos] + " euros.");
            }
        }
    }

    // 4. Introducir un nuevo libro (en la primera posición libre)
    public static void introducirLibro(String[] titulos, int[] precios, Scanner sc) {
        int posLibre = -1;
        boolean encontradoLibre = false;

        // Buscar la primera posición libre (null) con un for
        for (int i = 0; i < titulos.length && !encontradoLibre; i++) {
            if (titulos[i] == null) {
                posLibre = i;
                encontradoLibre = true;
            }
        }

        if (posLibre == -1) {
            System.out.println("Tienes muchos libros en la tienda, elimina un libro.");
        } else {
            System.out.println("¿Cuál es el título del libro?");
            System.out.print("> ");
            String titulo = sc.nextLine();

            System.out.println("¿Cuál es el precio?");
            System.out.print("> ");
            int precio = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            titulos[posLibre] = titulo;
            precios[posLibre] = precio;
            System.out.println("El libro ha sido guardado.");
        }
    }

    // 5. Eliminar un libro (compactando el array)
    public static void eliminarLibro(String[] titulos, int[] precios, Scanner sc) {
        int total = contarLibros(titulos);
        
        if (total == 0) {
            System.out.println("No hay libros en la tienda.");
        } else {
            System.out.println("¿Cuál es el título del libro?");
            System.out.print("> ");
            String titulo = sc.nextLine();

            int pos = buscarLibro(titulos, titulo);
            if (pos == -1) {
                System.out.println("El libro no existe.");
            } else {
                // Desplazar elementos a la izquierda (compactación en ambos arrays paralelos)
                for (int j = pos; j < titulos.length - 1; j++) {
                    titulos[j] = titulos[j + 1];
                    precios[j] = precios[j + 1];
                }
                
                // Limpiar la última posición
                titulos[titulos.length - 1] = null;
                precios[precios.length - 1] = 0;

                System.out.println("El libro ha sido eliminado.");
            }
        }
    }

    // 6. Modificar el precio de un libro
    public static void modificarPrecio(String[] titulos, int[] precios, Scanner sc) {
        int total = contarLibros(titulos);
        
        if (total == 0) {
            System.out.println("No hay libros en la tienda.");
        } else {
            System.out.println("¿Cuál es el título del libro?");
            System.out.print("> ");
            String titulo = sc.nextLine();

            int pos = buscarLibro(titulos, titulo);
            if (pos == -1) {
                System.out.println("El libro no existe.");
            } else {
                System.out.println("El precio del libro " + titulos[pos] + " son " + precios[pos] + " euros.");
                System.out.println("¿Cuál es el nuevo precio?");
                System.out.print("> ");
                int nuevoPrecio = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                precios[pos] = nuevoPrecio;
                System.out.println("El precio ha sido cambiado.");
                System.out.println("El nuevo precio del libro " + titulos[pos] + " son " + precios[pos] + " euros.");
            }
        }
    }

    // 7. Modificar el título de un libro
    public static void modificarTitulo(String[] titulos, Scanner sc) {
        int total = contarLibros(titulos);
        
        if (total == 0) {
            System.out.println("No hay libros en la tienda.");
        } else {
            System.out.println("¿Cuál es el título del libro?");
            System.out.print("> ");
            String tituloAntiguo = sc.nextLine();

            int pos = buscarLibro(titulos, tituloAntiguo);
            if (pos == -1) {
                System.out.println("El libro no existe.");
            } else {
                System.out.println("¿Cuál es el nuevo título del libro?");
                System.out.print("> ");
                String nuevoTitulo = sc.nextLine();

                titulos[pos] = nuevoTitulo;
                System.out.println("El título ha sido modificado.");
                System.out.println("El nuevo título del libro es " + titulos[pos] + ".");
            }
        }
    }

//MAIN-----------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] titulos = new String[20];
        int[] precios = new int[20];
        int opcion = 0;

        //valores iniciales (0 a 11)
        titulos[0] = "Nada";
        titulos[1] = "Tímidamente de la oscuridad a la luz";
        titulos[2] = "Pájaros a golpes";
        titulos[3] = "Caperucita Roja";
        titulos[4] = "12 cuentos clásicos";
        titulos[5] = "Pepe y Mila";
        titulos[6] = "Enojaos";
        titulos[7] = "En casa vacía";
        titulos[8] = "123";
        titulos[9] = "Día Negro";
        titulos[10] = "El Hobbit";
        titulos[11] = "Calle Judía";

        precios[0] = 15;
        precios[1] = 12;
        precios[2] = 15;
        precios[3] = 25;
        precios[4] = 19;
        precios[5] = 17;
        precios[6] = 25;
        precios[7] = 13;
        precios[8] = 11;
        precios[9] = 18;
        precios[10] = 25;
        precios[11] = 35;

        do {
            System.out.println("\n***********************************************");
            System.out.println("1.- Mostrar el título de todos los libros.");
            System.out.println("2.- Mostrar el título y el precio de todos los libros.");
            System.out.println("3.- Mostrar el precio de un libro.");
            System.out.println("4.- Introducir un nuevo libro.");
            System.out.println("5.- Eliminar un libro.");
            System.out.println("6.- Modificar el precio de un libro.");
            System.out.println("7.- Modificar el título de un libro.");
            System.out.println("8.- Salir del programa.");
            System.out.print("¿Qué quieres hacer?\n> ");
           
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
            	case 1:
            		mostrarTitulos(titulos);
            		break;
            	case 2:
            		mostrarTitulosYPrecios(titulos, precios);
            		break;
            	case 3:
            		mostrarPrecioLibro(titulos, precios, sc);
            		break;
            	case 4:
            		introducirLibro(titulos, precios, sc);
            		break;
                        
            	case 5:
            		eliminarLibro(titulos, precios, sc);
            		break;
                        
            	case 6:
            		modificarPrecio(titulos, precios, sc);
            		break;
                        
            	case 7:
            		modificarTitulo(titulos, sc);
            		break;
                        
            	case 8:
            		System.out.println("Saliendo del programa. ¡Hasta pronto :-)!");
            		break;
                        
            	default:
            		System.out.println("Opción no válida. Introduce un número del 1 al 8.");
            		break;
                }

        } while (opcion != 8);

        sc.close();
    }
}