package examenes;

/*Una vez creada la clase NaveEspacial, diseña un programa que gestione una misión de exploración espacial con un máximo de 50 naves espaciales. El programa tendrá un menú repetitivo con las siguientes opciones que deben ser realizadas mediante métodos estáticos: 

Añadir naves espaciales: Podemos añadir varias, pero no es necesario introducir todas a la vez. Se debe controlar que no se añadan más de 50 naves y que el nombre de la nave sea único. También se deberá asegurar por cada nave nueva introducida que el año de lanzamiento no sea anterior al año de creación. 
LocalDate.now().getYear()) -> Devuelve un valor entero que hace referencia al año en curso


Elige una opción: 1
Introduce el nombre de la nave: Apolo
Introduce el año de creación: 2002
Introduce el año de lanzamiento: 2001
Error: El año de lanzamiento no puede ser anterior al año de creación.
Introduce el año de lanzamiento: 2002
Introduce la capacidad total de personas: 4
Introduce el número de tripulantes necesarios: 2
Nave añadida exitosamente.
Quieres seguir introduciendo naves?
si
Introduce el nombre de la nave: Apolo
Ya existe una nave con ese nombre.
Quieres seguir introduciendo naves?
si
Introduce el nombre de la nave: ApoloII
Introduce el año de creación: 2013
Introduce el año de lanzamiento: 2014
Introduce la capacidad total de personas: 6
Introduce el número de tripulantes necesarios: 6
Nave añadida exitosamente.
Quieres seguir introduciendo naves?

Mostrar naves cuya antigüedad sea superior a una dada:Se solicitará la antigüedad, y el programa mostrará todas las naves, junto con sus datos, cuya antigüedad sea superior o igual a la introducida. Si no se encuentra ninguna nave que cumpla el criterio anterior, se lanzará un mensaje de aviso.

Elige una opción: 2
Introduce la antigüedad mínima: 1
Nave Espacial: Apolo, Año de Creación: 2002, Año de Lanzamiento: 2002, Capacidad Total: 4, Tripulantes Necesarios: 2
Nave Espacial: ApoloII, Año de Creación: 2010, Año de Lanzamiento: 2012, Capacidad Total: 4, Tripulantes Necesarios: 4
Nave Espacial: Zeus, Año de Creación: 2020, Año de Lanzamiento: 2022, Capacidad Total: 12, Tripulantes Necesarios: 4

----- MENÚ -----
1. Añadir naves espaciales
2. Mostrar naves cuya antigüedad sea superior a una dada
3. Ordenar naves por año de lanzamiento
4. Modificar capacidad total de naves que admiten pasajeros
5. Mostrar todas las naves espaciales registradas
6. Eliminar una nave espacial
7. Salir
Elige una opción: 2
Introduce la antigüedad mínima: 50
No se encontraron naves con antigüedad superior a 50

Ordenar naves por año de lanzamiento: Ordena y muestra las naves en orden descendente según el año de lanzamiento.

Modificar Capacidad Total de las naves que admiten Pasajeros: Recorremos nuestras naves seleccionando solo las que admiten Pasajeros. Por cada nave que cumpla lo anterior se mostrará toda su información y se le preguntará si desea cambiar la Capacidad Total de Personas que pueden viajar en la nave. Si la nueva capacidad es menor al Número de Tripulantes o no encontramos ninguna nave que admita Pasajeros, el programa debe lanzar un error.

Elige una opción: 4
Nave Espacial: Zeus, Año de Creación: 2020, Año de Lanzamiento: 2022, Capacidad Total: 12, Tripulantes Necesarios: 4
Desea cambiar la Capacidad Total de la nave?
no

----- MENÚ -----
1. Añadir naves espaciales
2. Mostrar naves cuya antigüedad sea superior a una dada
3. Ordenar naves por año de lanzamiento
4. Modificar capacidad total de naves que admiten pasajeros
5. Mostrar todas las naves espaciales registradas
6. Eliminar una nave espacial
7. Salir
Elige una opción: 4
Nave Espacial: Zeus, Año de Creación: 2020, Año de Lanzamiento: 2022, Capacidad Total: 12, Tripulantes Necesarios: 4
Desea cambiar la Capacidad Total de la nave?
si
Introduce la nueva capacidad para la nave Zeus: 2
Error: La nueva capacidad no puede ser menor que el número de tripulantes necesarios.

Mostrar todas las naves espaciales registradas.

Eliminar una nave espacial: Pediremos por pantalla el nombre de la nave espacial que queremos borrar y se eliminará. Una vez borrada, se compactará el array para no dejar huecos de memoria libres. Si se diera el caso, avisaríamos de que la nave a borrar no se ha encontrado.

Elige una opción: 6
Introduce el nombre de la nave que deseas eliminar: Zeus
No se encontró ninguna nave con ese nombre.

----- MENÚ -----
1. Añadir naves espaciales
2. Mostrar naves cuya antigüedad sea superior a una dada
3. Ordenar naves por año de lanzamiento
4. Modificar capacidad total de naves que admiten pasajeros
5. Mostrar todas las naves espaciales registradas
6. Eliminar una nave espacial
7. Salir
Elige una opción: 6
Introduce el nombre de la nave que deseas eliminar: ApoloII
Nave eliminada correctamente.

Salir del programa.

Nota: Controla que se informe al usuario, cuando sea necesario, que no se pueden realizar las opciones de menú del 2 a la 6, si no tenemos ninguna nave guardada.
*/

