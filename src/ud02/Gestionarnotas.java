package ud02;

/*PROGRAMA PARA GESTIONAR NOTAS

Crea el programa “Gestionarnotas”.
El programa pedirá usuario y contraseña.
Si en la contraseña está la letra “e” mostrará un mensaje de ERROR 
y pedirá de nuevo el usuario y la contraseña hasta que no exista la letra “e” en la contraseña.
(Utiliza indexOf y ten en cuenta las mayúsculas y minúsculas).

Introduce tu usuario: AntonioR
Introduce tu contraseña: 136ae
ERROR, en la contraseña no puede aparecer la letra e. Introduce de nuevo, por favor:
Introduce tu usuario: AntonioR
Introduce tu contraseña: 136aa

Después, aparecerá el siguiente menú:
1.- Introducir notas. Pedirá los datos del alumno (nombre y apellido). Después, calculará la nota final, utilizando la siguiente fórmula:
La media de los 3 exámenes parciales es el 55%.
La nota obtenida en el último examen es el 30%.
La nota obtenida en el último trabajo es el 15%.
¡Atención! Las notas introducidas no pueden ser negativas, ni mayores de 10.
Después de introducir todas las notas, deberá aparecer un mensaje como este:

La nota final del alumno Jon Perez es 5, suficiente.

Hay que tener en cuenta la siguiente tabla:
0-4,9 SUSPENSO
5-5,9 SUFICIENTE
6-6,9 BIEN
7-8,9 NOTABLE
9-10 SOBRESALIENTE

Introducir la nota del examen 1: 5
Introducir la nota del examen 2: 7
Introducir la nota del examen 3: -2
ERROR! La nota no puede ser negativa.
Introducir la nota del examen 3: 2
Introducir la nota del último examen: 4
Introducir la nota del trabajo: 9
La nota final del alumno Jon Perez es 5, suficiente.

2 .- Salir del programa.
Dar las gracias al usuario y finaliza el programa.
Muchas gracias y hasta pronto.
*/

import java.util.Scanner;

public class Gestionarnotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user, password;
        int opcion;
        double ex1, ex2, ex3, ultimoEx, trabajo, mediaParciales, notaFinal;

        //usuario y contraseña
        System.out.print("Introduce tu usuario: ");
        user = sc.nextLine();
        System.out.print("Introduce tu contraseña: ");
        password = sc.nextLine();

        //validacion e/E
        while (password.toLowerCase().indexOf('e') != -1) {
            System.out.println("ERROR, en la contraseña no puede aparecer la letra e. Introduce de nuevo, por favor:");
            System.out.print("Introduce tu usuario: ");
            user = sc.nextLine();
            System.out.print("Introduce tu contraseña: ");
            password = sc.nextLine();
        }

        //menu
        do {
            System.out.println("MENÚ");
            System.out.println("1.- Introducir notas");
            System.out.println("2.- Salir del programa");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); //limpia el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre y apellido del alumno: ");
                    String alumno = sc.nextLine();

                    System.out.print("Introduce la nota del primer exámen: ");
                    ex1 = sc.nextDouble();
                    while (ex1 < 0 || ex1 > 10) {
                        System.out.println("ERROR! La nota no puede ser negativa ni mayor de 10.");
                        System.out.print("Introduce la nota del primer exámen: ");
                        ex1 = sc.nextDouble();
                    }
                    System.out.print("Introduce la nota del segundo exámen: ");
                    ex2 = sc.nextDouble();
                    while (ex2 < 0 || ex2 > 10) {
                        System.out.println("ERROR! La nota no puede ser negativa ni mayor de 10.");
                        System.out.print("Introduce la nota del segundo exámen: ");
                        ex2 = sc.nextDouble();
                    }
                    System.out.print("Introduce la nota del tercer exámen: ");
                    ex3 = sc.nextDouble();
                    while (ex3 < 0 || ex3 > 10) {
                        System.out.println("ERROR! La nota no puede ser negativa ni mayor de 10.");
                        System.out.print("Introduce la nota del tercer exámen: ");
                        ex3 = sc.nextDouble();
                    }
                    System.out.print("Introduce la nota del último exámen: ");
                    ultimoEx = sc.nextDouble();
                    while (ultimoEx < 0 || ultimoEx > 10) {
                        System.out.println("ERROR! La nota no puede ser negativa ni mayor de 10.");
                        System.out.print("Introduce la nota del último exámen: ");
                        ultimoEx = sc.nextDouble();
                    }
                    System.out.print("Introduce la nota del trabajo final: ");
                    trabajo = sc.nextDouble();
                    while (trabajo < 0 || trabajo > 10) {
                        System.out.println("ERROR! La nota no puede ser negativa ni mayor de 10.");
                        System.out.print("Introduce la nota del trabajo final: ");
                        trabajo = sc.nextDouble();
                    }
                
             
                   mediaParciales = (ex1 + ex2 + ex3) / 3.0;
                   notaFinal = (mediaParciales * 0.55) + (ultimoEx * 0.30) + (trabajo * 0.15);

                   //calificación texto
                   String calificacion = "";
                   if (notaFinal >= 0 && notaFinal < 5) {
                       calificacion = "Suspenso";
                   } else if (notaFinal >= 5 && notaFinal < 6) {
                       calificacion = "Suficiente";
                   } else if (notaFinal >= 6 && notaFinal < 7) {
                       calificacion = "Bien";
                   } else if (notaFinal >= 7 && notaFinal < 9) {
                       calificacion = "Notable";
                   } else if (notaFinal >= 9 && notaFinal <= 10) {
                       calificacion = "Sobresaliente";
                   }

                   System.out.println("______________________________________________");
                   System.out.println("La nota final del alumno " +alumno+ "usuario(" +user+ ") es: "
                   +notaFinal+ ", " +calificacion);
                   System.out.println("______________________________________________");
                   break;

                case 2:
                    System.out.println("Muchas gracias y hasta pronto.");
                    break;

                default:
                    System.out.println("ERROR: Opción no válida. Introduce 1 o 2.");
                    break;
            }

        } while (opcion != 2);

        sc.close();
    }
}