package ud01;
/*Documento Word - Ejercicio 1: Compra en una tienda.
Una tienda vende camisetas a 18,50 € y pantalones a 32,90 €.
El programa debe pedir al usuario:
Número de camisetas que quiere comprar. 
Número de pantalones. 
Dinero con el que paga. 
Debe calcular y mostrar:
Precio total de las camisetas. 
Precio total de los pantalones. 
Precio total de la compra. 
Dinero que le devuelven.
*/

import java.util.Scanner;

public class CompraTienda {
	public static void main(String[] args) {
		
		//Declaración de variables
	    int numCami, numPanta;
	    double dinero, totalCami, totalPanta;
	    Scanner teclado = new Scanner(System.in);

	    System.out.println("Hola usuari@, introduce el número de camisetas que quieres comprar: ");
	    numCami = teclado.nextInt();
	    System.out.println("Introduce el número de pantalones que quieres comprar: ");
	    numPanta = teclado.nextInt();
	    System.out.println("¿Cuánto es el importe con el que pagas?");
	    dinero = teclado.nextDouble();
	    totalCami = 18.5 * numCami;
	    totalPanta = 32.9 * numPanta;
	        
	    System.out.println("Precio total camisetas: " + (totalCami) + "€");
	    System.out.println("Precio total pantalones: " + totalPanta + "€");
	    System.out.println("Precio total compra: " + (totalCami + totalPanta) + "€");
	    System.out.println("Vuelta de la compra: " + (dinero - (totalCami + totalPanta)) + "€");
	    teclado.close();
	    
	   }
}
