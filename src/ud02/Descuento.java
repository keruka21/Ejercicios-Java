package ud02;

/*Documento Word - Ejercicio 3: Descuento en una tienda.
Una tienda hace un 10% de descuento si la compra es superior a 50 €.
El programa debe pedir el importe de la compra y mostrar:
Si supera los 50 €, el precio original, el descuento aplicado y el precio final. 
Si no supera los 50 €, mostrar que no tiene descuento y el precio final.
*/

import java.util.Scanner;

public class Descuento {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double importe, descuento;

        System.out.print("Introduce el importe de la compra en €: ");
        importe = sc.nextDouble();

        //validación
        while (importe < 0) {
            System.out.print("Error. El importe no puede ser negativo. Introduce un importe válido: ");
            importe = sc.nextDouble();
        }

        if (importe > 50) {
            descuento = importe * 0.10; //10%

            System.out.println("--- DETALLES DE LA COMPRA ---");
            System.out.println("Precio original: " + importe + " €");
            System.out.println("Descuento aplicado (10%): " + descuento + " €");
            System.out.println("Precio final a pagar: " + (importe-descuento) + " €");
        } 
        else {
            System.out.println("No tiene descuento.");
            System.out.println("Precio final a pagar: " + importe + " €");
        }

        sc.close();
    }
}