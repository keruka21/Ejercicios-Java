package examenes;

/*Crea una clase llamada Dispositivo con los siguientes atributos privados: 
	String nombre (Nombre del dispositivo)
	String tipo (Puede ser “móvil”, “tablet” o “portátil”)
	double precio (Precio en euros consumo)
	int consumo (Consumo energético en vatios (W))
	double peso (Peso en kilogramos)
Crea dos constructores uno sin parámetros y otro con todos los parámetros.
Implementa los métodos get, set y toString().
Añade los siguientes métodos especiales: 
	esEficiente(): devuelve true si el consumo es menor a 100 W.
	indicePortabilidad(): devuelve un valor calculado como: 
	indice = (consumo / 10) + (peso * 2)
Cuanto menor sea el valor, más portátil es el dispositivo.
*/

public class Dispositivo {
    private String nombre;
    private String tipo;
    private double precio;
    private int consumo;
    private double peso;

    // Constructor sin parámetros
    public Dispositivo() {
        this.nombre = "";
        this.tipo = "";
        this.precio = 0.0;
        this.consumo = 0;
        this.peso = 0.0;
    }

    // Constructor con todos los parámetros
    public Dispositivo(String nombre, String tipo, double precio, int consumo, double peso) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.consumo = consumo;
        this.peso = peso;
    }

    // Métodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Métodos especiales
    public boolean esEficiente() {
        if(this.consumo<100) {
            return true;
        }else {
            return false;
        }
    }
    
    /*public boolean esEficiente() {
        return this.consumo < 100;
    }*/
    
    public double indicePortabilidad() {
        double indice = 0;
        indice = (this.consumo / 10.0) + (this.peso * 2.0);
        return indice;
    }
    
   /* public double indicePortabilidad() {
        return (this.consumo / 10.0) + (this.peso * 2.0);
    }*/

    // Método toString
    @Override
    public String toString() {
        return "Dispositivo{nombre='" + nombre + "', tipo='" + tipo + "', precio=" + precio + 
               ", consumo=" + consumo + ", peso=" + peso + ", eficiente=" + esEficiente() + 
               ", indicePortabilidad=" + indicePortabilidad() + "}";
    }
}