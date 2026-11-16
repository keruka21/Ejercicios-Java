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


//MÉTODOS ESTÁTICOS AUXILIARES


/*contarTrenes: recorre el array completo y cuenta cuántas posiciones
tienen un objeto Tren guardado (es decir, son distintas de null).*/
    public static int contarTrenes(Tren[] aTrenes) {
        int total;
        int i;

        total = 0; // Inicializamos el contador a 0
        for (i = 0; i < aTrenes.length; i++) {
            if (aTrenes[i] != null) { // Si la casilla no está vacía, sumamos 1
                total++;
            }
        }
        return total;
    }

/*buscarTren: busca un tren por su referencia dentro del array.
 Devuelve la posición  donde se encuentra, o -1 si no existe.*/
    public static int buscarTren(Tren[] aTrenes, String referencia) {
        int i;
        boolean encontrado;

        encontrado = false;
        // Recorremos el array mientras no lleguemos al final y no lo hayamos encontrado
        for (i = 0; i < aTrenes.length && !encontrado; i++) {
            if (aTrenes[i] != null && aTrenes[i].getReferencia().equalsIgnoreCase(referencia)) {
                encontrado = true; // Marcamos que ya lo hemos localizado
            }
        }

        // Si se encontró, el bucle incrementó 'i' una vez más al salir, por eso restamos 1
        if (encontrado) {
            return i - 1;
        } else {
            return -1;
        }
    }


//OPCIONES DEL MENÚ

//1: Introducir los trenes.
     /* Permite añadir trenes de uno en uno sin superar el máximo de 30.*/
    public static void aniadirTren(Tren[] aTrenes, Scanner sc) {
        boolean seguirAniadiendo;
        String tipo;
        String referencia;
        int asientosOcupados;
        double kmRecorridos;
        double minDuracion;
        String respuesta;
        int indice;
        int totalTrenes;

        seguirAniadiendo = true; // Controla si el usuario quiere seguir metiendo trenes

        while (seguirAniadiendo) {
            totalTrenes = contarTrenes(aTrenes); // Comprobamos cuántos trenes hay actualmente

            if (totalTrenes >= 30) {
                System.out.println("Error: Se ha alcanzado el límite máximo de 30 trenes.");
                seguirAniadiendo = false; // Forzamos la salida del bucle al estar lleno
            } else {
                System.out.print("Introduce la referencia: ");
                referencia = sc.nextLine();

                // Comprobamos que no exista ya otro tren con la misma referencia
                indice = buscarTren(aTrenes, referencia);

                if (indice != -1) {
                    System.out.println("Error: Ya existe un tren con esa referencia.");
                } else {
                    System.out.print("Introduce el tipo del tren (Cercanías, Ave, Mercancías): ");
                    tipo = sc.nextLine();

                    // Validamos que los asientos ocupados estén dentro del rango permitido (0 a 400)
                    do {
                        System.out.print("Introduce el número de asientos ocupados (0 - 400): ");
                        asientosOcupados = sc.nextInt();
                        if (asientosOcupados < 0 || asientosOcupados > 400) {
                            System.out.println("Error: Los asientos deben estar entre 0 y 400.");
                        }
                    } while (asientosOcupados < 0 || asientosOcupados > 400);

                    System.out.print("Introduce km recorridos: ");
                    kmRecorridos = sc.nextDouble();

                    System.out.print("Introduce minutos de duración: ");
                    minDuracion = sc.nextDouble();
                    sc.nextLine(); // Limpiamos el salto de línea pendiente del buffer

                    // Creamos el objeto Tren y lo guardamos en la primera posición libre (totalTrenes)
                    aTrenes[totalTrenes] = new Tren(tipo, referencia, asientosOcupados, kmRecorridos, minDuracion);
                    System.out.println("Tren añadido correctamente.");
                }

                // Verificamos si aún queda espacio antes de preguntar si desea continuar
                if (contarTrenes(aTrenes) < 30) {
                    System.out.print("¿Quieres seguir introduciendo trenes? (si/no): ");
                    respuesta = sc.nextLine();
                    if (respuesta.equalsIgnoreCase("no")) {
                        seguirAniadiendo = false;
                    }
                } else {
                    System.out.println("Se ha completado el máximo de 30 trenes.");
                    seguirAniadiendo = false;
                }
            }
        }
    }

/*2: Mostrar los trenes que superen una velocidad dada.
     * Muestra solo referencia y velocidad, o un aviso si ninguno la supera.*/
    public static void mostrarTrenesSuperanVel(Tren[] aTrenes, Scanner sc) {
        int totalTrenes;
        int i;
        double velMinima;
        double velActual;
        boolean haySuperiores= false; // Bandera para saber si al menos un tren cumple la condición;

        totalTrenes = contarTrenes(aTrenes);

        // Control previo: comprobar si hay trenes introducidos
        if (totalTrenes == 0) {
            System.out.println("Error: No hay trenes introducidos.");
        } else {
            System.out.print("Introduce la velocidad mínima (Km/h): ");
            velMinima = sc.nextDouble();
            sc.nextLine(); // Limpiamos el buffer

            // Recorremos solo las posiciones ocupadas del array
            for (i = 0; i < totalTrenes; i++) {
                velActual = aTrenes[i].obtenerVelocidadTotal(); // Calculamos velocidad con el método de Tren
                if (velActual > velMinima) {
                    System.out.println("Referencia: " + aTrenes[i].getReferencia() + " - Velocidad: " + velActual + " Km/h");
                    haySuperiores = true;
                }
            }

            // Si tras recorrer todos ninguno superó la velocidad, mostramos aviso
            if (!haySuperiores) {
                System.out.println("No existe ningún tren que supere los " + velMinima + " Km/h.");
            }
        }
    }

