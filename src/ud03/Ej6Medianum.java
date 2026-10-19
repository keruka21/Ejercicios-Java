package ud03;

/*Ejercicio 6:
Realiza la clase Java Medianum que pide números por pantalla y los almacena en un array hasta
que se introduzca un número negativo que no será tenido en cuenta o el array esté lleno.
Después calcula la Media y la muestra.
*/

import java.util.Scanner;

public class Ej6Medianum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] aNumeros = new int[5];
        int posOcupadas = 0;
        int num = 0;
        boolean continuar = true;
        int suma = 0;
        
        System.out.println("Introduce números enteros (un número negativo finaliza la entrada):");
        
        while (posOcupadas < aNumeros.length && continuar) {
            System.out.print("Introduce el número " + (posOcupadas + 1) + ": ");
            num = sc.nextInt();
            
            //si se introduce un número negativo, no se guarda
            if (num < 0) {
                continuar = false;
            } else {
                aNumeros[posOcupadas] = num;
                posOcupadas++;
            }
        }
        
        //comprobamos si se introdujo al menos un número válido para calcular la media
        if (posOcupadas > 0) {
            //recorremos únicamente las posiciones que contienen datos útiles
            for (int i = 0; i < posOcupadas; i++) {
                suma += aNumeros[i];
            }
            
            //cast a double para obtener decimales
            double media = (double) suma / posOcupadas;
            
            System.out.println("----------------------------------------");
            System.out.println("Cantidad de números introducidos: " + posOcupadas);
            System.out.println("La suma total es: " + suma);
            System.out.println("La media es:"+ media);
        } else {
            System.out.println("No se introdujo ningún número válido para calcular la media.");
        }
        
        sc.close();
    }
}