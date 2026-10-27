package ud04;

public class Persona {
	//ATRIBUTOS
	private String nombre;
	private int edad;
	
	//CONSTRUCTORES
	//Constructor por defecto
	public Persona() {
		this.nombre="";
		this.edad=0;
	}
	
	//Constructores con parámetros
	public Persona(String n, int e) {
		this.nombre=n;
		this.edad=e;
	}
	public Persona(int e) {
		this.nombre="";
		this.edad=e;
	}
	public Persona(String n) {
		this.nombre=n;
		this.edad=0;
	}
	//no puedo tener más constructores con parametros porque no tengo más atributos
	
	//GET & SET porque los atributos son privados
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
}