import java.time.LocalDate;
import java.util.Scanner;

public class NaveEspacialMain2 {

// MÉTODOS ESTÁTICOS

// contarNaves: recorre el array y cuenta las posiciones que no son null
	
	/*Recorre el array de principio a fin y cuenta cuántas posiciones no son null.
	 Devuelve ese número. Es la forma de saber cuántas naves hay registradas sin usar un contador externo.*/
    public static int contarNaves(NaveEspacial[] naves) {
        int total;
        int i;

        total = 0;
        for (i = 0; i < naves.length; i++) {
            if (naves[i] != null) {
                total++;
            }
        }
        return total;
    }

// buscarNave: devuelve el índice de la nave cuyo nombre coincide, o -1 si no existe
    /* el array buscando una nave cuyo nombre coincida (sin distinguir mayúsculas/minúsculas). Devuelve:
     * El índice donde está la nave si la encuentra.
     * -1 si no existe.
     * Se usa en anadirNaves (para detectar nombres repetidos) y en eliminarNave (para localizar la nave a borrar).*/
    
    public static int buscarNave(NaveEspacial[] naves, String nombre) {
        int i;
        boolean encontrada;

        encontrada = false;
        for (i = 0; i < naves.length && !encontrada; i++) {
            if (naves[i] != null && naves[i].getNombre().equalsIgnoreCase(nombre)) {
                encontrada = true;
            }
        }

        if (encontrada) {
            return i - 1;
        } else {
            return -1;
        }   
    }

// 1 Añadir naves espaciales
    /*Bucle while que permite añadir varias naves seguidas. En cada iteración:
     * Comprueba si ya hay 50 naves (límite).
     *Pide el nombre y comprueba que no esté repetido (con buscarNave).
     *Pide año de creación y año de lanzamiento (el de lanzamiento no puede ser anterior).
     *Pide capacidad total y tripulantes necesarios.
     *Crea el objeto NaveEspacial y lo guarda en la primera posición libre.
     *Pregunta si quieres seguir añadiendo.*/
    
