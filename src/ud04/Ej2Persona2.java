package ud04;

/*Documento Word - Ejercicio 2

Vamos a crear una clase llamada “Persona”. Sus atributos son: nombre, edad y DNI.
Construye los siguientes métodos para la clase:

    Un constructor, donde los datos pueden estar vacíos.
    Los setters y getters para cada uno de los atributos.
    mostrar(): Muestra los datos de la persona.
    esMayorDeEdad(): Devuelve un valor lógico indicando si es mayor de edad.
*/
public class Ej2Persona2 {
	
	//ATRIBUTOS
	
	private String nombre;
	private int edad;
	private String dni;
	
	//CONSTRUCTOS
	
	//vacio
	
	public Ej2Persona2() {
		this.nombre="";
		this.edad=0;
		this.dni="";
	}

	//parametros
	public Ej2Persona2(String nombre, int edad, String dni) {
	    this.nombre = nombre;
	    this.edad = edad;
	    this.dni = dni;
	}

	//GET Y SET
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
		
	}
	
	@Override
	public String toString() {
		return "Ej2Persona2 [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + "]";
	}
	
	//METODOS
	
	public void mostrar() {
		System.out.println("Nombre: " + this.nombre);
	    System.out.println("Edad: " + this.edad);
	    System.out.println("DNI: " + this.dni);
	}

	public boolean esMayorDeEdad () {
		if(this.edad<18) {
			return false;
		}else {
			return true;
		}
	}
	
}
