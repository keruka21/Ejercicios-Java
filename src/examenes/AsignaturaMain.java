package examenes;

/*Una vez creada la clase anterior, vamos a diseñar un programa que me gestione todas las asignaturas de nuestro instituto (máximo 100 asignaturas).
El programa tendrá un menú repetitivo como se especifica a continuación:
1.Introducir las asignaturas: Podemos introducir hasta 100 asignaturas distintas, pero no tenemos que introducirlas todas a la vez. Controlar que no se metan más de 100. Además, al introducir una nueva asignatura, se debe controlar que el nombre de la asignatura sea único y que el número de suspensos no sea superior al número de matriculados.  
	¿Qué quieres hacer?
	1
	Introduce el nombre de la asignatura: PGR
	Introduce el curso de la asignatura: 1DAM
	Introduce el número de matriculados de la asignatura: 20
	Introduce el número de suspensos de la asignatura: 10
	La asignatura ha sido introducida
	¿Quieres introducir otra asignatura?
	SI
	Introduce el nombre de la asignatura: BD
	Introduce el curso de la asignatura: 1DAM
	Introduce el número de matriculados de la asignatura:20
	Introduce el número de suspensos de la asignatura: 5
	La asignatura ha sido introducida
	¿Quieres introducir otra asignatura?
	SI
	Introduce el nombre de la asignatura: SISTEMAS
	Introduce el curso de la asignatura: 1DAM
	Introduce el número de matriculados de la asignatura: 20
	Introduce el número de suspensos de la asignatura: 25
	Introduce el número de suspensos de la asignatura:5
	La asignatura ha sido introducida
	¿Quieres introducir otra asignatura?
	SI
	Introduce el nombre de la asignatura: SISTEMAS
	Esa asignatura ya existe
	¿Quieres introducir otra asignatura?
	NO

2.Mostrar el porcentaje de aprobados de las asignaturas de un curso. Pediremos por pantalla el nombre del curso. Por cada curso vamos a mostrar las asignaturas de dicho curso y el porcentaje de aprobados de cada una. Si para un curso determinado no se han introducido asignaturas, mostraremos un mensaje de error.
	¿Qué quieres hacer?
	2
	Introduce el curso de la asignatura: 1DAM
	En la asignatura PGR el porcentaje de aprobados es 50.0%
	En la asignatura BD el porcentaje de aprobados es 75.0%
	En la asignatura SISTEMAS el porcentaje de aprobados es 75.0%
	1.- Introducir asignaturas
	2. Mostrar el porcentaje de aprobados de las asignaturas de un curso
	3. Ordenar las asignaturas por número de aprobados
	4. Modificar datos de una asignatura concreta
	5.- Mostrar
	6.- Salir
	¿Qué quieres hacer?
	2
	Introduce el curso de la asignatura: 2DAM
	No hay asignaturas para ese curso

3.Ordenar las asignaturas por número de aprobados. Ordenamos las asignaturas por número de aprobados de mayor a menor, y las mostramos.
	¿Qué quieres hacer?
	3
	Asignatura [nombre=BD, curso=1DAM, numMatriculados=20, numSuspensos=5]
	Asignatura [nombre=SISTEMAS, curso=1DAM, numMatriculados=20, numSuspensos=5]
	Asignatura [nombre=PGR, curso=1DAM, numMatriculados=20, numSuspensos=10]
4.Modificar datos de una asignatura concreta. Pediremos por pantalla el nombre de la asignatura que queremos modificar y le daremos la opción de modificar el número de alumn@s matriculados y/o el de suspensos. 
	¿Qué quieres hacer?
	4
	Introduce el nombre de la asignatura: PGR
	¿Quieres cambiar el número de alumnos matriculados? (SI/NO) SI
	Introduce el número de alumnos matriculados: 30
	¿Quieres cambiar el número de suspensos? (SI/NO) SI
	Introduce el número de suspensos: 5
5.Mostrar todas las asignaturas que se han introducido.
6.Salir
Nota: En todas las opciones a partir de la 1, controlar previamente si hay o no asignaturas introducidas.  
*/

import java.util.Scanner;

public class AsignaturaMain {

// MÉTODOS AUXILIARES

    // Busca una asignatura por su nombre y devuelve su índice o -1 si no existe
    public static int buscarAsignatura(Asignatura[] aAsignaturas, int totalAsignaturas, String nombreBuscado) {
        int i;
        int encontrado;

        encontrado = -1;
        for (i = 0; i < totalAsignaturas; i++) {
            if (aAsignaturas[i].getNombre().equalsIgnoreCase(nombreBuscado)) {
                encontrado = i;
            }
        }
        return encontrado;
    }

