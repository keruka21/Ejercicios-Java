package ud04;
/*Documento Word - Ejercicio 1

Crea una clase llamada “Cuenta” que tendrá los siguientes atributos: titular y cantidad (puede tener decimales).

El titular será obligatorio y la cantidad es opcional.

    Crea dos constructores que cumplan lo anterior.
    Crea sus métodos get, set y toString.

Tendrá dos métodos especiales:

    ingresar (double cantidad): se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
    retirar (double cantidad): se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa,
    la cantidad de la cuenta pasa a ser 0.
*/

public class Ej1PrincipalCuenta {

	public static void main(String[] args) {
		Ej1Cuenta c1=new Ej1Cuenta();
		Ej1Cuenta c2=new Ej1Cuenta("Kelea");
		
		System.out.println(c2);
		c1.ingresarCant(1000);
		c1.setTitular("June");
		System.out.println(c1);
	}
}