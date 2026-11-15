package examenes;

/*Crea un programa que solicite un número entero positivo e indique si se lee igual de izquierda a derecha que de derecha a izquierda.
Ejemplos:
	1221 es capicúa.
	34543 es capicúa.
	1234 no es capicúa.
No se puede convertir el número a una cadena para resolver el ejercicio.
*/

import java.util.Scanner;

public class NumeroCapicua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int original; //guarda una copia exacta del valor inicial del número. 
        int invertido = 0; //acumulador donde se construirá el número al revés (derecha a izquierda)
        int temp; //copia para ir quitándole dígitos uno a uno sin perder el valor de las demás variables
        int digito;//guarda temporalmente el último dígito que se saca del número en cada vuelta del bucle

        System.out.print("Introduce un número entero positivo: ");
        numero = sc.nextInt();

        //bucle de validación
        while (numero <= 0) {
            System.out.print("Introduce un número entero positivo válido: ");
            numero = sc.nextInt();
        }
        
        //copia el valor de numero en original (para recordarlo al final)
        original = numero;
        //copia el valor de numero en temp para descomponerlo en el bucle sin destruir el dato
        temp = numero;

        // Invertimos el número matemáticamente
        while (temp > 0) {
            digito = temp % 10; //obtiene el último dígito del número actual y el resto se dividir entre 10.
            invertido = invertido * 10 + digito; //añade ese dígito al número invertido y multiplicar por 10 desplaza los dígitos hacia la izquierda para hacer hueco al nuevo
            temp /= 10; //elimina el último dígito del número temporal dividiéndolo entre 10 de forma entera.
            //El bucle se repite hasta que temp se queda en 0.
        }

        if (original == invertido) {
            System.out.println("El número " + original + " es capicúa.");
        } else {
            System.out.println("El número " + original + " no es capicúa.");
        }

        sc.close();
    }
}