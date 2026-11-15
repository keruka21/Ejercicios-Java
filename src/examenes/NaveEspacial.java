package examenes;

/* ========================================================================================
 * ENUNCIADO DEL EXAMEN: GESTIÓN DE NAVES ESPACIALES
 * ========================================================================================
 * Crea una clase llamada NaveEspacial que tenga los siguientes atributos privados:
 *   - Nombre (String)
 *   - Año de creación (int)
 *   - Año de lanzamiento (int)
 *   - Capacidad Total de Personas que entran en la nave (int)
 *   - Número de Tripulantes necesario (int)
 * 
 * Requisitos de la clase NaveEspacial:
 *   - Crea dos constructores distintos.
 *   - Implementa los métodos get, set y toString().
 *   - Incluye dos métodos especiales:
 *       1. calcularAntiguedad(int anioActual): Devuelve la antigüedad de la nave 
 *          con respecto al año actual proporcionado como parámetro.
 *       2. admitePasajeros(): Verifica si la nave tiene espacio para pasajeros y 
 *          devuelve un valor booleano (true si puede soportarlos, false en caso contrario).*/

public class NaveEspacial {
	/*ATRIBUTOS*/
    private String nombre;
    private int anioCreacion;
    private int anioLanzamiento;
    private int capacidadTotal;
    private int tripulantesNecesarios;
    
    /*CONSTRUCTORES*/

    public NaveEspacial() {
        this.nombre = "";
        this.anioCreacion = 0;
        this.anioLanzamiento = 0;
        this.capacidadTotal = 0;
        this.tripulantesNecesarios = 0;
    }

    public NaveEspacial(String nombre, int anioCreacion, int anioLanzamiento, int capacidadTotal, int tripulantesNecesarios) {
        this.nombre = nombre;
        this.anioCreacion = anioCreacion;
        this.anioLanzamiento = anioLanzamiento;
        this.capacidadTotal = capacidadTotal;
        this.tripulantesNecesarios = tripulantesNecesarios;
    }
    
    /*GET/SET*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getTripulantesNecesarios() {
        return tripulantesNecesarios;
    }

    public void setTripulantesNecesarios(int tripulantesNecesarios) {
        this.tripulantesNecesarios = tripulantesNecesarios;
    }
    
    /*TO STRING*/
    @Override
    public String toString() {
        return "Nave Espacial: " + nombre + 
               ", Año de Creación: " + anioCreacion + 
               ", Año de Lanzamiento: " + anioLanzamiento + 
               ", Capacidad Total: " + capacidadTotal + 
               ", Tripulantes Necesarios: " + tripulantesNecesarios;
    }
    
  //Calcular la antigüedad de la nave respecto al año actual proporcionado
    public int calcularAntiguedad(int anioActual) {
        return anioActual - this.anioLanzamiento;
    }

  //Verifica si la nave tiene espacio para pasajeros (true si capacidad > tripulantes)
    //corto
    /*public boolean admitePasajeros() {
        return this.capacidadTotal > this.tripulantesNecesarios;
    }*/
    public boolean admitePasajeros() {
        if (this.capacidadTotal > this.tripulantesNecesarios) {
            return true;
        } else {
            return false;
        }
    }
    
}