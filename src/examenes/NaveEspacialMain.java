package examenes;

/*
 * ========================================================================================
 * ENUNCIADO DEL EXAMEN: GESTIÓN DE NAVES ESPACIALES
 * ========================================================================================
 * Programa principal (Gestión de Misión Espacial):
 *   - Diseña un programa que gestione una misión de exploración espacial con un máximo de 50 naves.
 *   - El programa tendrá un menú repetitivo (mediante do-while y switch) con opciones 
 *     realizadas a través de métodos estáticos situados por encima del main:
 *       1. Añadir naves espaciales: Controlar límite de 50 naves, nombre único y que 
 *          el año de lanzamiento no sea anterior al de creación (usando LocalDate.now().getYear()).
 *       2. Mostrar naves cuya antigüedad sea superior o igual a una dada.
 *       3. Ordenar naves por año de lanzamiento en orden descendente.
 *       4. Modificar Capacidad Total de las naves que admiten pasajeros (comprobando 
 *          que la nueva capacidad no sea menor al número de tripulantes necesarios).
 *       5. Mostrar todas las naves espaciales registradas.
 *       6. Eliminar una nave espacial por su nombre (compactando el array para no dejar huecos).
 *       7. Salir del programa.
 * 
 * Notas importantes:
 *   - Controlar que no se puedan realizar las opciones de menú del 2 al 6 si no 
 *     hay ninguna nave guardada.
 * ========================================================================================
 */

import java.time.LocalDate;
import java.util.Scanner;

public class NaveEspacialMain {

    // MÉTODOS ESTÁTICOS AUXILIARES --------------------------------------------------------------------------------------------------

    // contarNaves: recorre el array y cuenta las posiciones que no son null
    /* Recorre el array de principio a fin y cuenta cuántas posiciones no son null.
     * Devuelve ese número. Es la forma de saber cuántas naves hay registradas sin usar un contador externo. */
    public static int contarNaves(NaveEspacial[] naves) {
        int total; // contador auxiliar que acumula cuántas naves hay guardadas en el array
        int i;     // índice para recorrer todas las posiciones del array

        // inicializar variables
        total = 0;

        for (i = 0; i < naves.length; i++) {
            if (naves[i] != null) {
                total++;
            }
        }
        return total;
    }

    // buscarNave: devuelve el índice de la nave cuyo nombre coincide, o -1 si no existe
    /* Recorre el array buscando una nave cuyo nombre coincida (sin distinguir mayúsculas/minúsculas). Devuelve:
     *   - El índice donde está la nave si la encuentra.
     *   - -1 si no existe.
     * Se usa en anadirNaves (para detectar nombres repetidos) y en eliminarNave (para localizar la nave a borrar). */
    public static int buscarNave(NaveEspacial[] naves, String nombre) {
        int i;              // índice para recorrer el array de naves
        boolean encontrada; // variable centinela/bandera (flag): false al inicio, cambia a true al localizar la nave

        // inicializar variables
        encontrada = false;

        // Bucle for con condición compuesta (!encontrada) para detener la búsqueda sin usar break
        for (i = 0; i < naves.length && !encontrada; i++) {
            if (naves[i] != null && naves[i].getNombre().equalsIgnoreCase(nombre)) {
                encontrada = true;
            }
        }

        // Si se encontró, el bucle incrementó 'i' una última vez al salir, por eso devolvemos i - 1
        if (encontrada) {
            return i - 1;
        } else {
            return -1;
        }
    }

