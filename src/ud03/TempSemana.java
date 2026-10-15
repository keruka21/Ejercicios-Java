package ud03;
/*PDF (Arrays y Métodos estáticos) - Ejercicio 5: La temperatura de los días de la semana.
La temperatura de los días de la semana, leerla en ºC.
Habrá que calcular y mostrar lo siguiente:

La media de la semana en ºF.
El día más caluroso y más frio
Los días por encima de la media.
Los días por debajo de la media.
*/
public class TempSemana {

    //mostrar temperaturas
    public static void mostrar(double [] aTemp, String [] aDias) {
        System.out.println("Temperaturas de la semana");
        for (int i = 0; i < aDias.length; i++) {
            System.out.println(aDias[i] + ": " + aTemp[i] + " ºC");
        }
        System.out.println("--------------------");
    }

    //la media en ºF
    public static void mediaFahrenheit(double [] aTemp) {
        double suma = 0;
        double media = 0;
        double mediaF = 0;
        
        for (int i = 0; i < aTemp.length; i++) {
            suma += aTemp[i];
        }
        //double redondeado = Math.round(numero100.0) / 100.0
        media = Math.round((suma / aTemp.length) * 100.0) / 100.0;
        mediaF = Math.round(((media * 9 / 5) + 32) * 100.0) / 100.0;
        
        System.out.println("Temperatura Media");
        System.out.println("La media de la semana es: " + mediaF + " ºF (equivale a " + media + " ºC)");
        System.out.println("--------------------");
    }

    //mostrar el día más caluroso y el más frío
    public static void tempMinMax(double [] aTemp, String [] aDias) {
        double maxTemp = aTemp[0];
        double minTemp = aTemp[0];
        int posMax = 0;
        int posMin = 0;

        for (int i = 0; i < aTemp.length; i++) {
            if (aTemp[i] > maxTemp) {
                maxTemp = aTemp[i];
                posMax = i;
            }
            if (aTemp[i] < minTemp) {
                minTemp = aTemp[i];
                posMin = i;
            }
        }
        System.out.println("Día más caluroso: " + aDias[posMax] + " con " + maxTemp + " ºC.");
        System.out.println("Día más frío: " + aDias[posMin] + " con " + minTemp + " ºC.");
        System.out.println("--------------------");
    }

    //mostrar días por encima y debajo de la media
    public static void compMedia(double [] aTemp, String [] aDias) {
        double suma = 0;
        for (int i = 0; i < aTemp.length; i++) {
            suma += aTemp[i];
        }
        double media = suma / aTemp.length;

        System.out.println("Días por encima de la media:");
        for (int i = 0; i < aTemp.length; i++) {
            if (aTemp[i] > media) {
                System.out.println("  > " + aDias[i] + " (" + aTemp[i] + " ºC)");
            }
        }

        System.out.println("Días por debajo de la media:");
        for (int i = 0; i < aTemp.length; i++) {
            if (aTemp[i] < media) {
                System.out.println("  > " + aDias[i] + " (" + aTemp[i] + " ºC)");
            }
        }
    }

    public static void main(String[] args) {
        
        String [] aDias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        double [] aTemp = {26.5, 24.1, 20.4, 19.9, 23.0, 25.3, 28.1};
        
        mostrar(aTemp, aDias);
        mediaFahrenheit(aTemp);
        tempMinMax(aTemp, aDias);
        compMedia(aTemp, aDias);
    }
}