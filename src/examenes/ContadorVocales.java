package examenes;

/*Una aplicación educativa quiere analizar las palabras que escriben sus usuarios para conocer cuántas vocales contienen.
Desarrolla un programa en Java que solicite al usuario una palabra y cuente cuántas vocales contiene (a, e, i, o, u).
Condiciones:
	-No puedes utilizar métodos que resuelvan directamente el problema.
	-Debes recorrer la palabra carácter por carácter.
	-Si la palabra no contiene ninguna vocal, debe mostrar un mensaje indicándolo.
	Ejemplos de ejecución:
		murcielago->Contiene 5 vocales
		PROGRAMACION->Contiene 5 vocales
		tren->Contiene 1 vocal
		rhythm->No contiene vocales
*/

import java.util.Scanner;

public class ContadorVocales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabra;
        int vocales = 0;

        System.out.print("Introduce una palabra: ");
        palabra = sc.nextLine();

        //recorremos la palabra carácter por carácter usando charAt()
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            //comprobamos si el carácter es una vocal(no se usa equalsIgnoreCase porque es para Strings y daria error)
            if (letra == 'a' || letra == 'A' || 
                letra == 'e' || letra == 'E' || 
                letra == 'i' || letra == 'I' || 
                letra == 'o' || letra == 'O' || 
                letra == 'u' || letra == 'U') {
                vocales++;
            }
        }

        if (vocales == 0) {
            System.out.println("No contiene vocales");
        } else if (vocales == 1) {
            System.out.println("Contiene 1 vocal");
        } else {
            System.out.println("Contiene " + vocales + " vocales");
        }

        sc.close();
    }
}