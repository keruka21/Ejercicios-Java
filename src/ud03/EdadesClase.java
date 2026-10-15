package ud03;

/*PDF (Arrays y Métodos estáticos) - Ejercicio 4:
Teniendo un array de nombre y otro de edades de una clase. Saca por pantalla los siguientes datos:
Alumnos: Jon, Sara, Ander, Marta, Jone, Mikel
Edad: 18,20,26,21,17,24

El nombre y edad del más joven.
El nombre y edad del mayor
*/

public class EdadesClase {

    //mostrar el alumno más joven y el más viejoven
    public static void mostrarMinMax(String [] aNombres, int [] aEdades) {
        
        int edadMin = aEdades[0];
        int edadMax = aEdades[0];
        int posMin = 0;
        int posMax = 0;

        for (int i = 0; i < aEdades.length; i++) {
            if (aEdades[i] < edadMin) {
                edadMin = aEdades[i];
                posMin = i;
            }
             
            if (aEdades[i] > edadMax) {
                edadMax = aEdades[i];
                posMax = i;
            }
        }
        System.out.println("El/La alumno/a más joven es " + aNombres[posMin] + " con " + edadMin + " años.");
        System.out.println("El/La alumno/a más viejoven es " + aNombres[posMax] + " con " + edadMax + " años.");
    }

    public static void main(String[] args) {
        
        String [] aNombres = {"Jon", "Sara", "Ander", "Marta", "Jone", "Mikel"};
        int [] aEdades = {18, 20, 26, 21, 17, 24};
        
        mostrarMinMax(aNombres, aEdades);
    }
}