    // Cuenta cuántas asignaturas hay introducidas realmente en el array (posiciones que no son null)
    public static int contarAsignaturas(Asignatura[] aAsignaturas) {
        int i;
        int contador;

        contador = 0;
        for (i = 0; i < aAsignaturas.length; i++) {
            if (aAsignaturas[i] != null) {
                contador++;
            }
        }
        return contador;
    }

// MÉTODOS DE LAS OPCIONES DEL MENÚ

    // 1. Introducir las asignaturas (controlado mediante variable booleana, sin usar break)
    public static void introducirAsignaturas(Asignatura[] aAsignaturas, Scanner sc) {
        String respuesta;
        String nombre;
        int indiceExistente;
        String curso;
        int matriculados;
        int suspensos;
        int totalAsignaturas;
        boolean continuar;

        respuesta = "SI";
        continuar = true;

        while (respuesta.equalsIgnoreCase("SI") && continuar) {
            totalAsignaturas = contarAsignaturas(aAsignaturas);

            if (totalAsignaturas >= 100) {
                System.out.println("Se ha alcanzado el límite máximo de 100 asignaturas.");
                continuar = false; // Variable centinela para salir del bucle ordenadamente sin break
            } else {
                System.out.print("Introduce el nombre de la asignatura: ");
                nombre = sc.nextLine().trim();

                indiceExistente = buscarAsignatura(aAsignaturas, totalAsignaturas, nombre);
                if (indiceExistente != -1) {
                    System.out.println("Esa asignatura ya existe");
                } else {
                    System.out.print("Introduce el curso de la asignatura: ");
                    curso = sc.nextLine().trim();

                    System.out.print("Introduce el número de matriculados de la asignatura: ");
                    matriculados = sc.nextInt();

                    System.out.print("Introduce el número de suspensos de la asignatura: ");
                    suspensos = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer

                    while (suspensos > matriculados || suspensos < 0 || matriculados < 0) {
                        System.out.println("Error: El número de suspensos no puede ser superior al de matriculados ni negativo.");
                        System.out.print("Introduce el número de suspensos de la asignatura: ");
                        suspensos = sc.nextInt();
                        sc.nextLine();
                    }

                    aAsignaturas[totalAsignaturas] = new Asignatura(nombre, curso, matriculados, suspensos);
                    System.out.println("La asignatura ha sido introducida");
                }

                totalAsignaturas = contarAsignaturas(aAsignaturas);
                if (totalAsignaturas < 100) {
                    System.out.print("¿Quieres introducir otra asignatura? ");
                    respuesta = sc.nextLine().trim();
                } else {
                    System.out.println("Se ha alcanzado el límite máximo de 100 asignaturas.");
                    respuesta = "NO";
                }
            }
        }
    }

    // 2. Mostrar el porcentaje de aprobados de las asignaturas de un curso
    public static void mostrarPorcentajeCurso(Asignatura[] aAsignaturas, Scanner sc) {
        int totalAsignaturas;
        String cursoBuscado;
        int contadorCurso;
        int i;
        double porcentaje;

        totalAsignaturas = contarAsignaturas(aAsignaturas);
        if (totalAsignaturas == 0) {
            System.out.println("Error: No hay asignaturas introducidas todavía.");
        } else {
            System.out.print("Introduce el curso de la asignatura: ");
            cursoBuscado = sc.nextLine().trim();
            contadorCurso = 0;

            for (i = 0; i < totalAsignaturas; i++) {
                if (aAsignaturas[i].getCurso().equalsIgnoreCase(cursoBuscado)) {
                    porcentaje = aAsignaturas[i].porcentajeAprobados();
                    System.out.println("En la asignatura " + aAsignaturas[i].getNombre() + " el porcentaje de aprobados es " + porcentaje + "%");
                    contadorCurso++;
                }
            }

            if (contadorCurso == 0) {
                System.out.println("No hay asignaturas para ese curso");
            }
        }
    }

    // 3. Ordenar las asignaturas por número de aprobados
    public static void ordenarAsignaturas(Asignatura[] aAsignaturas) {
        int totalAsignaturas;
        int i;
        int j;
        Asignatura[] aOrdenadas;
        Asignatura aux;

        totalAsignaturas = contarAsignaturas(aAsignaturas);
        if (totalAsignaturas == 0) {
            System.out.println("Error: No hay asignaturas introducidas todavía.");
        } else {
            aOrdenadas = new Asignatura[totalAsignaturas];
            for (i = 0; i < totalAsignaturas; i++) {
                aOrdenadas[i] = aAsignaturas[i];
            }

            for (i = 0; i < totalAsignaturas - 1; i++) {
                for (j = 0; j < totalAsignaturas - 1 - i; j++) {
                    if (aOrdenadas[j].obtenerNumeroAprobados() < aOrdenadas[j + 1].obtenerNumeroAprobados()) {
                        aux = aOrdenadas[j];
                        aOrdenadas[j] = aOrdenadas[j + 1];
                        aOrdenadas[j + 1] = aux;
                    }
                }
            }

            for (i = 0; i < totalAsignaturas; i++) {
                System.out.println(aOrdenadas[i]);
            }
        }
    }

