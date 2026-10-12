package ud02;

/*Ejercicio 108
Realiza la clase Java Sacanumw que lee un número entero por teclado y muestra los números desde 1 hasta él inclusive. Con While.
*/

import java.util.Scanner;

public class Ej108Sacanumw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i = 1;
        
        System.out.print("Introduce un número entero: ");
        n = sc.nextInt();
       
        if (n >= 1) {
            while (i <= n) {
                System.out.print(i + " ");
                i++;
            }
        } else {
            while (i >= n) {
                System.out.print(i + " ");
                i--;
          }
        }
        sc.close();
    }
}