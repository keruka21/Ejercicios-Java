package ud04;
/*Documento Word - Ejercicio 5

Vamos a crear un programa que me gestione las cuentas de un banco.
Nuestro programa podrá manipular hasta 50 cuentas distintas.

Basándote en el ejercicio 1, crea una aplicación que gestione el siguiente menú repetitivo:

    1. Introducir cuenta/s.

    OJO: Como máximo hay 50 cuentas, lo que no significa que al elegir esta opción introduzca las 50.
    Controlar, eso sí, que no pueda introducir más de 50.

    2. Muestra las cuentas introducidas.
    3. Ingresar una cantidad a un titular concreto introducido por teclado (Llama al método ingresar
    y controla la posibilidad de que no exista el titular).
    4. Retirar de todas las cuentas introducidas, la comisión de 12€ (Llama al método retirar).
    5. Muestra la cuenta de mayor saldo.
    6. Muestras las cuentas que tengan saldo superior a uno introducido por teclado. Si no hay, mensaje indicándolo.
    7. Muestra la cuenta de un titular concreto. Controlar si no encuentra.
    8. Muestra las cuentas de los titulares que contengan un grupo de letras, introducido por teclado, en su atributo titular.
    9. Ordena y muestra las cuentas según su saldo (de mayor a menor saldo).
    10. Salir

En todas las opciones a partir de la 1, controlar previamente si hay o no cuentas introducidas.
Vamos a suponer que las cuentas son únicas (no hay titulares que se repiten).
*/

import java.util.Scanner;

public class Ej5PrincipalGestionCuentas {

    //10 salir
    public static void salir() {
        System.out.println("Saliendo del programa. Hasta pronto :-)");
    }