//3: Ordenar los trenes de cercanías por duración del viaje.
    /*Ordena todo el array de menor a mayor duración y muestra solo los de Cercanías.*/
    public static void ordenarYMostrarCercanias(Tren[] aTrenes) {
        int totalTrenes;
        int i;
        int j;
        Tren aux; // Variable auxiliar para intercambiar objetos Tren
        boolean hayCercanias;

        totalTrenes = contarTrenes(aTrenes);

        // Control previo: comprobar si hay trenes introducidos
        if (totalTrenes == 0) {
            System.out.println("Error: No hay trenes introducidos.");
        } else {
            // Ordenación por el método de la burbuja de menor a mayor duración
            for (i = 0; i < totalTrenes - 1; i++) {
                for (j = 0; j < totalTrenes - 1 - i; j++) {
                    // Si el tren actual dura más que el siguiente, los intercambiamos
                    if (aTrenes[j].getMinDuracion() > aTrenes[j + 1].getMinDuracion()) {
                        aux = aTrenes[j];
                        aTrenes[j] = aTrenes[j + 1];
                        aTrenes[j + 1] = aux;
                    }
                }
            }

            hayCercanias = false;
            System.out.println("--- TRENES DE CERCANÍAS ORDENADOS POR DURACIÓN ---");
            // Recorremos el array ya ordenado y filtramos por tipo "Cercanías"
            for (i = 0; i < totalTrenes; i++) {
                if ("Cercanías".equalsIgnoreCase(aTrenes[i].getTipo())) {
                    aTrenes[i].mostrarDatos();
                    hayCercanias = true;
                }
            }

            if (!hayCercanias) {
                System.out.println("No hay trenes de Cercanías registrados.");
            }
        }
    }


//4: Reserva de asientos.
     /* Busca un tren por referencia, comprueba si tiene plazas libres y actualiza los asientos.*/
    public static void reservarAsientos(Tren[] aTrenes, Scanner sc) {
        int totalTrenes;
        String referencia;
        int pos;
        int disponibles;
        int aReservar;

        totalTrenes = contarTrenes(aTrenes);

        // Control previo: comprobar si hay trenes introducidos
        if (totalTrenes == 0) {
            System.out.println("Error: No hay trenes introducidos.");
        } else {
            System.out.print("Introduce la referencia del tren: ");
            referencia = sc.nextLine();

            pos = buscarTren(aTrenes, referencia); // Buscamos la posición del tren

            if (pos == -1) {
                System.out.println("Aviso: No se ha encontrado ningún tren con esa referencia.");
            } else if (aTrenes[pos].trenLleno()) { // Usamos el método trenLleno() de la clase Tren
                System.out.println("Aviso: El tren está lleno, no se pueden reservar asientos.");
            } else {
                // Calculamos los asientos libres restando los ocupados al máximo (400)
                disponibles = 400 - aTrenes[pos].getAsientosOcupados();
                System.out.println("Asientos disponibles: " + disponibles);
                System.out.print("Introduce el nº de asientos que quieres reservar: ");
                aReservar = sc.nextInt();
                sc.nextLine(); // Limpiamos el buffer

                if (aReservar <= 0) {
                    System.out.println("Error: El número de asientos debe ser mayor que 0.");
                } else if (aReservar <= disponibles) {
                    // Sumamos los nuevos asientos reservados a los que ya estaban ocupados
                    aTrenes[pos].setAsientosOcupados(aTrenes[pos].getAsientosOcupados() + aReservar);
                    System.out.println("Reserva realizada. Asientos ocupados actuales: " + aTrenes[pos].getAsientosOcupados());
                } else {
                    System.out.println("No es posible realizar la reserva. Solo quedan " + disponibles + " asientos libres.");
                }
            }
        }
    }


//5: Mostrar todos los trenes que se han introducido.------------------------------------------------------------

    public static void mostrarTodosLosTrenes(Tren[] aTrenes) {
        int totalTrenes;
        int i;

        totalTrenes = contarTrenes(aTrenes);

        //comprobar si hay trenes introducidos
        if (totalTrenes == 0) {
            System.out.println("Error: No hay trenes introducidos.");
        } else {
            System.out.println("--LISTA DE TODOS LOS TRENES---");
            for (i = 0; i < totalTrenes; i++) {
                aTrenes[i].mostrarDatos(); // Llamamos al método de Tren para imprimir sus datos
                System.out.println("---------------------------");
            }
        }
    }


//6: Mensaje de despedida al salir del programa.---------------------------------------------------------------------

    public static void salir() {
        System.out.println("Saliendo del programa. ¡Hasta pronto! :-)");
    }


//MAIN-----------------------------------------------------------------------------------

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tren[] aTrenes = new Tren[30];
        int opcion;

        do {
            System.out.println("\n----- GESTIÓN DE TRENES (SALIDA DESDE BILBAO) -----");
            System.out.println("1. Introducir los trenes.");
            System.out.println("2. Mostrar los trenes que superen una velocidad dada.");
            System.out.println("3. Ordenar los trenes de cercanías por duración del viaje.");
            System.out.println("4. Reserva de asientos.");
            System.out.println("5. Mostrar todos los trenes que se han introducido.");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); //Limpiamos buffer
            switch (opcion) {
                case 1:
                    aniadirTren(aTrenes, sc);
                    break;
                case 2:
                    mostrarTrenesSuperanVel(aTrenes, sc);
                    break;
                case 3:
                    ordenarYMostrarCercanias(aTrenes);
                    break;
                case 4:
                    reservarAsientos(aTrenes, sc);
                    break;
                case 5:
                    mostrarTodosLosTrenes(aTrenes);
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