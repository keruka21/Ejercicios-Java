package ud02;

/*Documento Word Bucles - Ejercicio 5:
Escribe un programa que mostrará por pantalla cuántos dígitos tiene el número
introducido por el usuario.
*/

import java.util.Scanner;

public class Bucles5ver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, numOriginal;
        int i = 0;
        
        System.out.print("Introduce un número para saber cuántos dígitos tiene: ");
        numero = sc.nextInt();
        numOriginal = numero; //guardamos el valor del número original introducido
       
        //caso especial si el usuario introduce exactamente el 0
        if (numero == 0) {
            i = 1;
        } else {
            //bucle que divide entre 10 hasta que el número se queda en 0
            while (numero > 0) {
                numero = numero / 10; //quita el último dígito
                i++;           //cuenta el dígito eliminado
            }
        }
        
        System.out.print("El número " + numOriginal + " tiene: " + i + " dígitos.");
        sc.close();
    }
}
