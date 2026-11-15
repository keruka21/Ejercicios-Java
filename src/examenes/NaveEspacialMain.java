package examenes;

/*
 * ========================================================================================
 * ENUNCIADO DEL EXAMEN: GESTIÓN DE NAVES ESPACIALES
 * ========================================================================================
 *Programa principal (Gestión de Misión Espacial):
 *   - Diseña un programa que gestione una misión de exploración espacial con un máximo de 50 naves.
 *   - El programa tendrá un menú repetitivo (mediante do-while y switch) con opciones 
 *     realizadas a través de métodos estáticos situados por encima del main:
 *       1. Añadir naves espaciales: Controlar límite de 50 naves, nombre único y que 
 *          el año de lanzamiento no sea anterior al de creación.
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
 *   - NORMAS DE ESTILO: Sin variables globales, sin usar break o return para salir 
 *     de los bucles (usar variables booleanas/centinela), variables declaradas al inicio 
 *     de cada método, y métodos estáticos colocados por encima de main.
 * ========================================================================================
 */

import java.time.LocalDate;
import java.util.Scanner;

public class NaveEspacialMain {
	
	//0 para saber si hay naves en el array
	/*public static boolean hayNaves(int contadorNaves) {
    return contadorNaves > 0;
    }
    //ya no hace falta la variable "boolean hayNaves;" de main
    //en los cases ya no seria "hayNaves = (contadorNaves > 0);" sería "hayNaves = hayNaves(contadorNaves);"
    */
	
	/*Para no repetir código hacer método buscarNave
	 * y contarNave*/
	
	//MÉTODOS ESTÁTICOS

