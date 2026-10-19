package ud03;

/*Ejercicios sencillos de Arrays - Ejercicio 1:
Declara un array llamado aNombres de 5 posiciones, inicialízalo con 5 nombres y muéstralos por pantalla.
*/

public class EjSencilloArrays1 {
	public static void main(String[] args) {
        String[] aNombres = {"Romana", "Ethan", "Muhammed", "Eneko", "June"};

        for (int i = 0; i < aNombres.length; i++) { //.lenght nos dice cuanto mide el array
            System.out.println("aNombres[" + i + "] = " + aNombres[i]);
        }
	}
}