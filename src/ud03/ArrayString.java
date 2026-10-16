package ud03;

/*PDF (Arrays y Métodos estáticos) - Ejercicio 2: Array y String.
Rellena un array de tamaño 5 con nombres de manera estática (sin introducirlos por teclado). Muestra el siguiente menú:

1-Salir
2-Mostrar lista
3-Pedir un nombre y contar las veces que aparece
4-Pedir un nombre y decir si existe
5-Eliminar. Pedir un nombre y en el lugar de ese nombre introducir “null”.
*/

import java.util.Scanner;

public class ArrayString {

    public static void cerrar() {
        System.out.println("Cerrando programa. Hasta pronto :-)");
    }
    
    //mostrar la lista de nombres
    public static void mostrar(String [] aNombres) {
        System.out.println("NOMBRES:");
        for(int i = 0; i < aNombres.length; i++) {
            System.out.println("Posición " + i + ": " + aNombres[i]);
        }
    }
    
    //contar nombres
    public static void pedir(String [] aNombres, Scanner sc) {
        System.out.print("Introduce un nombre a buscar: ");
        String nombre = sc.next();
        int nVeces = 0;
        
        for(int i = 0; i < aNombres.length; i++) {
            if (aNombres[i] != null && aNombres[i].equalsIgnoreCase(nombre)) {
                nVeces++;
            }
        }
        if (nVeces == 1) {
        	System.out.println("El nombre '" + nombre + "' aparece 1 vez.");
        }else {
        	System.out.println("El nombre '" + nombre + "' aparece " + nVeces + " veces.");
        }
    }
    
    //existe?
    public static void existe(String [] aNombres, Scanner sc) {
        System.out.print("Introduce un nombre para comprobar si existe: ");
        String nombre = sc.next();
        boolean encontrado = false;
        
        for(int i = 0; i < aNombres.length; i++){
            if (aNombres[i] != null && aNombres[i].equalsIgnoreCase(nombre)) {
                encontrado = true;
            }
        }
        
        if (encontrado) {
            System.out.println("El nombre está en la lista.");
        } else {
            System.out.println("El nombre NO está en la lista.");
        }
    }

    //elegir nombre que queremos eliminar
    public static void eliminar(String [] aNombres, Scanner sc) {
        System.out.println("Introduce el nombre que deseas eliminar: ");
        mostrar(aNombres);
        String nombre = sc.next();
        boolean eliminado = false;
      
        for(int i = 0; i < aNombres.length; i++) {
            if (!eliminado && aNombres[i] != null && aNombres[i].equalsIgnoreCase(nombre)) {
                aNombres[i] = "null";
                System.out.println("Nombre eliminado");
                eliminado = true;
            }
        }
        if (!eliminado) {
            System.out.println("No se ha encontrado ese nombre en la lista.");
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        String [] aNombres = {"Ethan", "June", "June", "Romana", "Ali"};
        
        do {
            System.out.println("MENÚ");
            System.out.println("1. Salir.");
            System.out.println("2. Mostrar lista.");
            System.out.println("3. Pedir un nombre y contar las veces que aparece.");
            System.out.println("4. Pedir un nombre y decir si existe.");
            System.out.println("5. Eliminar. Pedir un nombre y en el lugar de ese nombre introducir “null”.");
            System.out.println("*********************************");
            
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            
            switch(opcion){
            case 1:
                cerrar();
                break;
            case 2:
                mostrar(aNombres);
                break;
            case 3:
                pedir(aNombres, sc);
                break;
            case 4:
                existe(aNombres, sc);
                break;
            case 5:
                eliminar(aNombres, sc);
                break;
            default:
                System.out.println("Error. Elija una opción válida:");
                break;
            }
            
        } while(opcion != 1);
        
        sc.close();
    }
}