    //1 Añadir naves espaciales---------------------------------------------------------------------------------------------------------
    public static int anadirNaves(NaveEspacial[] naves, int contadorNaves, Scanner sc) {
    	//devuelve int contadorNaves a main para tener actualizado el número de naves
        boolean seguirAñadiendo; //bandera, controlar el bucle while para decidir si seguir introduciendo más naves o volver al menú principal
        String nombre; //guarda temporalmente el string introducido por teclado con el nombre de la nave que se quiere registrar
        boolean nombreRepetido; //bandera booleana.true = el nombre que acaba de escribir el usuario ya existe
        int i;
        int anioCreacion;
        int anioLanzamiento;
        boolean anioValido; //el programa repetirá la petición del año de lanzamiento si se pone un año anterior al de creación
        int capacidadTotal;
        int tripulantesNecesarios;
        String respuesta; //"si" o "no" para saber si desea continuar añadiendo otra nave o finalizar.

        /*variable centinela/bandera/flag: variable booleana que cambia de valor para avisar de que un evento ha ocurrido
        o para controlar el estado de un bucle.*/
        
        //iniciaizar las variables
        seguirAñadiendo = true; //false cuando el array se llene
        anioLanzamiento = 0; 
        anioValido = false; //true si anioLanzamiento < anioCreacion
        
        while (seguirAñadiendo) { //mientras seguirAñadiendo sea true haz:
            if (contadorNaves >= 50) {
                System.out.println("Error: Se ha alcanzado el límite máximo de 50 naves.");
                seguirAñadiendo = false; //sale del bucle
            } else {
                System.out.print("Introduce el nombre de la nave: ");
                nombre = sc.nextLine();
                
                //comprobar si el nombre está repetido
                nombreRepetido = false;
                for (i = 0; i < contadorNaves; i++) {
                    if (naves[i].getNombre().equalsIgnoreCase(nombre)) {
                        nombreRepetido = true;
                    }
                }
                
                if (nombreRepetido) {
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
                    
                    naves[contadorNaves] = new NaveEspacial(nombre, anioCreacion, anioLanzamiento, capacidadTotal, tripulantesNecesarios);
                    contadorNaves++; //cuando termina de recoger los datos de una nave cuenta que hay una nave más en el array
                    System.out.println("Nave añadida exitosamente.");
                }
                
                System.out.print("¿Quieres seguir introduciendo naves? (si/no): ");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("no")) {
                    seguirAñadiendo = false;
                }
            }
        }
        return contadorNaves;
    }

    //2 Mostrar naves cuya antigüedad sea superior o igual a una introducida----------------------------------------------------------------------
    public static void mostrarNavesAntiguedad(NaveEspacial[] naves, int contadorNaves, Scanner sc) {
        int antiguedadMinima;
        int anioActual; //guarda el año actual obtenido mediante LocalDate.now().getYear())
        int encontradas; //contador de control. va sumando uno cada vez que una nave cumple con el requisito de antigüedad
        int i;
        int antiguedadNave; //almacena temporalmnte el resultado de calcular la antigüedad de la nave actual 
     
        //inicializar variables
        anioActual = LocalDate.now().getYear();
        encontradas = 0;

        System.out.print("Introduce la antigüedad mínima: ");
        antiguedadMinima = sc.nextInt();
        sc.nextLine();
        
        //recorrer las naves registradas
        for (i = 0; i < contadorNaves; i++) {
        	/*llama al método calcularAntiguedad(anioActual)) del objeto NaveEspacial
        	para poder compararla directamente con la antiguedadMinima introducida por el usuario*/
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

//3: Ordenar naves por año de lanzamiento (descendente)--------------------------------------------------------------------------
    public static void ordenarNavesPorAnio(NaveEspacial[] naves, int contadorNaves) {
        int i; //índice principal para el bucle externo. Controla cuántas pasadas
        //o iteraciones completas se van realizando a lo largo del array de naves.
        int j; //índice utilizado en el bucle interno. 
        //Sirve para comparar elementos adyacentes (es decir, la posición actual j con la siguiente j + 1) e ir desplazando los valores según corresponda.
        NaveEspacial auxiliar;//es una variable temporal de tipo NaveEspacial.
        //sirve como un espacio de almacenamiento temporal para realizar el intercambio (swap) de posiciones entre dos naves cuando se detecta que están en el orden incorrecto
        int k; //índice para un bucle for posterior, cuya única misión es recorrer de principio a fin el array 
        //(desde la primera posición hasta contadorNaves) para mostrar en la consola la lista ya ordenada de manera descendente según su año de lanzamiento.

       
        //burbuja
        for (i = 0; i < contadorNaves - 1; i++) {
            for (j = 0; j < contadorNaves - i - 1; j++) {
                if (naves[j].getAnioLanzamiento() < naves[j + 1].getAnioLanzamiento()) {
                    auxiliar = naves[j];
                    naves[j] = naves[j + 1];
                    naves[j + 1] = auxiliar;
                }
            }
        }
        
        System.out.println("Naves ordenadas por año de lanzamiento (descendente):");
        for (k = 0; k < contadorNaves; k++) {
            System.out.println(naves[k].toString());
        }
    }

//4: Modificar capacidad total de naves que admiten pasajeros--------------------------------------------------------------------
    public static void modificarCapacidadPasajeros(NaveEspacial[] naves, int contadorNaves, Scanner sc) {
        int navesPasajeros;//contador auxiliar, va sumando cada vez que el bucle encuentra una nave 
        //que cumple con la condición de admitir pasajeros (admitePasajeros()
        int i;
        String respuesta;//"si" o "no"
        boolean capacidadValida;//flag, controla el bucle de validación de la nueva capacidad, 
        //true cuando se introduce una cifra correcta, permitiendo salir del bucle  
        int nuevaCapacidad;//nueva capacidad total que se le quiere dar a la nave seleccionada

        navesPasajeros = 0;
        
        // Bucle for para recorrer las naves
        for (i = 0; i < contadorNaves; i++) {
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

//5 Mostrar todas las naves espaciales registradas-------------------------------------------------------------
    public static void mostrarTodasLasNaves(NaveEspacial[] naves, int contadorNaves) {
        int i;

        for (i = 0; i < contadorNaves; i++) {
            System.out.println(naves[i].toString());
        }
    }

//6 Eliminar una nave espacial (compactando el array)----------------------------------------------------------
   
    public static int eliminarNave(NaveEspacial[] naves, int contadorNaves, Scanner scanner) {
        String nombreBorrar; //nombre de la nave espacial que se quiere eliminar
        int indiceEncontrado;//guarda la posición donde se encuentra la nave que coincide con el nombre que se quiere borrar
        boolean encontrada; //flag
        int i;
        int j; //variable de control para compactación del array. Desplaza todos los elementos una posición hacia la izquierda a partir del hueco que ha dejado la nave eliminada, asegurando que no queden huecos libres en medio del array.
        
        //inicializamos variables
        indiceEncontrado = -1; //-1 es un valor de índice imposible en un array. íncide de entrada que todavía no ha sido localizada
        encontrada = false; //empieza en false y cambia a true en el momento exacto en que el bucle encuentra la nave buscada

        System.out.print("Introduce el nombre de la nave que deseas eliminar: ");
        nombreBorrar = scanner.nextLine();
        
        // Bucle for para buscar el índice de la nave sin usar break
        for (i = 0; i < contadorNaves; i++) {
            if (!encontrada && naves[i].getNombre().equalsIgnoreCase(nombreBorrar)) {
                indiceEncontrado = i;
                encontrada = true;
            }
        }
        
        if (!encontrada) {
            System.out.println("No se encontró ninguna nave con ese nombre.");
        } else {
            // Bucle for para compactar el array desplazando los elementos
            for (j = indiceEncontrado; j < contadorNaves - 1; j++) {
                naves[j] = naves[j + 1];
            }
            naves[contadorNaves - 1] = null;
            contadorNaves--;
            System.out.println("Nave eliminada correctamente.");
        }
        
        return contadorNaves;
    }

//MAIN--------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc;
        NaveEspacial[] naves; //array que permite guardar hasta 50 objetos de tipo NaveEspacial
        /*naves[0] = nave1;
         *naves[1] = nave2;
         *naves[2] = nave3;
         *etc...*/
        int contadorNaves; //acumulativa para saber cuantas naves vamos introduciendo y para saber en qué posición debes guardar la siguiente nave
        /*naves[contadorNaves] = nuevaNave;
         * contadorNaves++;*/
        int opcion;
        boolean hayNaves; //comprobar si existe al menos una nave registrada. true=hay naves. false=todavía no hay ninguna.
        //ej: hayNaves = contadorNaves > 0;
        
        //inicializar variables
        sc = new Scanner(System.in);
        naves = new NaveEspacial[50];
        contadorNaves = 0;
        
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
            sc.nextLine(); // limpia el buffer
            
            hayNaves = (contadorNaves > 0);
            
            switch (opcion) {
                case 1:
                    contadorNaves = anadirNaves(naves, contadorNaves, sc);
                    /*enviamos contadorNaves al método estático que nos devolverá un int al main
                     * return contadorNaves → devuelve el contador actualizado.
                     * contadorNaves = ... → recoge ese valor y lo guarda en el main.*/
                    break;
                case 2:
                    if (hayNaves) {
                        mostrarNavesAntiguedad(naves, contadorNaves, sc);
                    } else {
                        System.out.println("Error: No hay naves registradas en el sistema.");
                    }
                    break;
                case 3:
                    if (hayNaves) {
                        ordenarNavesPorAnio(naves, contadorNaves);
                    } else {
                        System.out.println("Error: No hay naves registradas en el sistema.");
                    }
                    break;
                case 4:
                    if (hayNaves) {
                        modificarCapacidadPasajeros(naves, contadorNaves, sc);
                    } else {
                        System.out.println("Error: No hay naves registradas en el sistema.");
                    }
                    break;
                case 5:
                    if (hayNaves) {
                        mostrarTodasLasNaves(naves, contadorNaves);
                    } else {
                        System.out.println("Error: No hay naves registradas en el sistema.");
                    }
                    break;
                case 6:
                    if (hayNaves) {
                        contadorNaves = eliminarNave(naves, contadorNaves, sc);
                    } else {
                        System.out.println("Error: No hay naves registradas en el sistema.");
                    }
                    break;
                case 7:
                    System.out.println("¡Hasta luego! Finalizando el programa de exploración espacial.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduce un número del 1 al 7.");
                    break;
            }
            
        } while (opcion != 7);
        
        sc.close();
    }
}