    // 4. Modificar datos de una asignatura concreta
    public static void modificarAsignatura(Asignatura[] aAsignaturas, Scanner sc) {
        int totalAsignaturas;
        String nombreModificar;
        int indiceModificar;
        String respMod;
        int matriculados;
        int suspensos;

        totalAsignaturas = contarAsignaturas(aAsignaturas);
        if (totalAsignaturas == 0) {
            System.out.println("Error: No hay asignaturas introducidas todavía.");
        } else {
            System.out.print("Introduce el nombre de la asignatura: ");
            nombreModificar = sc.nextLine().trim();
            indiceModificar = buscarAsignatura(aAsignaturas, totalAsignaturas, nombreModificar);

            if (indiceModificar == -1) {
                System.out.println("No existe ninguna asignatura con ese nombre.");
            } else {
                System.out.print("¿Quieres cambiar el número de alumnos matriculados? (SI/NO) ");
                respMod = sc.nextLine().trim();
                if (respMod.equalsIgnoreCase("SI")) {
                    System.out.print("Introduce el número de alumnos matriculados: ");
                    matriculados = sc.nextInt();
                    sc.nextLine();
                    aAsignaturas[indiceModificar].setNumeroAlumnos(matriculados);
                }

                System.out.print("¿Quieres cambiar el número de suspensos? (SI/NO) ");
                respMod = sc.nextLine().trim();
                if (respMod.equalsIgnoreCase("SI")) {
                    System.out.print("Introduce el número de suspensos: ");
                    suspensos = sc.nextInt();
                    sc.nextLine();
                    aAsignaturas[indiceModificar].setNumeroSuspensos(suspensos);
                }

                if (aAsignaturas[indiceModificar].getNumeroSuspensos() > aAsignaturas[indiceModificar].getNumeroAlumnos()) {
                    System.out.println("Aviso: Los suspensos superaban a los matriculados. Se han ajustado los suspensos al total de matriculados.");
                    aAsignaturas[indiceModificar].setNumeroSuspensos(aAsignaturas[indiceModificar].getNumeroAlumnos());
                }

                System.out.println("Asignatura modificada correctamente.");
            }
        }
    }

    // 5. Mostrar todas las asignaturas
    public static void mostrarTodas(Asignatura[] aAsignaturas) {
        int totalAsignaturas;
        int i;

        totalAsignaturas = contarAsignaturas(aAsignaturas);
        if (totalAsignaturas == 0) {
            System.out.println("Error: No hay asignaturas introducidas todavía.");
        } else {
            for (i = 0; i < totalAsignaturas; i++) {
                System.out.println(aAsignaturas[i]);
            }
        }
    }

// MAIN ------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner sc;
        Asignatura[] aAsignaturas;
        int opcion;

        sc = new Scanner(System.in);
        aAsignaturas = new Asignatura[100];
        opcion = 0;

        do {
            System.out.println("\n================ GESTIÓN DE ASIGNATURAS ================");
            System.out.println("1. Introducir las asignaturas");
            System.out.println("2. Mostrar el porcentaje de aprobados de las asignaturas de un curso");
            System.out.println("3. Ordenar las asignaturas por número de aprobados");
            System.out.println("4. Modificar datos de una asignatura concreta");
            System.out.println("5. Mostrar todas las asignaturas");
            System.out.println("6. Salir");
            System.out.print("¿Qué quieres hacer? ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
            } else {
                System.out.println("Error: Introduce un número de opción válido.");
                sc.nextLine();
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    introducirAsignaturas(aAsignaturas, sc);
                    break;
                case 2:
                    mostrarPorcentajeCurso(aAsignaturas, sc);
                    break;
                case 3:
                    ordenarAsignaturas(aAsignaturas);
                    break;
                case 4:
                    modificarAsignatura(aAsignaturas, sc);
                    break;
                case 5:
                    mostrarTodas(aAsignaturas);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Introduce un número del 1 al 6.");
                    break;
            }

        } while (opcion != 6);

        sc.close();
    }
}