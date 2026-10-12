package ud02;

/*
Ejercicio 45
Realiza la clase Java Menudias que lee por teclado un carácter y muestra el día de la semana que le corresponde según la siguiente tabla:
L	Lunes
M	Martes
X	Miércoles
J	Jueves
V	Viernes
S	Sábado
D	Domingo
Otro Carácter	ERROR
*/

import java.util.Scanner;

public class Ej45Menudias {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char letra;

        System.out.println("=== DIAS DE LA SEMANA ===");
        System.out.println("Introduce una letra (L, M, X, J, V, S, D): ");
        
        //no existe un método directo como sc.nextChar(), hay que usar un método de Strings
        //para que también funcione si el usuario escribe en minúscula
        letra = sc.next().toUpperCase().charAt(0);

        switch (letra) {
            case 'L':
                System.out.println("Lunes");
                break;
            case 'M':
                System.out.println("Martes");
                break;
            case 'X':
                System.out.println("Miércoles");
                break;
            case 'J':
                System.out.println("Jueves");
                break;
            case 'V':
                System.out.println("Viernes");
                break;
            case 'S':
                System.out.println("Sábado");
                break;
            case 'D':
                System.out.println("Domingo");
                break;
            default:
                System.out.println("ERROR");
                break;
        }

        sc.close();
    }
}