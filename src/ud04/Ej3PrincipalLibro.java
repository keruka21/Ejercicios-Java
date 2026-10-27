package ud04;
/*Documento Word - Ejercicio 3

Crea una clase llamada "Libro" que tendrá los siguientes atributos: titulo, autor y numeroPaginas.
El título y el autor serán obligatorios, mientras que el número de páginas será opcional.

    Crea dos constructores que cumplan lo anterior.
    Crea sus métodos get, set y toString.

Tendrá dos métodos especiales:

    esLargo(): devuelve un valor lógico indicando si el libro tiene más de 300 páginas.
    mostrarInformacion(): muestra por pantalla toda la información del libro.

*/

public class Ej3PrincipalLibro {

	public static void main(String[] args) {
		
		Ej3Libro l1=new Ej3Libro("Caperucita Roja", "Anónimo");
		l1.mostrarInformacion();
		
		System.out.println("----------------------------");
		
		Ej3Libro l2=new Ej3Libro("El Quijote", "Miguel de Cervantes", 500);
		l2.mostrarInformacion();
		
		
		if(l2.esLargo()) {
			System.out.println("El libro es largo.");
		}else {
			System.out.println("El libro es corto.");
		}
	}
}
