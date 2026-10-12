package ud02;

/*Ejercicio 109
Realiza la clase Java Sacaparw que lee un número entero por teclado y muestra los números pares desde 0 hasta él inclusive. Con While.
*/

import java.util.Scanner;

public class Ej109Sacaparw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0, numero;
        
        System.out.print("Introduce un número entero: ");
        numero = sc.nextInt();
        
        if(numero>0) {
        	 while (i <= numero) {
                 System.out.print(i + " ");
                 i += 2;
             }
        }else{
        	 while (i >= numero) {
                 System.out.print(i + " ");
                 i -= 2;
             }
        }
        sc.close();
    }
}