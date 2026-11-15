package examenes;

/*Crea un programa principal con un menú repetitivo que gestione el almacenamiento de hasta 25 dispositivos. El menú mostrará las siguientes opciones (cada una implementada con un método estático). 
Ten en cuenta que las opciones 2 a 6 no podrán ejecutarse si aún no se ha añadido ningún dispositivo. Controla los errores y muestra mensajes informativos cuando proceda.
El array no estará necesariamente compactado, es decir, puede contener posiciones vacías entre elementos almacenados.

1.Añadir un nuevo dispositivo: El programa permitirá añadir un nuevo dispositivo al almacenamiento, siempre que no se haya alcanzado el límite máximo de 25 dispositivos. Cada dispositivo deberá tener un nombre único, por lo que no se permitirá registrar dos dispositivos con el mismo nombre. Además, el campo tipo solo podrá tomar uno de los siguientes valores válidos: “móvil”, “tablet” o “portátil”.
	1
	Nombre del dispositivo: Mac
	Tipo (movil / tablet / portatil): ordenador
	Tipo no válido. Debe ser 'movil', 'tablet' o 'portatil'. Inténtalo de nuevo.
	Tipo (movil / tablet / portatil): movil
	Precio (€): -5
	El precio debe ser un número positivo.
	Precio (€): 100
	Consumo (W): -6
	El consumo debe ser un número positivo.
	Consumo (W): 60
	Peso (kg): -3
	El peso debe ser un número positivo.
	Peso (kg): 3
	Dispositivo añadido correctamente.
	1
	Nombre del dispositivo: Mac
	Ya existe un dispositivo con ese nombre. Introduce otro.
	Nombre del dispositivo:
2.Mostrar dispositivos eficientes: Esta opción mostrará todos los dispositivos eficientes, esto es con un consumo menor a 100 W. En caso de que no haya ningún dispositivo que cumpla esta condición, se mostrará un mensaje informativo indicándolo.
	2
	Dispositivo{nombre='Iphone', tipo='tablet', precio=9000.0, consumo=3, peso=3.0, eficiente=true, indicePortabilidad=6.3}
	Dispositivo{nombre='HP', tipo='portatil', precio=87.0, consumo=30, peso=9.0, eficiente=true, indicePortabilidad=21.0}
3.Ordenar por precio descendente: Ordenará los dispositivos almacenados según su precio, desde el valor más alto hasta el más bajo, y los mostrará por pantalla en ese orden.
	3
	Dispositivo{nombre='MovilB', tipo='movil', precio=450.0, consumo=60, peso=0.16, eficiente=true, indicePortabilidad=6.32}
	Dispositivo{nombre='MovilA', tipo='movil', precio=300.0, consumo=50, peso=0.15, eficiente=true, indicePortabilidad=5.3}
	Dispositivo{nombre='MovilC', tipo='movil', precio=250.0, consumo=40, peso=0.14, eficiente=true, indicePortabilidad=4.28}
4.Actualizar precio de un dispositivo concreto. Solicitará al usuario el nombre de un dispositivo y un nuevo precio. Si el dispositivo existe, se actualizará su precio con el nuevo valor indicado.En caso contrario, se mostrará un mensaje advirtiendo de que el dispositivo no se ha encontrado.
	4
	Introduce el nombre del dispositivo a actualizar: asus
	No se encontró ningún dispositivo con ese nombre.
	4
	Introduce el nombre del dispositivo a actualizar: iphone
	Introduce el nuevo precio (€): 1200
	Precio actualizado correctamente.
5.Eliminar dispositivo: Se pedirá al usuario el nombre de un dispositivo y, si existe, se borrará del array dejando su posición vacía (no se compactará el array). Si no se encuentra ningún dispositivo con el nombre introducido, se mostrará un mensaje informativo que lo indique.
	5
	Introduce el nombre del dispositivo a eliminar: asus
	No se encontró ningún dispositivo con ese nombre.
	5
	Introduce el nombre del dispositivo a eliminar: iphone
	Dispositivo eliminado correctamente.
6. Mostrar todos los dispositivos: Mostrará todos los dispositivos almacenados, con la información completa de cada uno.
	6
	Dispositivo{nombre='Mac', tipo='movil', precio=100.0, consumo=60, peso=3.0, eficiente=true, indicePortabilidad=12.0}
	Dispositivo{nombre='Iphone', tipo='movil', precio=300.0, consumo=30, peso=2.0, eficiente=true, indicePortabilidad=7.0}
7. Salir del programa: Finaliza la ejecución del programa y muestra un mensaje de despedida.
*/

import java.util.Scanner;

public class DispositivoMain {

    // Método auxiliar: comprobar si el array está completamente vacío
    public static boolean estaVacio(Dispositivo[] aDispositivos) {
        boolean vacio = true;
        int i = 0;
        while (i < aDispositivos.length && vacio) {
            if (aDispositivos[i] != null) {
                vacio = false;
            }
            i++;
        }
        return vacio;
    }

