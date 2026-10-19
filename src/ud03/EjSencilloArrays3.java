package ud03;

/*Ejercicios sencillos de Arrays - Ejercicio 3:
Declara un array llamado aNotasPGR de 5 posiciones (int). Pídele al usuario que introduzca 5 notas, guárdalas en el array y muestra la media de todas las notas.
*/

import java.util.Scanner;

public class EjSencilloArrays3 {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int[] aNotasPGR = new int[5];
        int suma = 0;
        
        System.out.println("Por favor, introduce 5 notas:");
        for (int i = 0; i < aNotasPGR.length; i++) {
            System.out.print("Introduce la nota " + (i + 1) + ": ");
            aNotasPGR[i] = sc.nextInt();
            suma += aNotasPGR[i]; //acumula en cada vuelta del bucle
        }
        
        //calcular media con un cast a double para obtener decimales
        double media = (double) suma / aNotasPGR.length;
        
        System.out.println("---------------------");
        System.out.println("La media es: " + media);
        
       sc.close();
    }
}