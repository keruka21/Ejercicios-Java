package ud03;

/*PDF (Arrays y Métodos estáticos) - Ejercicio 3:
Crear dos arrays, arrMeses y arrLitros. En el primero guarda los meses desde
enero a mayo, y en el segundo 123, 333, 180, 211, 90.
Por ejemplo:
arrMeses[0] - enero
arrLitros[0] - 123

Mostrar en cada mes cuántos litros han llovido.
Mostrar en pantalla el mes y los litros del mes más lluvioso.
*/

public class LluviaMeses {


    public static void mostrarLxM(String [] aMeses, int [] aLitros) {
        System.out.println("======= Litros de lluvia por mes =======L");
        for (int i = 0; i < aMeses.length; i++) {
            System.out.println("En " + aMeses[i] + " han llovido " + aLitros[i] + " litros.");
        }
    }

    
    public static void masLluvioso(String [] aMeses, int [] aLitros) {
        int maxLitros = aLitros[0];
        int posMax = 0; //posición del mes más lluvioso

        for (int i = 0; i < aLitros.length; i++) {
            if (aLitros[i] > maxLitros) {
                maxLitros = aLitros[i];
                posMax = i;
            }
        }
        System.out.println("El mes más lluvioso fue " + aMeses[posMax] + " con " + maxLitros + " L/m^2");
    }

    public static void main(String[] args) {
        
        String [] aMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo"};
        int [] aLitros = {123, 333, 180, 211, 90};
        
        mostrarLxM(aMeses, aLitros);
        masLluvioso(aMeses, aLitros);
    }
}