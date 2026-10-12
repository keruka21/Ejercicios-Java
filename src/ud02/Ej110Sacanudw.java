package ud02;

/*Ejercicio 110
Realiza la clase Java Sacanudw que lee un número entero por teclado y muestra los números desde él inclusive hasta 1. Con While.
*/

import java.util.Scanner;

public class Ej110Sacanudw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, i = 0;
        
        System.out.print("Introduce un número entero: ");
        numero = sc.nextInt();
        
        i = numero;
        if(numero>0){
        	while (i >= 1) {
                System.out.print(i + " ");
                i--;
            }
        }else {
        	while (i <= 1) {
                System.out.print(i + " ");
                i++;
            }
        }  
        sc.close();
    }
}