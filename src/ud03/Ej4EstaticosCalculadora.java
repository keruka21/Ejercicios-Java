package ud03;

/*Crea los siguientes métodos estáticos:
'sumar(int a, int b)'
'restar(int a, int b)'
'multiplicar(int a, int b)'
'dividir(int a, int b)'
Desde el main, pide dos números por teclado y muestra un menú con las distintas opciones.
*/

import java.util.Scanner;

public class Ej4EstaticosCalculadora {

    public static int sumar(int a, int b) {
        int resultado;
        resultado = a + b;
        return resultado;
    }

    public static int restar(int a, int b) {
        int resultado;
        resultado = a - b;
        return resultado;
    }

    public static int multiplicar(int a, int b) {
        int resultado;
        resultado = a * b;
        return resultado;
    }

    public static double dividir(int a, int b) {
        double resultado;
        resultado = (double) a / b;
        return resultado;
    }
    
/*MAIN----------------------------------------------------------------------*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;
        int opcion;
           
        System.out.println("Introduce el primer número:");
        num1 = sc.nextInt();
        
        System.out.println("Introduce el segundo número:");
        num2 = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        System.out.println("\n--- MENÚ CALCULADORA ---");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.print("Elige una opción (1-4):\n> ");
        
        opcion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                System.out.println("Resultado de la suma: " + sumar(num1, num2));
                break;
            case 2:
                System.out.println("Resultado de la resta: " + restar(num1, num2));
                break;
            case 3:
                System.out.println("Resultado de la multiplicación: " + multiplicar(num1, num2));
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: No se puede dividir entre cero.");
                } else {
                    System.out.println("Resultado de la división: " + dividir(num1, num2));
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }

        sc.close();
    }
}