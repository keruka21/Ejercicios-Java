package ud02;

/*Documento Word - Ejercicio 2: Nota del examen.
Pide al usuario una nota entre 0 y 10.
El programa debe mostrar:
"Suspenso" si la nota es menor que 5. 
"Aprobado" si está entre 5 y 6,9. 
"Notable" si está entre 7 y 8,9. 
"Sobresaliente" si es 9 o más.
*/

import java.util.Scanner;

public class Calificaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double nota;

        System.out.print("Introduce una nota entre 0 y 10: ");
        nota = sc.nextDouble();

        //validación
        while (nota < 0 || nota > 10) {
            System.out.println("Error: La nota debe estar entre 0 y 10.");
            nota = sc.nextDouble();
        } 
        
        if (nota < 5) {
            System.out.println("Suspenso");
        } 
        else if (nota < 7) {
            System.out.println("Aprobado");
        } 
        else if (nota < 9) {
            System.out.println("Notable");
        } 
        else {
            System.out.println("Sobresaliente");
        }

        sc.close();
    }
}