    public static void anadirNaves(NaveEspacial[] naves, Scanner sc) {
        boolean seguirAñadiendo;
        String nombre;
        int anioCreacion;
        int anioLanzamiento;
        boolean anioValido;
        int capacidadTotal;
        int tripulantesNecesarios;
        String respuesta;
        int indice;
        int totalNaves;

        seguirAñadiendo = true;
        anioLanzamiento = 0;
        anioValido = false;

        while (seguirAñadiendo) {
            totalNaves = contarNaves(naves);

            if (totalNaves >= 50) {
                System.out.println("Error: Se ha alcanzado el límite máximo de 50 naves.");
                seguirAñadiendo = false;
            } else {
                System.out.print("Introduce el nombre de la nave: ");
                nombre = sc.nextLine();

                indice = buscarNave(naves, nombre);
                if (indice != -1) {
                    System.out.println("Ya existe una nave con ese nombre.");
                } else {
                    System.out.print("Introduce el año de creación: ");
                    anioCreacion = sc.nextInt();

                    while (!anioValido) {
                        System.out.print("Introduce el año de lanzamiento: ");
                        anioLanzamiento = sc.nextInt();

                        if (anioLanzamiento < anioCreacion) {
                            System.out.println("Error: El año de lanzamiento no puede ser anterior al año de creación.");
                        } else {
                            anioValido = true;
                        }
                    }

                    System.out.print("Introduce la capacidad total de personas: ");
                    capacidadTotal = sc.nextInt();

                    System.out.print("Introduce el número de tripulantes necesarios: ");
                    tripulantesNecesarios = sc.nextInt();
                    sc.nextLine();

                    naves[totalNaves] = new NaveEspacial(nombre, anioCreacion, anioLanzamiento, capacidadTotal, tripulantesNecesarios);
                    System.out.println("Nave añadida exitosamente.");
                }

                System.out.print("¿Quieres seguir introduciendo naves? (si/no): ");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("no")) {
                    seguirAñadiendo = false;
                }
            }
        }
    }

// 2 Mostrar naves cuya antigüedad sea superior o igual a una introducida
    /*Pide un número (antigüedad mínima). Recorre las naves y muestra solo las cuya antigüedad (año actual − año de lanzamiento) sea ≥ al número introducido.
      Si no hay ninguna que cumpla, lo indica.*/
    public static void mostrarNavesAntiguedad(NaveEspacial[] naves, Scanner sc) {
        int totalNaves;
        int antiguedadMinima;
        int anioActual;
        int encontradas;
        int i;
        int antiguedadNave;

        totalNaves = contarNaves(naves);

        if (totalNaves == 0) {
            System.out.println("Error: No hay naves registradas en el sistema.");
            return;
        }

        anioActual = LocalDate.now().getYear();
        encontradas = 0;

        System.out.print("Introduce la antigüedad mínima: ");
        antiguedadMinima = sc.nextInt();
        sc.nextLine();

        for (i = 0; i < totalNaves; i++) {
            antiguedadNave = naves[i].calcularAntiguedad(anioActual);
            if (antiguedadNave >= antiguedadMinima) {
                System.out.println(naves[i].toString());
                encontradas++;
            }
        }

        if (encontradas == 0) {
            System.out.println("No se encontraron naves con antigüedad superior o igual a " + antiguedadMinima);
        }
    }

// 3: Ordenar naves por año de lanzamiento (descendente)
    /*Ordena las naves por año de lanzamiento en orden descendente (la más reciente primero)
     usando el algoritmo de burbuja (comparación de vecinos e intercambio).
     Al terminar, imprime la lista ordenada.*/
    public static void ordenarNavesPorAnio(NaveEspacial[] naves) {
        int totalNaves;
        int i;
        int j;
        int k;
        NaveEspacial auxiliar;

        totalNaves = contarNaves(naves);

        if (totalNaves == 0) {
            System.out.println("Error: No hay naves registradas en el sistema.");
            return;
        }

        for (i = 0; i < totalNaves - 1; i++) {
            for (j = 0; j < totalNaves - i - 1; j++) {
                if (naves[j].getAnioLanzamiento() < naves[j + 1].getAnioLanzamiento()) {
                    auxiliar = naves[j];
                    naves[j] = naves[j + 1];
                    naves[j + 1] = auxiliar;
                }
            }
        }

        System.out.println("Naves ordenadas por año de lanzamiento (descendente):");
        for (k = 0; k < totalNaves; k++) {
            System.out.println(naves[k].toString());
        }
    }

