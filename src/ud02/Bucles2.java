package ud02;
/*Documento Word Bucles - Ejercicio 2:
Escribe un programa utilizando FOR que mostrará por pantalla los números
comprendidos entre 200 y 300, ambos incluidos.
*/

public class Bucles2 {
	public static void main(String[] args) {
		
		for(int num=200; num<=300; num++) {
			System.out.print(num);
			//no haya coma después de 300
			if (num < 300) {
                System.out.print(", "); 
            }
			
		}

	}

}
