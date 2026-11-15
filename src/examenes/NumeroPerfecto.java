package examenes;
/*Crea un programa que solicite un número entero positivo e indique si es un número perfecto.
Un número es perfecto cuando es igual a la suma de todos sus divisores positivos, excluyéndose a sí mismo.

Ejemplos:
6 es perfecto: (1 + 2 + 3 = 6).
28 es perfecto: (1 + 2 + 4 + 7 + 14 = 28).
12 no es perfecto.
*/
import java.util.Scanner;

public class NumeroPerfecto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int suma = 0;

        System.out.print("Introduce un número entero positivo: ");
        numero = sc.nextInt();

        while (numero <= 0) {
            System.out.print("Por favor, introduce un número entero positivo válido: ");
            numero = sc.nextInt();
        }

        // Sumamos los divisores excluyendo al propio número
        for (int i = 1; i < numero; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }

        if (suma == numero) {
            System.out.println("El número " + numero + " es perfecto.");
        } else {
            System.out.println("El número " + numero + " no es perfecto.");
        }

        sc.close();
    }
}