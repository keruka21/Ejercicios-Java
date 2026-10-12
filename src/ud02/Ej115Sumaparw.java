package ud02;
/*Ejercicio 115
Realiza la clase Java Sumaparw lee un número entero por teclado y muestra la suma de todos los números pares desde 0 hasta n. Con While.
*/
import java.util.Scanner;

public class Ej115Sumaparw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, i = 0, suma = 0, sumaAnterior=0;
        
        System.out.print("Introduce un número entero: ");
        numero = sc.nextInt();
        
        if (numero >= 0) {
            while (i <= numero) {
                sumaAnterior = suma; //guardamos el acumulado antes de sumar el actual
                suma += i;              
                System.out.println(sumaAnterior + " + " + i + " = " + suma);
                i += 2;
            }
        } else {
            while (i >= numero) {
                sumaAnterior = suma;
                suma += i;
                System.out.println(sumaAnterior + " + "  + i + " = " + suma);
                i -= 2;
            }
        }
        
        System.out.println("La suma total de los pares desde 0 hasta " + numero + " es: " + suma);
        
        sc.close();
    }
}