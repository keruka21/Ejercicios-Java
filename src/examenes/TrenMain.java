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
               
               System.out.print("Introduce la referencia: ");
               referencia=sc.nextLine();
                
                System.out.print("Introduce el número de asientos ocupados: ");
                asientosOcupados=sc.nextInt();
                
                System.out.print("Introduce minutos de duración: ");
                minDuracion = sc.nextDouble();
                
                System.out.print("Introduce km recorridos: ");
                kmRecorridos = sc.nextDouble();
            }
            System.out.print("¿Quieres seguir introduciendo trenes? (si/no): ");
            respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                seguirAniadiendo = false;
            }
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
                	aniadirTren(aTrenes, sc);
                    break;
                case 2:
                    mostrarTrenesSuperanVel(aTrenes);
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
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