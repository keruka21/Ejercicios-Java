package ud03;

/*PDF (Arrays y Métodos estáticos) - Ejercicio 1:
Define un array y rellénalo con números aleatorios de 0 a 100 (mirar aquí).
Muestra el siguiente menú:

Salir
Mostrar la suma
Mostrar el máximo
Mostrar el mínimo
Mostrar la media
Rellenarlo de nuevo con números (formatear)
*/

import java.util.Scanner;

public class NumAleatorio {

	
	public static void cerrar() {
		System.out.println("Cerrando programa. Hasta pronto :-)");
	}
	
	//método auxiliar para mostrar los números del array
	public static void mostrarNum(int []aNum) {
		System.out.println("Los números del array son:");
		for(int i = 0; i < aNum.length; i++) {
			System.out.print(aNum[i]+ " ");
		}
		System.out.println();
	}
	
	public static void suma(int []aNum) {
		mostrarNum(aNum);
		int sum = 0; //reiniciar sum 
		for(int i = 0; i < aNum.length; i++) {
			sum += aNum[i]; //sum es acumulativo
		}
		System.out.println("La suma de todos los números es: " + sum);
	}
	
	public static void maximo(int []aNum) {
		mostrarNum(aNum);
		int max = aNum[0];//reiniciamos, primer elemento es el maximo
		for (int i = 0; i < aNum.length; i++) {
			if (aNum[i] > max) {
				max = aNum[i];
			}
		}
		System.out.println("El máximo es: " + max);
	}
	
	public static void minimo(int []aNum) {
		mostrarNum(aNum);
		int min = aNum[0];
		for (int i = 0; i < aNum.length; i++) {
			if (aNum[i] < min) {
				min = aNum[i];
			}
		}
		System.out.println("El mínimo es: " + min);
	}
	
	public static void media(int []aNum) {
		mostrarNum(aNum);
		double sum = 0; //las medias deben poder mostrar decimales -> double
		for (int i = 0; i < aNum.length; i++) {
			sum += aNum[i];
		}
		System.out.println("La media es: " + (sum / aNum.length));
	}
	
	public static void formatear(int []aNum) {
		for(int i = 0; i < aNum.length; i++) {
			aNum[i] = (int)(Math.random() * 101); 
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int [] aNum = new int[5];
		
		int opcion;
		
		formatear(aNum);
		
		do {
			System.out.println("MENÚ");
			System.out.println("1. Salir");
			System.out.println("2. Mostrar la suma");
			System.out.println("3. Mostrar el máximo");
			System.out.println("4. Mostrar el mínimo");
			System.out.println("5. Mostrar la media");
			System.out.println("6. Rellenarlo de nuevo con números (formatear)");
			System.out.println("*********************************");
			
			System.out.print("Elige una opción: ");
			opcion = sc.nextInt();
			
			switch(opcion){
			case 1:
				cerrar();
				break;
			case 2:
				suma(aNum);
				break;
			case 3:
				maximo(aNum);
				break;
			case 4:
				minimo(aNum);
				break;
			case 5:
				media(aNum);
				break;
			case 6:
				formatear(aNum);
				System.out.println("¡Array formateado con éxito!");
				break;
			default:
				System.out.println("Error. Opción inválida. Inténtalo de nuevo.");
				break;
			}
			
		} while(opcion != 1);
		
		sc.close();
	}
}