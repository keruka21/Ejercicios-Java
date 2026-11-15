package ud03;

/*Crea un método llamado 'mostrarNombre' que reciba como parámetro un nombre (tipo String)
 y muestre el mensaje 'Hola [nombre]!'. El nombre se debe pedir por teclado con Scanner desde el main.
*/

import java.util.Scanner;

public class Ej2EstaticosSaludoPersonalizado {

    public static void mostrarNombre(String nombre) {
        System.out.println("Hola " + nombre + "!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreUsuario;
        
        System.out.println("¿Cómo te llamas?");
        nombreUsuario = sc.nextLine();
        
        mostrarNombre(nombreUsuario);
        
        sc.close();
    }
}