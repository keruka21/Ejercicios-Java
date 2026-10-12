package ud02;

/*Documento Word Bucles - Ejercicio 5:
Escribe un programa que mostrará por pantalla cuántos dígitos tiene el número
introducido por el usuario.
*/

import java.util.Scanner;

public class Bucles5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numero;
		
		System.out.print("Introduce un número para saber cuantos dígitos tiene:");
		numero=sc.next();
		//método .length()
		System.out.print("El número tiene: " +numero.length()+ " dígitos");
		sc.close();
	}
}