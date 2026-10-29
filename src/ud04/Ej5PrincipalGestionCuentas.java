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

    //10 salir del programa
    public static void salir() {
        System.out.println("Saliendo del programa. Hasta pronto :-)");
    }

    //comprobar si hay cuentas
    public static boolean hayCuentas(Ej1Cuenta[] aCuentas) {
        boolean tenemosCuentas = false;

        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                tenemosCuentas = true;
            }
        }
        return tenemosCuentas;
    }

    //1 introducir cuentas
    public static void introducirCuentas(Ej1Cuenta[] aCuentas, Scanner sc) {
        int posLibres = 0; //elementos libres en el array (null)
        int num; //numero de cuentas nuevas introducidas x usuario
        int introducidas; //contador de nuevas cuentas
        String titular;
        double cantidad;

        //comprobar cuantas cuentas estan libres
        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] == null) {
                posLibres++;
            }
        }
        
        //si no hay no hace nada, si hay introducimos numero de cuentas nuevas
        if (posLibres == 0) {
            System.out.println("No hay espacio para más cuentas.");
        } else {
            System.out.println("¿Cuántas cuentas quieres introducir?");
            num = sc.nextInt();
            //validacion de num
            if (num <= 0) {
                System.out.println("Introduce al menos una cuenta.");
            } else if (num > posLibres) {
                System.out.println("Solo puedes introducir " + posLibres + " cuentas.");
            } else {
                //insertar las cuentas en las posiciones libres
                for (i = 0; i < aCuentas.length && introducidas < num; i++) {
                    if (aCuentas[i] == null) {
                        System.out.println("Introduce el titular de la cuenta:");
                        titular = sc.next();

                        System.out.println("Introduce la cantidad:");
                        cantidad = sc.nextDouble();
                        while (cantidad < 0) {
                            System.out.println("ERROR. Introduce una cantidad válida:");
                            cantidad = sc.nextDouble();
                        }

                        aCuentas[i] = new Ej1Cuenta(titular); //elemento del array -> nuevo objeto clase persona
                        aCuentas[i].setCantidad(cantidad); //definimos el valor del atributo cantidad del objeto nuevo

                        introducidas++;
                    }
                }
                System.out.println("Cuentas introducidas correctamente.");
            }
        }
    }

   
    //2 mostrar todas las cuentas
    public static void mostrarCuentas(Ej1Cuenta[] aCuentas) {
        boolean vacio = true;

        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                System.out.println("-------------Cuenta " + (i + 1) + "-------------");
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
        boolean encontrado = false;
        String titularBuscado;
        double cantidad;
        
        System.out.println("Introduce el titular de la cuenta:");
        titularBuscado = sc.next();
        
        for (int i = 0; i < aCuentas.length; i++) {
            if (aCuentas[i] != null) {
                if (aCuentas[i].getTitular().equalsIgnoreCase(titularBuscado)) {
                    System.out.println("Introduce la cantidad a ingresar:");
                    cantidad = sc.nextDouble();

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

    //4 retirar la comisión de 12 € con el metodo del ejercicio 1
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
                    if (aCuentas[i].getCantidad() > aCuentas[posicionMayor].getCantidad()) {
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
        double saldoMinimo;
        boolean encontrado;
        
        System.out.println("Introduce el saldo mínimo:");
        saldoMinimo = sc.nextDouble();
        encontrado = false;

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
        String titularBuscado;
        boolean encontrado;
        
        System.out.println("Introduce el titular que quieres buscar:");
        titularBuscado = sc.next();

        encontrado = false;

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
        String letras;
        boolean encontrado;
        
        System.out.println("Introduce las letras que quieres buscar:");
        letras = sc.next();

        encontrado = false;

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
        Ej1Cuenta temporal;

        for (int i = 0; i < aCuentas.length - 1; i++) {
            for (int j = 0; j < aCuentas.length - 1 - i; j++) {
                if (aCuentas[j] == null) {
                    if (aCuentas[j + 1] != null) {
                        temporal = aCuentas[j];
                        aCuentas[j] = aCuentas[j + 1];
                        aCuentas[j + 1] = temporal;
                    }
                } else if (aCuentas[j + 1] != null) {
                    if (aCuentas[j].getCantidad()
                            < aCuentas[j + 1].getCantidad()) {
                        temporal = aCuentas[j];
                        aCuentas[j] = aCuentas[j + 1];
                        aCuentas[j + 1] = temporal;
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
