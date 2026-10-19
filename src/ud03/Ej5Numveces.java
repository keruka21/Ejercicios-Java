package ud03;

/*Ejercicio 5:
Realiza la clase Java Numveces que pide números de 0 a 9 por pantalla y calcula el número de veces que han sido introducidos utilizando un array. Finaliza la introducción de datos cuando se introduce un valor negativo o el array está lleno. Al finalizar la introducción de datos muestra por pantalla el número de veces que se ha introducido cada número.
*/

import java.util.Scanner;

public class Ej5Numveces {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //array contador para almacenar cuántas veces aparece cada dígito (del 0 al 9)
        int[] contador = new int[10]; 
        
        int maxSize = 20; //límite máximo de entradas permitidas
        int numEntradas = 0; //numero de numeros que introducimos
        int num; //número introducido
        boolean continuar = true; //para validar
        
        System.out.println("Introduce números de 0 a 9");
        System.out.println("Un valor negativo finaliza la entrada, o al alcanzar " + maxSize + " elementos)");		
        
        while (numEntradas < maxSize && continuar) {
            System.out.print("Introduce un número: ");
            num = sc.nextInt();
            
            if (num < 0) {
                continuar = false; //si el numero es negativo terminar bucle
            } else {
                if (num >= 0 && num <= 9) {
                    contador[num]++; //utilizamos la posición del array como valor, pos 0 acumula las veces que metemos 0 en num
                    numEntradas++; 
                } else {
                    System.out.println("Número fuera de rango. Debe ser un valor comprendido entre 0 y 9.");
                }
            }
        }
        
        System.out.println("------------------------------");
        for (int i = 0; i < contador.length; i++) {
            System.out.println("El número " + i + " se ha introducido " + contador[i] + " veces.");
        }
        
        sc.close();
    }
}