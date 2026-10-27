package ud04;

public class PrincipalPerro {

	public static void main(String[] args) {
		
		//perro 1
		Perro perro1=new Perro();
		//podemos sacar por pantalla perro1 directamente porque tenemos toString para la clase Perro
		System.out.println("Perro 1 " +perro1); 
		perro1.setPpp(true);
		perro1.setRaza("Pug");
		perro1.setColor("Crema");
		perro1.setNumDientes(21);
		System.out.println("Es PPP: " +perro1.esPpp());
		System.out.println("Perro 1 " +perro1);
		System.out.println("-------------------------------");
		
		//perro 2
		Perro perro2=new Perro("Labrador Retriever", "Negro", false, 19);
		System.out.println("Perro 2 " +perro2);
		System.out.println("-------------------------------");
		
		//perro 3
		Perro perro3=new Perro("Border Collie");
		System.out.println("Perro 3 " +perro3);
		perro3.setColor("Blanco y Negro");
		System.out.println("Perro 3 " +perro3.getColor());
		System.out.println("-------------------------------");
		
		//perro4
		Perro perro4=new Perro();
		System.out.println("Perro 6 " +perro4);
	}
}
