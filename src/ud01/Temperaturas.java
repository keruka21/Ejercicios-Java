package ud01;
/*Documento Word - Ejercicio 2: Temperaturas (Celsius, Farenheit, Kelvin).

Crea el siguiente programa:

Introduce la temperatura en grados Celsius: 30
........
Fahrenheit: 86º F
Kelvin: 303.15 K
*/

import java.util.Scanner;

public class Temperaturas {
	public static void main(String[] args) {
		
		//Declaración de variables
		Scanner sc = new Scanner(System.in);
		double celsius;
			
		System.out.print("Introduce la temperatura en grados Celsius: ");
		celsius=sc.nextDouble();
		System.out.println("Fahrenheit: "+(celsius*1.8+32)+" ºF");
		System.out.println("Kelvin: "+(celsius+273.15)+" K");
		sc.close();
	}

}
