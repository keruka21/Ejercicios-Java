package ud02;

/*Documento Word - Ejercicio 1: ¿Puede entrar?
Un local tiene una edad mínima de 18 años para poder entrar.
El programa debe pedir la edad de una persona y mostrar:
"Puedes entrar" si tiene 18 años o más. 
"No puedes entrar" si tiene menos de 18. 
Si tiene exactamente 18, mostrar "Justo de edad".
*/

import java.util.Scanner;

public class Permiso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;

        System.out.print("Introduce tu edad: ");
        edad = sc.nextInt();

        if (edad == 18) {
            System.out.println("Justo de edad");
        } 
        else if (edad > 18) {
            System.out.println("Puedes entrar");
        } 
        else {
            System.out.println("No puedes entrar");
        }

        sc.close();
    }
}