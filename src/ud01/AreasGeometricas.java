package ud01;
/*Documento Word - Ejercicio 1: Áreas de formas geométricas.
Crea el siguiente programa:

¡Hola!
¿Cuál es tu nombre?
Leire
Bienvenida Leire. Vamos a realizar diferentes cálculos.
***************************************
CÍRCULO
Introduce el valor del radio: 6
El área del círculo es 113.1 m2.
***************************************
CUADRADO
Introduce el valor del lado: 4
El área del cuadrado es 16 m2.
***************************************
RECTÁNGULO
Introduce el valor del lado más largo: 4
Introduce el valor del lado más corto: 7
El área del rectángulo es 28 m2.
***************************************
TRIÁNGULO
Introduce el valor de la altura: 8
Introduce el valor de la base: 10
El área del triángulo es 40 m2.
*/
import java.util.Scanner;

public class AreasGeometricas {
	public static void main(String[] args) {
		
		//Declaración de variables
		Scanner sc = new Scanner(System.in);
		String nombre;
		final double PI=3.14; //constante
		double radio, ladocuadrado, ladolargo, ladocorto, altura, base;
		
		System.out.println("¡Hola!");
		System.out.println("¿Cuál es tu nombre?");
		nombre=sc.next();
		System.out.print("Bienvenid@ "+nombre);
		System.out.println("Vamos a realizar diferentes cálculos." );
		System.out.println("***************************************");
		
		System.out.println("CÍRCULO");
		System.out.print("Introduce el valor del radio: ");
		radio=sc.nextDouble();
		System.out.println("El área del círculo es "+(PI*radio*radio)+" m2.");
		System.out.println("***************************************");
		
		System.out.println("CUADRADO");
		System.out.print("Introduce el valor del lado: ");
		ladocuadrado=sc.nextDouble();
		System.out.println("El área del cuadrado es "+(ladocuadrado*ladocuadrado)+" m2.");
		System.out.println("***************************************");
		
		System.out.println("RECTÁNGULO");
		System.out.print("Introduce el valor del lado más largo: ");
		ladolargo=sc.nextDouble();
		System.out.print("Introduce el valor del lado más corto: ");
		ladocorto=sc.nextDouble();
		System.out.println("El área del rectángulo es "+(ladolargo*ladocorto)+" m2.");
		System.out.println("***************************************");
		
		System.out.println("TRIÁNGULO");
		System.out.print("Introduce el valor de la altura: ");
		altura=sc.nextDouble();
		System.out.print("Introduce el valor de la base: ");
		base=sc.nextDouble();
		System.out.println("El área del triángulo es "+(altura*base)/2+" m2.");
		
		sc.close();
	}
}
