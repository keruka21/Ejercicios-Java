package ud03;

/*Crea tres métodos:
pedirNumero()': pide un número entero por teclado y lo devuelve.
esPar(int n)': devuelve true si el número es par, false en caso contrario.
En el main, usa los otros métodos para indicar si el número introducido es par o impar.
*/

import java.util.Scanner;

public class Ej3EstaticosPedirPar  {

    public static int pedirNumero(Scanner sc) {
        int numero;
        
        System.out.println("Introduce un número entero:");
        numero = sc.nextInt();
        sc.nextLine(); // Limpiar buffer
        
        return numero;
    }

    public static boolean esPar(int n) {
        boolean resultado;
        
        if (n % 2 == 0) {
            resultado = true;
        } else {
            resultado = false;
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroLeido = pedirNumero(sc);
        boolean par = esPar(numeroLeido);

        if (par) {
            System.out.println("El número " + numeroLeido + " es par.");
        } else {
            System.out.println("El número " + numeroLeido + " es impar.");
        }
        
        sc.close();
    }
}