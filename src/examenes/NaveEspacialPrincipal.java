package examenes;

import java.util.Scanner;
import java.time.LocalDate;

public class NaveEspacialPrincipal {
//-------------------MÉTODOS ESTÁTICOS------------------------------------	

//MÉTODO AUXILIAR CONTAR
	//si en el array de naves no hay nulls cuenta cuantos elementos hay en el array
	
	public static int contarNaves(NaveEspacial[] aNaves) {
		int contadorNaves = 0;
		
		for(int i=0; i<aNaves.length; i++) {
			if(aNaves[i] !=null) {
				contadorNaves++;
			}
		}
		return contadorNaves; //devuelve cuantas naves hay en el array
	}

//MÉTODO AUXILIAR BUSCAR
	
	public static int buscarNave(NaveEspacial[] aNaves, String nombre) {
		boolean encontrada = false;
		int posicion=0;
		
		for (int i=0; i < aNaves.length && !encontrada; i++) {
			if(aNaves[posicion] != null && aNaves[i].getNombre().equalsIgnoreCase(nombre)) {
				encontrada = true;
			}
		}
		if (encontrada) {
			return posicion-1;
		}else {
			return -1;
		}
	}
	
	
//7 SALIR
	public static void salir() {
		System.out.println("Saliendo del programa. Hasta pronto :-)");
		}
	
//1 Añadir naves espaciales
	
	public static void aniadirNaves(NaveEspacial[] aNaves, Scanner sc) {
		boolean continuarAniadiendo = true;
		boolean anioValido = false;
		String nombre, respuesta;
		int anioCreacion = 0, capacidadTotal, tripulantesNecesarios, posicion, totalNaves;
		int anioLanzamiento = 0;
		

		while(continuarAniadiendo) {
			totalNaves = contarNaves(aNaves); //método auxiliar estatico
			
			if (totalNaves >= 50) {
				System.out.println("Error: No hay espacio (Límite máximo de 50 naves).");
				continuarAniadiendo = false; //salimos del bucle
			}else {
				System.out.print("Introduce el nombre de la nave: ");
                nombre = sc.nextLine();
                
                posicion = buscarNave(aNaves, nombre);
                if (posicion != -1) {
                	System.out.println("Ya existe una nave con ese nombre.");
                }else {
                	System.out.print("Introduce el año de creación: ");
                	anioCreacion = sc.nextInt();
                    
                    //validacion
                    while(!anioValido) {
                    	System.out.print("Introduce el año de lanzamiento: ");
                    	anioLanzamiento = sc.nextInt();
                    	
                    	if(anioLanzamiento < anioCreacion) {
                    		System.out.println("Error: El año de lanzamiento no puede ser anterior al año de creación.");
                    	} else {
                    		anioValido = true;
                    	}
                    
                    }//end validacion año de creación
                }
                
                System.out.print("Introduce la capacidad total de personas: ");
                capacidadTotal = sc.nextInt();

                System.out.print("Introduce el número de tripulantes necesarios: ");
                tripulantesNecesarios = sc.nextInt();
                sc.nextLine();

                aNaves[totalNaves] = new NaveEspacial(nombre, anioCreacion, anioLanzamiento, capacidadTotal, tripulantesNecesarios);
                System.out.println("Nave añadida exitosamente.");
			}
			System.out.print("¿Quieres seguir introduciendo naves? (si/no): ");
            respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
            	continuarAniadiendo = false;
            }
		}			
	}
	
//2 Mostrar naves cuya antigüedad sea superior o igual a una introducida
	 public static void mostrarNavesAntiguedad(NaveEspacial[] naves, Scanner sc) {
		//variables
		int totalNaves = contarNaves(naves);
		int antiguedadMin;
		int anioActual=LocalDate.now().getYear();
		int encontradas = 0;
		int antiguedadNave;
		
		System.out.print("Introduce la antigüedad mínima: ");
        antiguedadMin = sc.nextInt();
        
        for (int i=0; i < totalNaves; i++) {
        	if(antiguedadNave >= antiguedadMin){
        		
        	}
        }

		
		
		
	 }


//MAIN-----------------------------------------------------------------------
	public static void main(String[] args) {
		//variables
		Scanner sc = new Scanner(System.in);
		NaveEspacial[] aNaves = new NaveEspacial[50];
		int opcion;
		
		do {
			System.out.println("\n-----------MENÚ---------------");
			System.out.println("1. Añadir naves espaciales.");
			System.out.println("2. Mostrar naves cuya antigüedad sea superior a una dada.");
			System.out.println("3.Ordenar naves por año de lanzamiento.");
			System.out.println("4. Modificar Capacidad Total de las naves que admiten Pasajeros.");
			System.out.println("5. Mostrar todas las naves espaciales registradas.");
			System.out.println("6. Eliminar una nave espacial.");
			System.out.println("7. Salir del programa");
			System.out.println("¿Qué opción quieres hacer?");
			opcion = sc.nextInt();
			
			switch (opcion) {
	            case 1:
	                aniadirNaves(aNaves, sc);
	                break;
	            case 2:
	               // mostrarNavesAntiguedad(naves, sc);
	                break;
	            case 3:
	               // ordenarNavesPorAnio(naves);
	                break;
	            case 4:
	                //modificarCapacidadPasajeros(naves, sc);
	                break;
	            case 5:
	               // mostrarTodasLasNaves(naves);
	                break;
	            case 6:
	               // eliminarNave(naves, sc);
	                break;
	            case 7:
	            	salir();
	            	break;
	            default:
	            	System.out.println("Opción no válida.");
	            	break;
	        }
		} while (opcion != 7);
		sc.close();
	}
}