    // Método auxiliar: buscar dispositivo por nombre (devuelve la posición o -1 si no existe)
    public static int buscarDispositivo(Dispositivo[] aDispositivos, String nombre) {
        int posicion = -1;
        boolean encontrado = false;
        int i = 0;

        while (i < aDispositivos.length && !encontrado) {
            if (aDispositivos[i] != null && aDispositivos[i].getNombre().equalsIgnoreCase(nombre)) {
                posicion = i;
                encontrado = true;
            }
            i++;
        }
        return posicion;
    }

    // 1. Añadir un nuevo dispositivo
    public static void addDispositivo(Dispositivo[] aDispositivos, Scanner sc) {
        int posLibre = -1;
        boolean encontradoLibre = false;
        int i = 0;

        // Buscar la primera posición libre (el array no se compacta)
        while (i < aDispositivos.length && !encontradoLibre) {
            if (aDispositivos[i] == null) {
                posLibre = i;
                encontradoLibre = true;
            }
            i++;
        }

        if (posLibre == -1) {
            System.out.println("Error: Se ha alcanzado el límite máximo de 25 dispositivos.");
            return;
        }

        // Pedir nombre único
        String nombre = "";
        boolean nombreValido = false;
        while (!nombreValido) {
            System.out.print("Nombre del dispositivo: ");
            nombre = sc.nextLine();
            if (buscarDispositivo(aDispositivos, nombre) != -1) {
                System.out.println("Ya existe un dispositivo con ese nombre. Introduce otro.");
            } else if (nombre.trim().isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            } else {
                nombreValido = true;
            }
        }

        // Pedir tipo válido (“móvil”, “tablet” o “portátil”)
        String tipo = "";
        boolean tipoValido = false;
        while (!tipoValido) {
            System.out.print("Tipo (movil / tablet / portatil): ");
            tipo = sc.nextLine().trim();
            if (tipo.equalsIgnoreCase("movil") || tipo.equalsIgnoreCase("tablet") || tipo.equalsIgnoreCase("portatil") ||
                tipo.equalsIgnoreCase("móvil") || tipo.equalsIgnoreCase("portátil")) {
                tipoValido = true;
            } else {
                System.out.println("Tipo no válido. Debe ser 'movil', 'tablet' o 'portatil'. Inténtalo de nuevo.");
            }
        }

        // Pedir precio positivo
        double precio = -1;
        while (precio < 0) {
            System.out.print("Precio (€): ");
            if (sc.hasNextDouble()) {
                precio = sc.nextDouble();
                if (precio < 0) {
                    System.out.println("El precio debe ser un número positivo.");
                }
            } else {
                System.out.println("Introduce un número válido.");
                sc.next();
            }
        }

        // Pedir consumo positivo
        int consumo = -1;
        while (consumo < 0) {
            System.out.print("Consumo (W): ");
            if (sc.hasNextInt()) {
                consumo = sc.nextInt();
                if (consumo < 0) {
                    System.out.println("El consumo debe ser un número positivo.");
                }
            } else {
                System.out.println("Introduce un número entero válido.");
                sc.next();
            }
        }

        // Pedir peso positivo
        double peso = -1;
        while (peso < 0) {
            System.out.print("Peso (kg): ");
            if (sc.hasNextDouble()) {
                peso = sc.nextDouble();
                if (peso < 0) {
                    System.out.println("El peso debe ser un número positivo.");
                }
            } else {
                System.out.println("Introduce un número válido.");
                sc.next();
            }
        }
        sc.nextLine(); // Limpiar el buffer

        // Crear e insertar el objeto en la posición libre encontrada
        aDispositivos[posLibre] = new Dispositivo(nombre, tipo, precio, consumo, peso);
        System.out.println("Dispositivo añadido correctamente.");
    }
    
    // 2. Mostrar dispositivos eficientes (consumo < 100 W)
    public static void mostrarEficientes(Dispositivo[] aDispositivos) {
        if (estaVacio(aDispositivos)) {
            System.out.println("Error: No hay dispositivos registrados en el sistema.");
            return;
        }

        int contador = 0;
        int i = 0;
        while (i < aDispositivos.length) {
            if (aDispositivos[i] != null && aDispositivos[i].esEficiente()) {
                System.out.println(aDispositivos[i].toString());
                contador++;
            }
            i++;
        }

        if (contador == 0) {
            System.out.println("No hay ningún dispositivo eficiente (con consumo menor a 100 W).");
        }
    }

