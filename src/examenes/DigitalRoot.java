package examenes;
/*Digital Root
Crea un programa en Java que calcule el número raíz (también conocido como digital root) de un número entero positivo.
El número raíz se obtiene sumando los dígitos del número hasta que quede un solo dígito.
Por ejemplo: 
9875 -> 9+8+7+5 = 29 -> 2+9 = 11 -> 1+1 = 2
1234 -> 1+2+3+4 = 10 -> 1+0 = 1
*/

import java.util.Scanner;

public class DigitalRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int aux;
        int sumaDigitos;

        System.out.print("Introduce un número entero positivo: ");
        numero = sc.nextInt();

        //validación para asegurar que el número sea positivo
        while (numero <= 0) {
            System.out.println("Error: El número debe ser un entero positivo.");
            System.out.print("Introduce un número entero positivo: ");
            numero = sc.nextInt();
        }

        aux = numero;

        //bucle principal: se repite mientras el número tenga más de un dígito (>= 10)
        //continúa sumando cifras de manera repetitiva hasta que el número se reduzca a una sola cifra
        while (aux >= 10) {
            sumaDigitos = 0; //
            
            //bucle secundario: suma los dígitos del número actual
            //extrae el último dígito utilizando el operador módulo (% 10)
            //y reduce el número dividiéndolo entre 10 (/ 10) en cada paso, acumulando la suma en sumaDigitos
            while (aux > 0) {
                sumaDigitos += aux % 10; // Extrae el último dígito y lo acumula
                aux /= 10;               // Elimina el último dígito
            }
            
            //el resultado de la suma pasa a ser el número a evaluar en la siguiente vuelta
            aux = sumaDigitos;
        }

        //resultado final
        System.out.println("El número raíz (digital root) de " + numero + " es: " + aux);

        sc.close();
    }
}