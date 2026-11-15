package examenes;

/*Crea un programa que solicite un número entero positivo y genere su sucesión hasta llegar a 1.
Las reglas son las siguientes:
	*Si el número es par, se divide entre 2.
	*Si es impar, se multiplica por 3 y se suma 1.
	*El proceso termina cuando se alcanza el número 1.
Ejemplo para N = 6:
	6, 3, 10, 5, 16, 8, 4, 2, 1
El programa mostrará la sucesión completa y el número de pasos realizados.
*/

import java.util.Scanner;

public class SucesionCollatz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int pasos = 0;

        System.out.print("Introduce un número entero positivo: ");
        numero = sc.nextInt();

        while (numero <= 0) {
            System.out.print("Introduce un número entero positivo válido: ");
            numero = sc.nextInt();
        }

        System.out.print("Sucesión: " + numero);

        while (numero != 1) {
            if (numero % 2 == 0) {
                numero = numero / 2;
            } else {
                numero = numero * 3 + 1;
            }
            System.out.print(", " + numero);
            pasos++;
        }

        System.out.println();
        System.out.println("Número de pasos realizados: " + pasos);

        sc.close();
    }
}