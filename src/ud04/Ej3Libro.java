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

public class Ej3Libro {
	
	//ATRIBUTOS
	private String titulo;
	private String autor;
	private int numPag;
	
	//CONSTRUCTOS
	
	//titulo y autor
	public Ej3Libro(String titulo, String autor) {
		this.titulo=titulo;
		this.autor=autor;
		this.numPag=0;
	}
	
	//completo
	public Ej3Libro(String titulo, String autor, int numPag) {
		this.titulo=titulo;
		this.autor=autor;
		if(numPag<0) {
			this.numPag=0;
		}else {
			this.numPag=numPag;
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", numPag=" + numPag + "]";
	}
	
	
	//METODOS
	
	//es largo
	
	public boolean esLargo() {
			
		if(this.numPag>300) {
			return true;
		}else{
			return false;
		}
	}
	
	//mostrar informacion
	
	public void mostrarInformacion() {
		System.out.println("Titulo: " + this.titulo);
	    System.out.println("Autor: " + this.autor);
	    System.out.println("Nº de páginas: " + this.numPag);
	}
}
