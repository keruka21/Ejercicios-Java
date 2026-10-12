package ud02;

/*Ejercicio 107
Realiza la clase Java Num100 que muestra por pantalla los 100 primeros números enteros.
*/

public class Ej107Num100 {
    public static void main(String[] args) {
        int i = 1;
        
        while (i <= 100) {
            System.out.print(i);
            if (i<100) {
            	System.out.print(", ");
            }
            i++;
        }
    }
}