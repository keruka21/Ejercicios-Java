package ud02;

/*La clase String
Crear la clase MenuString. El programa le pedirá el nombre al usuario y le dará la bienvenida:
Bienvenido Antonio. ¿Qué quieres hacer?
Después le mostrará este menú:
1.- Dar la vuelta a una palabra.
Se le pedirá una palabra al usuario y se mostrará por pantalla dada la
vuelta. Por ejemplo: Si escribo Hola, se mostrará aloH.
2.- Comparar dos palabras.
Se le pedirán dos palabras al usuario y el programa dirá si son iguales
o no. Ejemplo:
Inserta la primera palabra: Hola
Inserta la segunda palabra: Hola
Son iguales
Ejemplo:
Inserta la primera palabra: Hola
Inserta la segunda palabra: Adios
No son iguales
3.-Número de letras.
Se le pedirá una palabra al usuario y se visualizará por pantalla
cuántas letras tiene. Si el número de letras es 7 o más, mostrara un
mensaje indicando que el tamaño de la palabra es grande. Y si es
menor de 7, indicará que el tamaño es pequeño.Ejemplo:
Inserta una palabra: Hola
Numero de letras: 4
El tamaño de la palabra es pequeño.
4.- Repetir palabra
Se le pedirá al usuario una palabra y un número. Se mostrará por
pantalla dicha palabra en mayúsculas y el número de veces que haya
indicado el usuario. Ejemplo:
Inserta la palabra que quieras repetir: Hola
¿Cuantas veces la quieres repetir?: 3
HOLA HOLA HOLA
5.- Repetir palabra (Mayúscula / Minúscula)
Se le pedirá una palabra al usuario. Después, se le preguntará si
quiere visualizarla en mayúsculas o minúsculas. Para terminar, se le
preguntará cuantas veces quiere repetir dicha palabra.
No se puede repetir una palabra 6 veces o más. Si el usuario inserta el número 6 o un número mayor, le pediremos de nuevo el
número de repeticiones.
Ejemplo: Inserta la palabra que quieres repetir: Hola
¿Mayúscula o Minúscula?: Minuscula
¿Cuantas veces la quieres repetir? 7
No se puede repetir más de 6 veces.
¿Cuantas veces la quieres repetir? 8
No se puede repetir más de 6 veces.
¿Cuantas veces la quieres repetir? 2
hola hola
6.- Salir del programa
Le dará las gracias al usuario y se terminará el programa.
Muchas gracias y hasta pronto.
*/

import java.util.Scanner;

public class MenuString {

    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);
        String nombre = "", palabra1 = "", palabra2 = "";
        int opcion = 0;
        String invertida = "", resultado = "", formato = "", palabraModificada = "";
        int i = 0, repeticiones = 0;

        System.out.print("Introduce tu nombre: ");
        nombre = sc.nextLine();
        System.out.println("Bienvenid@ " + nombre + ". ¿Qué quieres hacer?");

        do {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("1.- Dar la vuelta a una palabra.");
            System.out.println("2.- Comparar dos palabras.");
            System.out.println("3.- Número de letras.");
            System.out.println("4.- Repetir palabra.");
            System.out.println("5.- Repetir palabra (Mayúscula / Minúscula).");
            System.out.println("6.- Salir del programa");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiamos el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Introduce una palabra para darle la vuelta: ");
                    palabra1 = sc.nextLine();
                    invertida = "";
                    i = palabra1.length() - 1;

                    while (i >= 0) {
                        invertida = invertida + palabra1.charAt(i);
                        i--;
                    }
                    System.out.println("Palabra invertida: " + invertida);
                    break;

                case 2:
                    System.out.print("Inserta la primera palabra: ");
                    palabra1 = sc.nextLine();
                    System.out.print("Inserta la segunda palabra: ");
                    palabra2 = sc.nextLine();

                    if (palabra1.equalsIgnoreCase(palabra2)) {
                        System.out.println("Son iguales");
                    } else {
                        System.out.println("No son iguales");
                    }
                    break;

                case 3:
                    System.out.print("Inserta una palabra: ");
                    palabra1 = sc.nextLine();

                    System.out.println("Numero de letras: " + palabra1.length());
                    if (palabra1.length() >= 7) {
                        System.out.println("El tamaño de la palabra es grande.");
                    } else {
                        System.out.println("El tamaño de la palabra es pequeño.");
                    }
                    break;

                case 4:
                    System.out.print("Inserta la palabra que quieras repetir: ");
                    palabra1 = sc.nextLine();
                    System.out.print("¿Cuantas veces la quieres repetir?: ");
                    repeticiones = sc.nextInt();
                    sc.nextLine(); //limpiamos buffer

                    resultado = "";
                    for (i = 1; i <= repeticiones; i++) {
                        resultado += palabra1.toUpperCase();
                        //si no es la última repetición, añadimos un espacio detrás
                        if (i < repeticiones) {
                            resultado += " ";
                        }
                    }
                    System.out.println(resultado);
                    break;

                case 5:
                    System.out.print("Inserta la palabra que quieres repetir: ");
                    palabra1 = sc.nextLine();
                    
                    System.out.print("¿Mayúscula o Minúscula?: ");
                    formato = sc.nextLine().trim();

                    System.out.print("¿Cuantas veces la quieres repetir?: ");
                    repeticiones = sc.nextInt();
                    sc.nextLine(); //limpiamos buffer

                    //validación
                    while (repeticiones >= 6) {
                        System.out.println("No se puede repetir más de 6 veces.");
                        System.out.print("¿Cuantas veces la quieres repetir?: ");
                        repeticiones = sc.nextInt();
                        sc.nextLine(); //limpiamos buffer
                    }

                    //mayúscula o minúscula
                    if (formato.equalsIgnoreCase("Mayuscula") || formato.equalsIgnoreCase("Mayúsculas")) {
                        palabraModificada = palabra1.toUpperCase();
                    } else {
                        palabraModificada = palabra1.toLowerCase();
                    }
                   
                    resultado = ""; 
                    
                    for (i = 1; i <= repeticiones; i++) {
                        resultado += palabraModificada;  
                        if (i < repeticiones) {
                            resultado += " ";
                        }
                    }
                    System.out.println(resultado);
                    break;

                case 6:
                    System.out.println("Muchas gracias y hasta pronto.");
                    break;

                default:
                    System.out.println("Error: Opción no válida.");
                    break;
            }

        } while (opcion != 6);

        sc.close();
    }
}