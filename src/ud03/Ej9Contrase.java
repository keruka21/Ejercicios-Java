package ud03;

import java.util.Scanner;

public class Ej9Contrase {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String user = "usuario";
        String pass = "1234";
        
        int intentos = 0;
        boolean accesoConcedido = false;
        
        while (intentos < 3 && !accesoConcedido) {
            intentos++;
            System.out.println("--- INTENTO " + intentos + " DE 3 ---");
            
            System.out.print("Introduce el nombre de usuario: ");
            String usuario = sc.next();
            
            System.out.print("Introduce la contraseña: ");
            String password = sc.next();
             
            if (usuario.equals(user) && password.equals(pass)) {
                accesoConcedido = true;
                System.out.println("\n¡Bienvenido al sistema, " + usuario + "!");
            } else {
                System.out.println("Error: Nombre de usuario o contraseña incorrectos.\n");
            }
        }
        
        if (!accesoConcedido) {
            System.out.println("Has superado el número máximo de 3 intentos permitidos.");
        }
        
        sc.close();
    }
}