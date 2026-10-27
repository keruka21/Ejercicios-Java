package ud04;

import java.util.Scanner;

public class PrincipalPersona {

	public static void main(String[] args) {
		//persona 1
		Persona p1=new Persona();
		
		System.out.println("Nombre " +p1.getNombre());
		System.out.println("Edad " +p1.getEdad());
		System.out.println("-------------------------------");
		
		//persona 3
		Persona p3=new Persona("Kelea");
		
		System.out.println("Nombre " +p3.getNombre());
		System.out.println("Edad " +p3.getEdad());
		System.out.println(p3); //nos saca la dirección de memoria
		System.out.println(p3.getNombre() + " " + p3.getEdad());
		System.out.println("-------------------------------");
		
		//persona 4
		Scanner sc = new Scanner(System.in);
		String nombre;
		int edad;
		
		System.out.println("¿Cómo te llamas?");
		nombre=sc.next();
		System.out.println("¿Qué edad tienes?");
		edad=sc.nextInt();
		Persona p4=new Persona(nombre, edad);
		System.out.println("Nombre " +p4.getNombre());
		System.out.println("Edad " +p4.getEdad());
		p4.setEdad(21); //cambiamos la edad a 21
		System.out.println("Edad " +p4.getEdad());
		sc.close();
		System.out.println("-------------------------------");
	}
}
