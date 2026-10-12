package ud01;

/*Parte 1
 * Realiza una multiplicación de dos números enteros,
 * después haz el modulo del resultado de la multiplicación con el segundo operando.
 * Guarda el resultado en la variable del primer operando de la primera operación.
 * Parte 2
 * Un artículo con un descuento del 20%, otro con descuento del 50%,
 * sumar el precio de los artículos después del descuento.
*/

public class Companero {

public static void main(String[] args) {
		
		//Parte 1
		int operando1=10;
		int operando2=5;
		int resultadomulti = operando1*operando2;
		int resultadomod = (operando1*operando2) % operando2;
		
		System.out.println("PARTE 1");
		System.out.println("El operando1 tiene un valor de:  " +operando1);
		System.out.println("El operando2 tiene un valor de:  " +operando2);
		System.out.println("El producto de " +operando1+ " * " +operando2+ " es: " +resultadomulti);
		System.out.println("El módulo de " +(resultadomulti)+ " % " +operando2+ " es: " +resultadomod);
		operando1 = resultadomod;
		System.out.println("El operando1 ahora tiene un valor de:  " +resultadomod);
		System.out.println("_______________________________________________________");
	
	
		//Parte 2
		
		double operando3=16;
		double operando4=29;
	
		System.out.println("PARTE 2");
		System.out.println("El precio del primer artículo es:  " +operando3);
		System.out.println("Con el descuento del 20% es:  " +(operando3*0.8));
		System.out.println("El precio del segundo artículo es:  " +operando4);
		System.out.println("Con el descuento del 50% es:  " +(operando4*0.5));
		System.out.println("El importe total de la compra es:  " +((operando4*0.5)+(operando3*0.2)));
		System.out.println("_______________________________________________________");
		
	}
}
