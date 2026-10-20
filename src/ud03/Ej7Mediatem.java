package ud03;
/*Ejercicio 7:
Realiza la clase Java Mediatem que pide temperaturas por pantalla y las almacena en un array hasta que se introduzca la temperatura -999 que no será tenida en cuenta o el array esté lleno. Después calcula la temperatura media y muestra el número de temperaturas que son mayores que la media, iguales que la media, e inferiores a la media.
*/

import java.util.Scanner;

public class Ej7Mediatem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] aTemperaturas = new double[10]; //array de 10 posiciones
        double temp, suma=0, media; //cada temperatura, la suma de las temp, y su media
        int posOcupadas = 0, mayores = 0, iguales = 0, inferiores = 0; //cuantas posiciones ocupadas hay en el array, temps comparadas con la media
        boolean continuar = true; //validación para terminar bucle
        
        System.out.println("Introduce temperaturas (-999 finaliza):");
        
        while (posOcupadas < aTemperaturas.length && continuar) {
            System.out.print("Introduce la temperatura " + (posOcupadas + 1) + ": ");
            temp = sc.nextDouble();
            
            if (temp == -999) {
                continuar = false;
            } else {
                aTemperaturas[posOcupadas] = temp;
                posOcupadas++;
            }
        }
        
        
        if (posOcupadas > 0) {
            for (int i = 0; i < posOcupadas; i++) {
                suma += aTemperaturas[i];
            }
            
           media = suma / posOcupadas;
            
            //comparar cada temperatura guardada con la media
            for (int i = 0; i < posOcupadas; i++) {
                if (aTemperaturas[i] > media) {
                    mayores++;
                } else if (aTemperaturas[i] < media) {
                    inferiores++;
                } else {
                    iguales++;
                }
            }
            
    
            System.out.println("----------------------------------------");
            System.out.println("Total de temperaturas introducidas: " + posOcupadas);
            System.out.println("Temperaturas introducidas: ");
            for (int i = 0; i < posOcupadas; i++) {
            	System.out.print("Temperatura " +(i+1)+ " : " +aTemperaturas[i]+", ");
                }
            System.out.println("\nTemperatura media: " +media+ "ºC");
            System.out.println("Número de temperaturas mayores que la media: " + mayores);
            System.out.println("Número de temperaturas iguales a la media: " + iguales);
            System.out.println("Número de temperaturas inferiores a la media: " + inferiores);
        } else {
            System.out.println("No se introdujo ninguna temperatura válida.");
        }
        
        sc.close();
    }
}