package ud02;

/*Documento Word Bucles - Ejercicio 3:
Escribe un programa utilizando FOR que mostrará por pantalla los 5 primeros numero
pares.
*/

public class Bucles3ver2 {
	public static void main(String[] args) {
		int i = 0, numPar = 0;
		
        for (i = 1; i <= 5; i++) {
        	numPar = i * 2;
            System.out.print(numPar+ " ");
        }
    }
}