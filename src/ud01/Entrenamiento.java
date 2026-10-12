package ud01;
/*Documento Word - Ejercicio 2: Entrenamiento.
Un gimnasio quiere calcular algunos datos de sus clientes.
El programa debe pedir:
Peso de la persona en kg. 
Altura en metros. 
Número de entrenamientos realizados durante el mes. 
Duración media de cada entrenamiento en minutos. 
Debe calcular y mostrar:
IMC (peso / altura²). 
Número total de minutos entrenados durante el mes. 
Número total de horas entrenadas durante el mes. 
Tiempo medio semanal entrenando, suponiendo que el mes tiene 4 semanas.
*/

import java.util.Scanner;

public class Entrenamiento {
	public static void main(String[] args) {
		
		//Declaración de variables
		int numEntrenamientos,durEntrenamientos,durEntMes;
		double peso,altura;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hola usuari@, vamos a calcular algunos de tus datos, introduce tu peso en kg: ");
		peso=sc.nextDouble();
		System.out.println("Introduce tu altura en metros: ");
		altura=sc.nextDouble();
		System.out.println("Introduce el número de entrenamientos que realizas en el mes: ");
		numEntrenamientos=sc.nextInt();
		System.out.println("Introduce la duración media de tus entrenamientos en minutos");
		durEntrenamientos=sc.nextInt();
		durEntMes=numEntrenamientos*durEntrenamientos;
		System.out.println("Tu IMC (Índice de Masa Corporal) es de: "+(peso/(altura*altura)));
		System.out.println("Tu número de minutos entrenados durante el mes son: "+durEntMes+" minutos");
		System.out.println("Tu número total de horas entrenadas durante el mes: "+durEntMes/60+" horas");
		System.out.println("Tu tiempo medio entrenando es de: "+(durEntMes/60)/4+" horas semanales");
		sc.close();
	}

}
