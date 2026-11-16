package examenes;

/*Una vez creada la clase anterior y utilizando cuando se precise, los métodos en ella implementados, vamos a diseñar
un programa que gestione todos los trenes con salida desde Bilbao.
El programa tendrá un menú repetitivo como se especifica a continuación: ¡
1. Introducir los trenes.
Podemos introducir hasta 30 trenes, pero no tenemos que introducirlos todos a la vez. Controlar que no se
metan más de 30.
2. Mostrar los trenes que superen una velocidad dada.
Pediremos por pantalla la velocidad. Vamos a mostrar todos los trenes cuya velocidad sea superior a la
introducida. De cada tren solo queremos visualizar la información de su referencia y velocidad.
Si no existe ningún tren que supere dicha velocidad, mostraremos un mensaje informando de este hecho.
3. Ordenar los trenes de cercanías por duración del viaje. 
Ordenamos los trenes por duración del viaje de menor a mayor, y mostraremos solo los que son de Cercanías.
4. Reserva de asientos. 
Se pide la referencia del tren, si existe y no está lleno, se le pedirá al usuario el no de asientos que quiere reservar.
Se le indicará si es o no posible (en función de los asientos disponibles en ese momento) y si todo es correcto, se
actualizará la información de los asientos ocupados del tren. Mensaje de aviso si no se puede llevar a cabo la
reserva por no encontrarse el tren buscado o estar lleno.
5. Mostrar todos los trenes que se han introducido. 
Se ha de mostrar toda la información respectiva al tren.
6. Salir
Nota: En todas las opciones a partir de la 1, controlar previamente si hay o no trenes introducidos.*/


import java.util.Scanner;

public class TrenMain {

// MÉTODOS ESTÁTICOS

// contarTrenes: recorre el array y cuenta las posiciones que no son null
    public static int contarTrenes(Tren[] aTrenes) {
        int total;
        int i;

        total = 0;
        for (i = 0; i < aTrenes.length; i++) {
            if (aTrenes[i] != null) {
                total++;
            }
        }
        return total;
    }
    
//6 SALIR
    public static void salir() {
       System.out.println("Saliendo del programa. ¡Hasta pronto! :-)");
    }
    

//1. Introducir los trenes.
    /*Podemos introducir hasta 30 trenes, pero no tenemos que introducirlos todos a la vez. Controlar que no se
    metan más de 30.*/
    
    public static void aniadirTren(Tren[] aTrenes, Scanner sc) {
        boolean seguirAniadiendo = true;
        String tipo;
    	String referencia;
    	int asientosOcupados = 0;
    	double kmRecorridos = 0;
    	double minDuracion = 0;
        String respuesta;
        int indice;
        int totalTrenes;


        while (seguirAniadiendo) {
            totalTrenes = contarTrenes(aTrenes);

            if ( totalTrenes >= 30) {
                System.out.println("Error: Se ha alcanzado el límite máximo de 30 trenes.");
                seguirAniadiendo = false;
            } else {
                System.out.print("Introduce el tipo del tren: ");
               tipo = sc.nextLine();
               tipo = validarTipo(respuesta);
                System.out.print("Introduce la referencia: ");
                referencia=sc.nextLine();
                
                System.out.print("Introduce el número de asientos ocupados: ");
                asientosOcupados=sc.nextInt();
                
                System.out.print("Introduce minutos de duración: ");
                minDuracion = sc.nextDouble();
                
                System.out.print("Introduce km recorridos: ");
                kmRecorridos = sc.nextDouble();
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


// MAIN-------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tren[] aTrenes = new Tren[30];
        int opcion;


        do {
            System.out.println("\n----- MENÚ DE MISIÓN ESPACIAL -----");
            System.out.println("1. Introducir los trenes.");
            System.out.println("2. Mostrar los trenes que superen una velocidad dada.");
            System.out.println("3. Ordenar los trenes de cercanías por duración del viaje. ");
            System.out.println("4. Reserva de asientos.");
            System.out.println("5. Mostrar todos los trenes que se han introducido. ");
            System.out.println("6. Salir");
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
                    salir();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduce un número del 1 al 6.");
                    break;
            }

        } while (opcion != 6);

        sc.close();
    }
}   