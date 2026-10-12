package ud01;

import java.util.Scanner;

public class Medidas {
	public static void main(String[] args) {
		
		//Declaración de variables
		Scanner teclado = new Scanner(System.in);
		String nombre;
		int edad, altura;
		double peso;
		
		System.out.println("Introduce tu nombre: ");
		nombre=teclado.next();
		System.out.println("Introduce tu edad: ");
		edad=teclado.nextInt();
		System.out.println("Introduce tu altura en cm: ");
		altura=teclado.nextInt();
		System.out.println("Introduce tu peso en kg: ");
		peso=teclado.nextDouble();
		System.out.println("Tu nombre  es: " +nombre);
		System.out.println("Tu edad es: "+edad+ " años");
		System.out.println("Tu altura: " +altura+ " cm");
		System.out.println("Tu peso: " +peso+ " kg");
		
		teclado.close();
	}
}