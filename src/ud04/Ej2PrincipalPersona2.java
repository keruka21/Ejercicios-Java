package ud04;
/*Documento Word - Ejercicio 2

Vamos a crear una clase llamada “Persona”. Sus atributos son: nombre, edad y DNI.
Construye los siguientes métodos para la clase:

    Un constructor, donde los datos pueden estar vacíos.
    Los setters y getters para cada uno de los atributos.
    mostrar(): Muestra los datos de la persona.
    esMayorDeEdad(): Devuelve un valor lógico indicando si es mayor de edad.
*/
public class Ej2PrincipalPersona2 {

	public static void main(String[] args) {
		
		Ej2Persona2 p1= new Ej2Persona2();
		p1.setNombre("Kelea");
		p1.setEdad(33);
		p1.setDni("00000000K");
		
		p1.mostrar();
		
		if(p1.esMayorDeEdad()) {
			System.out.println("Eres mayor de edad.");
		}else {
			System.out.println("Eres menor de edad.");
		}
	}
}
