package ud03;

/*Ejercicios sencillos de Arrays - Ejercicio 2:
Declara un array llamado aNotas de 8 posiciones (real). Pídele al usuario que introduzca 8 notas, guárdalas en el array y muestra todas al final.
*/

import java.util.Scanner;

public class EjSencilloArrays2 {
	
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        double[] aNotas = new double[8];
        
        System.out.println("Por favor, introduce 8 notas:");
        for (int i = 0; i < aNotas.length; i++) {
            System.out.print("Introduce la nota " + (i + 1) + ": ");
            aNotas[i] = sc.nextDouble();
        }
        
        //mostrar notas almacenadas al final
        System.out.println("-----------------------------");
        System.out.println("Listado de notas introducidas");
        for (int i = 0; i < aNotas.length; i++) {
            System.out.println("aNotas[" + i + "] = " + aNotas[i]);
        }
        sc.close();
    }
}