// 4: Modificar capacidad total de naves que admiten pasajeros
    /*Recorre las naves y se queda solo con las que admiten pasajeros (capacidadTotal > tripulantesNecesarios).
     * Para cada una:
     * Muestra sus datos.
     * Pregunta si quieres cambiar la capacidad.
     * Si es "sí", pide la nueva capacidad y comprueba que no sea menor que los tripulantes necesarios.
     * Si es válida, actualiza con setCapacidadTotal.
     * Si no hay ninguna nave que admita pasajeros, lo indica.*/
    
    public static void modificarCapacidadPasajeros(NaveEspacial[] naves, Scanner sc) {
        int totalNaves;
        int navesPasajeros;
        int i;
        String respuesta;
        boolean capacidadValida;
        int nuevaCapacidad;

        totalNaves = contarNaves(naves);

        if (totalNaves == 0) {
            System.out.println("Error: No hay naves registradas en el sistema.");
            return;
        }

        navesPasajeros = 0;

        for (i = 0; i < totalNaves; i++) {
            if (naves[i].admitePasajeros()) {
                navesPasajeros++;
                System.out.println(naves[i].toString());
                System.out.print("¿Desea cambiar la capacidad total de la nave? (si/no): ");
                respuesta = sc.nextLine();

                if (respuesta.equalsIgnoreCase("si")) {
                    capacidadValida = false;
                    while (!capacidadValida) {
                        System.out.print("Introduce la nueva capacidad para la nave " + naves[i].getNombre() + ": ");
                        nuevaCapacidad = sc.nextInt();
                        sc.nextLine();

                        if (nuevaCapacidad < naves[i].getTripulantesNecesarios()) {
                            System.out.println("Error: La nueva capacidad no puede ser menor que el número de tripulantes necesarios.");
                        } else {
                            naves[i].setCapacidadTotal(nuevaCapacidad);
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

// 5 Mostrar todas las naves espaciales registradas
    /*Recorre todas las naves registradas y las imprime con toString()*/
    public static void mostrarTodasLasNaves(NaveEspacial[] naves) {
        int totalNaves;
        int i;

        totalNaves = contarNaves(naves);

        if (totalNaves == 0) {
            System.out.println("Error: No hay naves registradas en el sistema.");
            return;
        }

        for (i = 0; i < totalNaves; i++) {
            System.out.println(naves[i].toString());
        }
    }

// 6 Eliminar una nave espacial (compactando el array)
    /*Pide el nombre de la nave a eliminar.
     * Busca su índice con buscarNave.
     * Si no existe, muestra error.
     * Si existe, desplaza todas las naves que están a su derecha una posición hacia la izquierda
     * (compactación) y pone null en la última posición.*/
    
    public static void eliminarNave(NaveEspacial[] naves, Scanner scanner) {
        int totalNaves;
        String nombreBorrar;
        int indiceEncontrado;
        int j;

        totalNaves = contarNaves(naves);

        if (totalNaves == 0) {
            System.out.println("Error: No hay naves registradas en el sistema.");
            return;
        }

        System.out.print("Introduce el nombre de la nave que deseas eliminar: ");
        nombreBorrar = scanner.nextLine();

        indiceEncontrado = buscarNave(naves, nombreBorrar);

        if (indiceEncontrado == -1) {
            System.out.println("No se encontró ninguna nave con ese nombre.");
        } else {
            for (j = indiceEncontrado; j < totalNaves - 1; j++) {
                naves[j] = naves[j + 1];
            }
            naves[totalNaves - 1] = null;
            System.out.println("Nave eliminada correctamente.");
        }
    }

// MAIN-------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc;
        NaveEspacial[] naves;
        int opcion;

        sc = new Scanner(System.in);
        naves = new NaveEspacial[50];

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
            sc.nextLine();

            switch (opcion) {
                case 1:
                    anadirNaves(naves, sc);
                    break;
                case 2:
                    mostrarNavesAntiguedad(naves, sc);
                    break;
                case 3:
                    ordenarNavesPorAnio(naves);
                    break;
                case 4:
                    modificarCapacidadPasajeros(naves, sc);
                    break;
                case 5:
                    mostrarTodasLasNaves(naves);
                    break;
                case 6:
                    eliminarNave(naves, sc);
                    break;
                case 7:
                    System.out.println("¡Hasta pronto :-)! Finalizando el programa de exploración espacial.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduce un número del 1 al 7.");
                    break;
            }

        } while (opcion != 7);

        sc.close();
    }
}   