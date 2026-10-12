package ud02;

/*Ejercicio 46
Realiza la clase Java Menumeses que lee por teclado un String con el nombre del mes por pantalla y muestra el número de mes que le corresponde.
*/

import java.util.Scanner;

public class Ej46Menumeses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada, mes;

        System.out.print("Introduce el nombre de un mes: ");
        entrada = sc.nextLine().trim();

        //formatear la entrada: Primera letra en mayúscula y el resto en minúscula
        if (entrada.length() > 0) {
            mes = entrada.substring(0, 1).toUpperCase() + entrada.substring(1).toLowerCase();
        } else {
            mes = "";
        }

        switch (mes) {
            case "Enero":
                System.out.println("Enero es el mes 1");
                break;
            case "Febrero":
                System.out.println("Febrero es el mes 2");
                break;
            case "Marzo":
                System.out.println("Marzo es el mes 3");
                break;
            case "Abril":
                System.out.println("Abril es el mes 4");
                break;
            case "Mayo":
                System.out.println("Mayo es el mes 5");
                break;
            case "Junio":
                System.out.println("Junio es el mes 6");
                break;
            case "Julio":
                System.out.println("Julio es el mes 7");
                break;
            case "Agosto":
                System.out.println("Agosto es el mes 8");
                break;
            case "Septiembre":
                System.out.println("Septiembre es el mes 9");
                break;
            case "Octubre":
                System.out.println("Octubre es el mes 10");
                break;
            case "Noviembre":
                System.out.println("Noviembre es el mes 11");
                break;
            case "Diciembre":
                System.out.println("Diciembre es el mes 12");
                break;
            default:
                System.out.println("ERROR: Mes no válido.");
                break;
        }

        sc.close();
    }
}