    //1 introducir cuentas
    public static void introducirCuentas(Ej1Cuenta[] aCuentas, Scanner sc) {
        int libres = 0;

        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] == null) {
                libres++;
            }
        }

        if (libres == 0) {
            System.out.println("No hay espacio para más cuentas.");
        } else {
            System.out.println("¿Cuántas cuentas quieres introducir?");
            int num = sc.nextInt();

            if (num <= 0) {
                System.out.println("Debes introducir al menos una cuenta.");
            } else if (num > libres) {
                System.out.println("Solo puedes introducir " + libres + " cuentas.");
            } else {
                int introducidas = 0;

                for (int i = 0; i < aCuentas.length; i++) {
                    if (aCuentas[i] == null && introducidas < num) {
                        System.out.println("Introduce el titular de la cuenta:");
                        String titular = sc.next();

                        System.out.println("Introduce la cantidad:");
                        double cantidad = sc.nextDouble();

                        aCuentas[i] = new Ej1Cuenta(titular);
                        aCuentas[i].setCantidad(cantidad);

                        introducidas++;
                    }
                }

                System.out.println("Cuentas introducidas correctamente.");
            }
        }
    }

    //comprobar si hay cuentas
    public static boolean hayCuentas(Ej1Cuenta[] aCuentas) {
        boolean hay = false;

        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                hay = true;
            }
        }
        return hay;
    }

    //2 mostrar todas las cuentas
    public static void mostrarCuentas(Ej1Cuenta[] aCuentas) {
        boolean vacio = true;

        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                System.out.println("--- Cuenta " + (i + 1) + " ---");
                System.out.println(aCuentas[i]);
                vacio = false;
            }
        }

        if (vacio) {
            System.out.println("No hay cuentas introducidas.");
        }
    }

    //3 ingresar una cantidad
    public static void ingresarCuenta(Ej1Cuenta[] aCuentas, Scanner sc) {
        System.out.println("Introduce el titular de la cuenta:");
        String titularBuscado = sc.next();

        boolean encontrado = false;

        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                if (aCuentas[i].getTitular().equalsIgnoreCase(titularBuscado)) {
                    System.out.println("Introduce la cantidad que quieres ingresar:");
                    double cantidad = sc.nextDouble();

                    aCuentas[i].ingresarCant(cantidad);

                    System.out.println("Ingreso realizado.");
                    System.out.println(aCuentas[i]);

                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No existe ninguna cuenta con ese titular.");
        }
    }

    //4 retirar la comisión de 12 €
    public static void cobrarComision(Ej1Cuenta[] aCuentas) {
        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                aCuentas[i].retirar(12);
            }
        }

        System.out.println("Se ha cobrado la comisión de 12 euros.");
    }

    //5 mostrar la cuenta con más saldo
    public static void cuentaMayorSaldo(Ej1Cuenta[] aCuentas) {
        int posicionMayor = -1;

        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                if (posicionMayor == -1) {
                    posicionMayor = i;
                } else {
                    if (aCuentas[i].getCantidad()
                            > aCuentas[posicionMayor].getCantidad()) {
                        posicionMayor = i;
                    }
                }
            }
        }

        if (posicionMayor == -1) {
            System.out.println("No hay cuentas introducidas.");
        } else {
            System.out.println("La cuenta con mayor saldo es:");
            System.out.println(aCuentas[posicionMayor]);
        }
    }

    //6 mostrar cuentas con saldo superior a una cantidad
    public static void cuentasPorSaldo(Ej1Cuenta[] aCuentas, Scanner sc) {
        System.out.println("Introduce el saldo mínimo:");
        double saldoMinimo = sc.nextDouble();

        boolean encontrado = false;

        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                if (aCuentas[i].getCantidad() > saldoMinimo) {
                    System.out.println(aCuentas[i]);
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No hay cuentas con saldo superior a esa cantidad.");
        }
    }

    //7 mostrar la cuenta de un titular concreto
    public static void buscarTitular(Ej1Cuenta[] aCuentas, Scanner sc) {
        System.out.println("Introduce el titular que quieres buscar:");
        String titularBuscado = sc.next();

        boolean encontrado = false;

        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                if (aCuentas[i].getTitular().equalsIgnoreCase(titularBuscado)) {
                    System.out.println(aCuentas[i]);
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se ha encontrado ese titular.");
        }
    }

    //8 buscar titulares que contengan un grupo de letras
    public static void buscarPorLetras(Ej1Cuenta[] aCuentas, Scanner sc) {
        System.out.println("Introduce las letras que quieres buscar:");
        String letras = sc.next();

        boolean encontrado = false;

        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                if (aCuentas[i].getTitular().toLowerCase().contains(letras.toLowerCase())) {
                    System.out.println(aCuentas[i]);
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No hay titulares que contengan esas letras.");
        }
    }

    //9 ordenar las cuentas de mayor a menor saldo (método de la burbúja)
    public static void ordenarCuentas(Ej1Cuenta[] aCuentas) {
        Ej1Cuenta auxiliar;

        for (int i = 0; i < aCuentas.length - 1; i++) {
            for (int j = 0; j < aCuentas.length - 1 - i; j++) {
                if (aCuentas[j] == null) {
                    if (aCuentas[j + 1] != null) {
                        auxiliar = aCuentas[j];
                        aCuentas[j] = aCuentas[j + 1];
                        aCuentas[j + 1] = auxiliar;
                    }
                } else if (aCuentas[j + 1] != null) {
                    if (aCuentas[j].getCantidad()
                            < aCuentas[j + 1].getCantidad()) {
                        auxiliar = aCuentas[j];
                        aCuentas[j] = aCuentas[j + 1];
                        aCuentas[j + 1] = auxiliar;
                    }
                }
            }
        }

        System.out.println("Cuentas ordenadas de mayor a menor saldo:");
        mostrarCuentas(aCuentas);
    }

    public static void main(String[] args) {
        Ej1Cuenta[] aCuentas = new Ej1Cuenta[50];
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENÚ DE CUENTAS");
            System.out.println("1. Introducir cuentas.");
            System.out.println("2. Mostrar todas las cuentas.");
            System.out.println("3. Ingresar una cantidad a un titular.");
            System.out.println("4. Cobrar comisión de 12 euros.");
            System.out.println("5. Mostrar la cuenta de mayor saldo.");
            System.out.println("6. Mostrar cuentas por saldo.");
            System.out.println("7. Buscar una cuenta por titular.");
            System.out.println("8. Buscar titulares por letras.");
            System.out.println("9. Ordenar cuentas por saldo.");
            System.out.println("10. Salir.");
            System.out.println("¿Qué quieres hacer?");

            opcion = sc.nextInt();

            if (opcion == 1) {
                introducirCuentas(aCuentas, sc);
            } else if (opcion >= 2 && opcion <= 9) {
                if (hayCuentas(aCuentas)) {
                    switch (opcion) {
                        case 2:
                            mostrarCuentas(aCuentas);
                            break;

                        case 3:
                            ingresarCuenta(aCuentas, sc);
                            break;

                        case 4:
                            cobrarComision(aCuentas);
                            break;

                        case 5:
                            cuentaMayorSaldo(aCuentas);
                            break;

                        case 6:
                            cuentasPorSaldo(aCuentas, sc);
                            break;

                        case 7:
                            buscarTitular(aCuentas, sc);
                            break;

                        case 8:
                            buscarPorLetras(aCuentas, sc);
                            break;

                        case 9:
                            ordenarCuentas(aCuentas);
                            break;
                    }
                } else {
                    System.out.println("Primero debes introducir alguna cuenta.");
                }
            } else if (opcion == 10) {
                salir();
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 10);

        sc.close();
    }
}