    // 1. Añadir naves espaciales ----------------------------------------------------------------------------------------------------
    /* Bucle while que permite añadir varias naves seguidas. En cada iteración:
     *   - Comprueba si ya hay 50 naves (límite).
     *   - Pide el nombre y comprueba que no esté repetido (con buscarNave).
     *   - Pide año de creación y año de lanzamiento (el de lanzamiento no puede ser anterior).
     *   - Pide capacidad total y tripulantes necesarios.
     *   - Crea el objeto NaveEspacial y lo guarda en la primera posición libre.
     *   - Pregunta si quieres seguir añadiendo. */
    public static void anadirNaves(NaveEspacial[] aNaves, Scanner sc) {
        boolean seguirAniadiendo;  // bandera para controlar el bucle while y decidir si seguir introduciendo naves
        String nombre;             // guarda temporalmente el nombre introducido por teclado para la nueva nave
        int anioCreacion;          // año de fabricación de la nave
        int anioLanzamiento=0;       // año en que se lanzó al espacio
        boolean anioValido;        // bandera para repetir la petición del año de lanzamiento si es anterior al de creación
        int capacidadTotal;        // número máximo de personas (tripulación + pasajeros) que caben en la nave
        int tripulantesNecesarios; // número mínimo de personas necesarias para pilotar la nave
        String respuesta;          // "si" o "no" para saber si el usuario desea continuar añadiendo otra nave
        int indice;                // guarda el resultado de buscarNave (-1 si el nombre está libre)
        int totalNaves;            // almacena cuántas naves hay actualmente registradas en el array

        // inicializar variables
        seguirAniadiendo = true; // cambiará a false cuando el array se llene o el usuario responda "no"

        while (seguirAniadiendo) { // mientras seguirAniadiendo sea true haz:
            totalNaves = contarNaves(aNaves);

            if (totalNaves >= 50) {
                System.out.println("Error: Se ha alcanzado el límite máximo de 50 naves.");
                seguirAniadiendo = false; // sale del bucle
            } else {
                System.out.print("Introduce el nombre de la nave: ");
                nombre = sc.nextLine();

                // comprobar si el nombre está repetido usando buscarNave
                indice = buscarNave(aNaves, nombre);
                if (indice != -1) {
                    System.out.println("Ya existe una nave con ese nombre.");
                } else {
                    System.out.print("Introduce el año de creación: ");
                    anioCreacion = sc.nextInt();

                    // Reiniciamos la bandera anioValido en cada nueva nave antes de validar el lanzamiento
                    anioValido = false;
                    while (!anioValido) {
                        System.out.print("Introduce el año de lanzamiento: ");
                        anioLanzamiento = sc.nextInt();

                        if (anioLanzamiento < anioCreacion) {
                            System.out.println("Error: El año de lanzamiento no puede ser anterior al año de creación.");
                        } else {
                            anioValido = true; // dato correcto, permite salir del bucle de validación
                        }
                    }

                    System.out.print("Introduce la capacidad total de personas: ");
                    capacidadTotal = sc.nextInt();

                    System.out.print("Introduce el número de tripulantes necesarios: ");
                    tripulantesNecesarios = sc.nextInt();
                    sc.nextLine(); // limpiamos el salto de línea pendiente en el buffer tras nextInt()

                    // Guardamos el nuevo objeto en la primera posición libre (totalNaves)
                    aNaves[totalNaves] = new NaveEspacial(nombre, anioCreacion, anioLanzamiento, capacidadTotal, tripulantesNecesarios);
                    System.out.println("Nave añadida exitosamente.");
                }

                System.out.print("¿Quieres seguir introduciendo naves? (si/no): ");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("no")) {
                    seguirAniadiendo = false;
                }
            }
        }
    }

    // 2. Mostrar naves cuya antigüedad sea superior o igual a una introducida -------------------------------------------------------
    /* Pide un número (antigüedad mínima). Recorre las naves y muestra solo aquellas cuya antigüedad
     * (año actual - año de lanzamiento) sea >= al número introducido.
     * Si no hay ninguna que cumpla, lo indica. */
    public static void mostrarNavesAntiguedad(NaveEspacial[] aNaves, Scanner sc) {
        int totalNaves;       // número de naves registradas actualmente en el array
        int antiguedadMinima; // antigüedad mínima en años introducida por el usuario para filtrar
        int anioActual;       // guarda el año actual obtenido mediante LocalDate.now().getYear()
        int encontradas;      // contador de control: suma 1 cada vez que una nave cumple el requisito de antigüedad
        int i;                // índice para recorrer las naves registradas
        int antiguedadNave;   // almacena temporalmente el resultado de calcular la antigüedad de la nave actual

        totalNaves = contarNaves(aNaves);

        // Control previo: verificar si hay naves registradas
        if (totalNaves == 0) {
            System.out.println("Error: No hay naves registradas en el sistema.");
            return;
        }

        // inicializar variables
        anioActual = LocalDate.now().getYear();
        encontradas = 0;

        System.out.print("Introduce la antigüedad mínima: ");
        antiguedadMinima = sc.nextInt();
        sc.nextLine(); // limpiamos el salto de línea pendiente del buffer

        // recorrer las naves registradas
        for (i = 0; i < totalNaves; i++) {
            /* llama al método calcularAntiguedad(anioActual) del objeto NaveEspacial
             * para poder compararla directamente con la antiguedadMinima introducida por el usuario */
            antiguedadNave = aNaves[i].calcularAntiguedad(anioActual);
            if (antiguedadNave >= antiguedadMinima) {
                System.out.println(aNaves[i].toString());
                encontradas++;
            }
        }

        if (encontradas == 0) {
            System.out.println("No se encontraron naves con antigüedad superior o igual a " + antiguedadMinima);
        }
    }

    // 3. Ordenar naves por año de lanzamiento (descendente) -------------------------------------------------------------------------
    /* Ordena las naves por año de lanzamiento en orden descendente (la más reciente primero)
     * usando el algoritmo de burbuja (comparación de vecinos e intercambio).
     * Al terminar, imprime la lista ordenada. */
    public static void ordenarNavesPorAnio(NaveEspacial[] aNaves) {
        int totalNaves;        // número de naves registradas actualmente en el array
        int i;                 // índice principal para el bucle externo (controla cuántas pasadas completas se realizan)
        int j;                 // índice utilizado en el bucle interno para comparar elementos adyacentes (j con j + 1)
        int k;                 // índice para el bucle for final encargado de imprimir el array ya ordenado
        NaveEspacial auxiliar; // variable temporal de tipo NaveEspacial para hacer el intercambio (swap) de posiciones

        totalNaves = contarNaves(aNaves);

        // Control previo: verificar si hay naves registradas
        if (totalNaves == 0) {
            System.out.println("Error: No hay naves registradas en el sistema.");
            return;
        }

        // Ordenación por el método de la burbuja (descendente: signo <)
        for (i = 0; i < totalNaves - 1; i++) {
            for (j = 0; j < totalNaves - i - 1; j++) {
                if (aNaves[j].getAnioLanzamiento() < aNaves[j + 1].getAnioLanzamiento()) {
                    auxiliar = aNaves[j];
                    aNaves[j] = aNaves[j + 1];
                    aNaves[j + 1] = auxiliar;
                }
            }
        }

        System.out.println("Naves ordenadas por año de lanzamiento (descendente):");
        for (k = 0; k < totalNaves; k++) {
            System.out.println(aNaves[k].toString());
        }
    }

    // 4. Modificar capacidad total de naves que admiten pasajeros ------------------------------------------------------------------
    /* Recorre las naves y se queda solo con las que admiten pasajeros (capacidadTotal > tripulantesNecesarios).
     * Para cada una:
     *   - Muestra sus datos.
     *   - Pregunta si quieres cambiar la capacidad.
     *   - Si es "si", pide la nueva capacidad y comprueba que no sea menor que los tripulantes necesarios.
     *   - Si es válida, actualiza con setCapacidadTotal.
     *   - Si no hay ninguna nave que admita pasajeros, lo indica. */
    public static void modificarCapacidadPasajeros(NaveEspacial[] aNaves, Scanner sc) {
        int totalNaves;          // número de naves registradas actualmente en el array
        int navesPasajeros;      // contador auxiliar: suma 1 cada vez que se encuentra una nave que admite pasajeros
        int i;                   // índice para recorrer todas las naves registradas
        String respuesta;        // "si" o "no" para confirmar si el usuario desea modificar esa nave
        boolean capacidadValida; // flag que controla el bucle de validación (true cuando la nueva capacidad es >= tripulantes)
        int nuevaCapacidad;      // nueva capacidad total que se le quiere asignar a la nave seleccionada

        totalNaves = contarNaves(aNaves);

        // Control previo: verificar si hay naves registradas
        if (totalNaves == 0) {
            System.out.println("Error: No hay naves registradas en el sistema.");
            return;
        }

        // inicializar variables
        navesPasajeros = 0;

        // Bucle for para recorrer las naves
        for (i = 0; i < totalNaves; i++) {
            if (aNaves[i].admitePasajeros()) {
                navesPasajeros++;
                System.out.println(aNaves[i].toString());
                System.out.print("¿Desea cambiar la capacidad total de la nave? (si/no): ");
                respuesta = sc.nextLine();

                if (respuesta.equalsIgnoreCase("si")) {
                    capacidadValida = false;
                    while (!capacidadValida) {
                        System.out.print("Introduce la nueva capacidad para la nave " + aNaves[i].getNombre() + ": ");
                        nuevaCapacidad = sc.nextInt();
                        sc.nextLine(); // limpiamos el buffer

                        if (nuevaCapacidad < aNaves[i].getTripulantesNecesarios()) {
                            System.out.println("Error: La nueva capacidad no puede ser menor que el número de tripulantes necesarios.");
                        } else {
                            aNaves[i].setCapacidadTotal(nuevaCapacidad);
                            System.out.println("Capacidad actualizada correctamente.");
                            capacidadValida = true;
                        }
                    }
                }
            }
        }

        if (navesPasajeros == 0) {
            System.out.println("Error: No se encontró ninguna nave que admita pasajeros.");
        }
    }

    // 5. Mostrar todas las naves espaciales registradas -----------------------------------------------------------------------------
    /* Recorre todas las naves registradas y las imprime con toString(). */
    public static void mostrarTodasLasNaves(NaveEspacial[] aNaves) {
        int totalNaves; // número de naves registradas actualmente en el array
        int i;          // índice para recorrer el array desde 0 hasta totalNaves - 1

        totalNaves = contarNaves(aNaves);

        // Control previo: verificar si hay naves registradas
        if (totalNaves == 0) {
            System.out.println("Error: No hay naves registradas en el sistema.");
            return;
        }

        for (i = 0; i < totalNaves; i++) {
            System.out.println(aNaves[i].toString());
        }
    }

    // 6. Eliminar una nave espacial (compactando el array) --------------------------------------------------------------------------
    /* Pide el nombre de la nave a eliminar:
     *   - Busca su índice con buscarNave.
     *   - Si no existe, muestra error.
     *   - Si existe, desplaza todas las naves que están a su derecha una posición hacia la izquierda
     *     (compactación) y pone null en la última posición. */
    public static void eliminarNave(NaveEspacial[] aNaves, Scanner scanner) {
        int totalNaves;       // número de naves registradas actualmente en el array
        String nombreBorrar;  // almacena el nombre de la nave espacial que el usuario desea eliminar
        int indiceEncontrado; // guarda la posición numérica (índice) donde está la nave, o -1 si no existe
        int j;                // variable de control para compactar el array desplazando elementos hacia la izquierda

        totalNaves = contarNaves(aNaves);

        // Control previo: verificar si hay naves registradas
        if (totalNaves == 0) {
            System.out.println("Error: No hay naves registradas en el sistema.");
            return;
        }

        System.out.print("Introduce el nombre de la nave que deseas eliminar: ");
        nombreBorrar = scanner.nextLine();

        // Localizamos la posición de la nave usando el método auxiliar buscarNave
        indiceEncontrado = buscarNave(aNaves, nombreBorrar);

        if (indiceEncontrado == -1) {
            System.out.println("No se encontró ninguna nave con ese nombre.");
        } else {
            // Bucle for para compactar el array: tapa el hueco desplazando cada elemento a la izquierda
            for (j = indiceEncontrado; j < totalNaves - 1; j++) {
                aNaves[j] = aNaves[j + 1];
            }
            // Ponemos a null la última posición ocupada para no dejar referencias duplicadas
            aNaves[totalNaves - 1] = null;
            System.out.println("Nave eliminada correctamente.");
        }
    }

    // MAIN --------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc;              // objeto Scanner para leer los datos introducidos por teclado
        NaveEspacial[] aNaves;   // array con capacidad fija para almacenar hasta 50 objetos NaveEspacial
        int opcion;              // guarda el número de opción elegido por el usuario en el menú

        // Inicialización de objetos principales
        sc = new Scanner(System.in);
        aNaves = new NaveEspacial[50];

        // Bucle principal del menú repetitivo (se ejecuta hasta que el usuario elija la opción 7)
        do {
            System.out.println("\n----- MENÚ DE MISIÓN ESPACIAL -----");
            System.out.println("1. Añadir naves espaciales");
            System.out.println("2. Mostrar naves cuya antigüedad sea superior a una dada");
            System.out.println("3. Ordenar naves por año de lanzamiento");
            System.out.println("4. Modificar capacidad total de naves que admiten pasajeros");
            System.out.println("5. Mostrar todas las naves espaciales registradas");
            System.out.println("6. Eliminar una nave espacial");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiamos el salto de línea

            switch (opcion) {
                case 1:
                    anadirNaves(aNaves, sc);
                    break;
                case 2:
                    mostrarNavesAntiguedad(aNaves, sc);
                    break;
                case 3:
                    ordenarNavesPorAnio(aNaves);
                    break;
                case 4:
                    modificarCapacidadPasajeros(aNaves, sc);
                    break;
                case 5:
                    mostrarTodasLasNaves(aNaves);
                    break;
                case 6:
                    eliminarNave(aNaves, sc);
                    break;
                case 7:
                    System.out.println("¡Hasta pronto :-)! Finalizando el programa de exploración espacial.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduce un número del 1 al 7.");
                    break;
            }

        } while (opcion != 7);

        sc.close(); // cerramos el Scanner al finalizar el programa
    }
}