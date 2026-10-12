package ud02;

/*Ejercicio 117
Realiza la clase Java Sumapadw lee un número entero por teclado y muestra la suma de todos los números pares desde n hasta 0 (en orden descendente). Con While.
*/

import java.util.Scanner;

public class Ej117Sumapadw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, suma = 0, i = 0, sumaAnterior=0;;
        
        System.out.print("Introduce un número entero: ");
        numero = sc.nextInt();
        
        i = numero;
        
        if (numero >= 0) {
            if (i % 2 != 0) {
                i--;
            }
            while (i >= 0) {
            	sumaAnterior = suma;
                suma += i;
                System.out.println(sumaAnterior + " + " + i + " = " + suma);
                i -= 2;
            }
        }else {
            if (i % 2 != 0) {
                i++;
            }
            while (i <= 0) {
            	sumaAnterior = suma;
                suma += i;
                System.out.println(sumaAnterior + " + " + i + " = " + suma);
                i += 2;
            }
        }
        
        System.out.println("La suma de los pares desde " + numero + " hasta 0 es: " + suma);
        
        sc.close();
    }
}
