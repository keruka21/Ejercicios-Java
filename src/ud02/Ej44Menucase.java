package ud02;

/*Ejercicio 44
Realiza la clase Java Menucase que muestra un menú y lee por teclado el valor de una opción.
En función de la opción, muestra un mensaje indicando la opción seleccionada usando una estructura selectiva.
1. Opción 1
2. Opción 2
3. Opción 3
4. Opción 4
5. Opción 5
0. Salir
*/

import java.util.Scanner;

public class Ej44Menucase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("4. Opción 4");
            System.out.println("5. Opción 5");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la Opción 1");
                    break;
                case 2:
                    System.out.println("Has seleccionado la Opción 2");
                    break;
                case 3:
                    System.out.println("Has seleccionado la Opción 3");
                    break;
                case 4:
                    System.out.println("Has seleccionado la Opción 4");
                    break;
                case 5:
                    System.out.println("Has seleccionado la Opción 5");
                    break;
                case 0:
                    System.out.println("Saliendo del programa... ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Error: Opción no válida. Introduce un número entre 0 y 5.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}