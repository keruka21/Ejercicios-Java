package ud04;
/*Documento Word - Ejercicio 4

Vamos a crear un programa que me gestione personas. Nuestro programa podrá manipular hasta 10 personas distintas.

Basándote en el ejercicio 2, crea una aplicación que gestione el siguiente menú repetitivo.

    1. Introducir las personas (pedimos los datos de TODAS las personas y los almacenamos para usos posteriores).
    2. Muestra la persona de mayor edad.
    3. Muestra la información de una persona tras introducir su DNI.
    4. Muestra la información de todas las personas.
    5. Salir.
*/

import java.util.Scanner;

public class Ej4PrincipalGestionPersonas {

    //5 salir
    public static void salir() {
        System.out.println("Saliendo del programa. Hasta pronto :-)");
    }

    //1 introducir personas
    public static void introducirDatosPersonas(Ej2Persona2[] aPersonas, Scanner sc) {
        boolean hayEspacio = false;

        for (int i = 0; i < aPersonas.length; i++) {
            if (aPersonas[i] == null) {
                hayEspacio = true;
            }
        }

        if (hayEspacio) {
            System.out.println("Introducir los datos de las personas.");

            for (int i = 0; i < aPersonas.length; i++) {
                if (aPersonas[i] == null) {
                    System.out.println("Introduce los datos de la persona " + (i + 1) + ":");

                    System.out.println("Nombre:");
                    String nombre = sc.next();

                    System.out.println("Edad:");
                    int edad = sc.nextInt();

                    System.out.println("DNI:");
                    String dni = sc.next();

                    aPersonas[i] = new Ej2Persona2(nombre, edad, dni);
                }
            }
        } else {
            System.out.println("No hay espacio para introducir más personas.");
        }
    }

    //2 mostrar la persona de más edad
    public static void muestraMayor(Ej2Persona2[] aPersonas) {
        int posicionMayor = -1;

        for (int i = 0; i < aPersonas.length; i++) {
            if (aPersonas[i] != null) {
                if (posicionMayor == -1) {
                    posicionMayor = i;
                } else {
                    if (aPersonas[i].getEdad() > aPersonas[posicionMayor].getEdad()) {
                        posicionMayor = i;
                    }
                }
            }
        }

        if (posicionMayor == -1) {
            System.out.println("No hay personas introducidas.");
        } else {
            System.out.println("La persona de mayor edad es:");
            aPersonas[posicionMayor].mostrar();
        }
    }

    //3 buscar x DNI
    public static void muestraPorDni(Ej2Persona2[] aPersonas, Scanner sc) {
        boolean encontrado = false;

        System.out.println("Introduce el DNI de la persona:");
        String dniBuscado = sc.next();

        for (int i = 0; i < aPersonas.length; i++) {
            if (aPersonas[i] != null) {
                if (aPersonas[i].getDni().equalsIgnoreCase(dniBuscado)) {
                    System.out.println("Persona encontrada:");
                    aPersonas[i].mostrar();
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se ha encontrado ninguna persona con ese DNI.");
        }
    }

    //4 mostrar toda la información
    public static void mostrarTodaInfo(Ej2Persona2[] aPersonas) {
        boolean vacio = true;

        System.out.println("Mostrar todos los datos de las personas.");

        for (int i = 0; i < aPersonas.length; i++) {
            if (aPersonas[i] != null) {
                System.out.println("--- Persona " + (i + 1) + " ---");
                aPersonas[i].mostrar();
                vacio = false;
            }
        }

        if (vacio) {
            System.out.println("No hay personas introducidas.");
        }
    }

    public static void main(String[] args) {
        Ej2Persona2[] aPersonas = new Ej2Persona2[10];
        Scanner sc = new Scanner(System.in);
        int opcion;

        System.out.println("Bienvenid@");

        do {
			System.out.println("--------------------------------");
            System.out.println("--------------MENÚ--------------");
            System.out.println("1. Introducir todas las personas.");
            System.out.println("2. Mostrar la persona de mayor edad.");
            System.out.println("3. Mostrar una persona por DNI.");
            System.out.println("4. Mostrar todas las personas.");
            System.out.println("5. Salir.");
            System.out.println("¿Qué quieres hacer?");

            opcion = sc.nextInt();
			System.out.println("--------------------------------");

            switch (opcion) {
                case 1:
                    introducirDatosPersonas(aPersonas, sc);
                    break;

                case 2:
                    muestraMayor(aPersonas);
                    break;

                case 3:
                    muestraPorDni(aPersonas, sc);
                    break;

                case 4:
                    mostrarTodaInfo(aPersonas);
                    break;

                case 5:
                    salir();
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (opcion != 5);

        sc.close();
    }
}