    // 3. Ordenar por precio descendente usando array auxiliar y burbuja
    public static void ordenarPrecioDesc(Dispositivo[] aDispositivos) {
        if (estaVacio(aDispositivos)) {
            System.out.println("Error: No hay dispositivos registrados en el sistema.");
            return;
        }

        // Contar cuántos dispositivos hay registrados
        int total = 0;
        int i = 0;
        while (i < aDispositivos.length) {
            if (aDispositivos[i] != null) {
                total++;
            }
            i++;
        }

        // Crear array temporal para no alterar las posiciones nulas del array original
        Dispositivo[] auxiliar = new Dispositivo[total];
        int idx = 0;
        i = 0;
        while (i < aDispositivos.length) {
            if (aDispositivos[i] != null) {
                auxiliar[idx] = aDispositivos[i];
                idx++;
            }
            i++;
        }

        // Algoritmo de ordenación burbuja descendente por precio
        int j;
        Dispositivo aux;
        for (i = 0; i < auxiliar.length - 1; i++) {
            for (j = 0; j < auxiliar.length - 1 - i; j++) {
                if (auxiliar[j].getPrecio() < auxiliar[j + 1].getPrecio()) {
                    aux = auxiliar[j];
                    auxiliar[j] = auxiliar[j + 1];
                    auxiliar[j + 1] = aux;
                }
            }
        }

        // Mostrar ordenados
        System.out.println("Dispositivos ordenados por precio descendente:");
        for (i = 0; i < auxiliar.length; i++) {
            System.out.println(auxiliar[i].toString());
        }
    }

    // 4. Actualizar precio de un dispositivo concreto
    public static void cambiarPrecio(Dispositivo[] aDispositivos, Scanner sc) {
        if (estaVacio(aDispositivos)) {
            System.out.println("Error: No hay dispositivos registrados en el sistema.");
            return;
        }

        System.out.print("Introduce el nombre del dispositivo a actualizar: ");
        String nombre = sc.nextLine();
        int posicion = buscarDispositivo(aDispositivos, nombre);

        if (posicion == -1) {
            System.out.println("No se encontró ningún dispositivo con ese nombre.");
        } else {
            double nuevoPrecio = -1;
            while (nuevoPrecio < 0) {
                System.out.print("Introduce el nuevo precio (€): ");
                if (sc.hasNextDouble()) {
                    nuevoPrecio = sc.nextDouble();
                    if (nuevoPrecio < 0) {
                        System.out.println("El precio debe ser un número positivo.");
                    }
                } else {
                    System.out.println("Introduce un número válido.");
                    sc.next();
                }
            }
            sc.nextLine(); // Limpiar buffer
            aDispositivos[posicion].setPrecio(nuevoPrecio);
            System.out.println("Precio actualizado correctamente.");
        }
    }

    // 5. Eliminar dispositivo (dejando la posición vacía a null, sin compactar)
    public static void eliminarDispositivo(Dispositivo[] aDispositivos, Scanner sc) {
        if (estaVacio(aDispositivos)) {
            System.out.println("Error: No hay dispositivos registrados en el sistema.");
            return;
        }

        System.out.print("Introduce el nombre del dispositivo a eliminar: ");
        String nombre = sc.nextLine();
        int posicion = buscarDispositivo(aDispositivos, nombre);

        if (posicion == -1) {
            System.out.println("No se encontró ningún dispositivo con ese nombre.");
        } else {
            aDispositivos[posicion] = null;
            System.out.println("Dispositivo eliminado correctamente.");
        }
    }

    // 6. Mostrar todos los dispositivos registrados
    public static void mostrarDispositivos(Dispositivo[] aDispositivos) {
        if (estaVacio(aDispositivos)) {
            System.out.println("Error: No hay dispositivos registrados en el sistema.");
            return;
        }

        int i = 0;
        while (i < aDispositivos.length) {
            if (aDispositivos[i] != null) {
                System.out.println(aDispositivos[i].toString());
            }
            i++;
        }
    }

    // 7. Salir del programa
    public static void salir() {
        System.out.println("¡Hasta pronto :-)! Finalizando el programa de gestión de dispositivos.");
    }

    // MÉTODO PRINCIPAL MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dispositivo[] aDispositivos = new Dispositivo[25];
        int opcion = 0;

        do {
            System.out.println("\n----- MENÚ DE GESTIÓN DE DISPOSITIVOS -----");
            System.out.println("1. Añadir un nuevo dispositivo");
            System.out.println("2. Mostrar dispositivos eficientes");
            System.out.println("3. Ordenar por precio descendente");
            System.out.println("4. Actualizar precio de un dispositivo concreto");
            System.out.println("5. Eliminar dispositivo");
            System.out.println("6. Mostrar todos los dispositivos");
            System.out.println("7. Salir del programa");
            System.out.print("Elige una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        addDispositivo(aDispositivos, sc);
                        break;
                    case 2:
                        mostrarEficientes(aDispositivos);
                        break;
                    case 3:
                        ordenarPrecioDesc(aDispositivos);
                        break;
                    case 4:
                        cambiarPrecio(aDispositivos, sc);
                        break;
                    case 5:
                        eliminarDispositivo(aDispositivos, sc);
                        break;
                    case 6:
                        mostrarDispositivos(aDispositivos);
                        break;
                    case 7:
                        salir();
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, introduce un número del 1 al 7.");
                        break;
                }
            } else {
                System.out.println("Por favor, introduce un número entero válido.");
                sc.next();
                sc.nextLine();
            }

        } while (opcion != 7);

        sc.close();
    }
}