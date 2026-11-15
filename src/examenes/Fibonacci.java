package examenes;

/*Sucesión de Fibonacci
El programa pedirá al usuario un número (N) y mostrará los N primeros números de la sucesión de Fibonacci.
El primer número de la serie es 1, el segundo número es 1 y cada uno de los siguientes es la suma de los dos anteriores. 
Por ejemplo, si el número introducido es 7, la serie será: 1 1 2 3 5 8 13
Se debe controlar que el número introducido sea mayor que uno.
*/

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; //número de pasos en la secuencia
        //números consecutivos
        int a = 1;
        int b = 1;
        int c; //a+b 

        System.out.print("Introduce un número mayor que 1: ");
        n = sc.nextInt();

        while (n <= 1) {
            System.out.println("Error: El número introducido debe ser mayor que 1.");
            System.out.print("Introduce un número mayor que 1: ");
            n = sc.nextInt();
        }

        System.out.print("La serie es: ");
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.print(a);
            } else {
                System.out.print(" " + b);
                c = a + b;
                a = b;
                b = c;
            }
        }
        System.out.println(); 

        sc.close();
    }

}
