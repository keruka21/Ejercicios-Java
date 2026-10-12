package ud02;

/*Documento Word Bucles - Ejercicio 4:
Escribe un programa que mostrará por pantalla el numero factorial del número
introducido por el usuario por consola. El número introducido debe ser mayor que 0.
https://es.wikipedia.org/wiki/Factorial
El factorial de un número entero positivo (se representa con un signo de exclamación !).
Es el resultado de multiplicar todos los números enteros desde el 1 hasta ese número.
Por ejemplo, el factorial de 5 (se escribe 5!) y se calcula así:
5!=5×4×3×2×1=120
*/

import java.util.Scanner;

public class Bucles4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero, i = 1, factorial=1;
		
		System.out.println("FACTORIAL DE UN NÚMERO");
		System.out.println("Dime un número que sea mayor que cero:");
		numero=sc.nextInt();
		while(numero<=0){
			System.out.print("Error. El número debe ser mayor que 0. ");
			numero=sc.nextInt();
		}
		
		while(i<=numero){
			factorial=factorial*i; //acumulativo
			//factorial *= i;
			i++;
		}
		System.out.print("El factorial de " +numero+ " es: " +factorial);
		sc.close();
	}
}
