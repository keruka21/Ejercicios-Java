package examenes;

/*EJERCICIO 1
Crea una clase llamada Tren que tendrá los siguientes atributos:
	tipo (Cercanías, Ave o Mercancías)
	referencia
	asientos ocupados
	km recorridos
	duración del viaje (en minutos)
Crea dos constructores distintos que cumplan con las siguientes condiciones:
	que el atributo tipo del tren sea obligatorio y que, si no se corresponde con uno de los tres valores posibles, se le asigne el valor “Indefinido”. 
Crear sus respectivos métodos get y set correspondientes para cada atributo. 
Crear el método que muestre todos los datos del tren 
Tendrá dos métodos especiales
	trenLLeno(): este método devuelve un valor booleano que nos indica si el tren está o no lleno. La capacidad máxima
	de un tren es de 400 viajeros (este valor lo guardaremos en una constante para su tratamiento).
	obtenerVelocidadTotal(): este método nos devuelve la velocidad en Km/h del tren. Teniendo en cuenta que la
	duración del viaje viene expresada en minutos, la velocidad se obtiene de dividir los kilómetros recorridos entre la
	duración del viaje expresado en horas.
*/

public class Tren {
	/*ATRIBUTOS*/
	private String tipo;
	private String referencia;
	private int asientosOcupados;
	private double kmRecorridos;
	private double minDuracion;
	
	/*CONSTRUCTORES*/
	
	/*con todos los atributos*/
	public Tren(String t, String r, int a, double km, double m) {
        this.tipo = t;
        this.referencia = r;
        this.asientosOcupados = a;
        this.kmRecorridos = km;
        this.minDuracion = m;
    }
	
	/*atributo tipo obligatorio, si no se corresponde con uno de los tres valores posibles, se le asigne el valor “Indefinido”*/
	private String validarTipo(String tipo) {
        if ("Cercanías".equals(tipo) || "Ave".equals(tipo) || "Mercancías".equals(tipo)) {
            return tipo;
        }
        return "Indefinido";
    }
	
	public Tren(String t) {
        this.tipo = validarTipo(t);
        this.referencia = "";
        this.asientosOcupados = 0;
        this.kmRecorridos = 0;
        this.minDuracion = 0;
    }
	
	/*GET&SET*/
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getAsientosOcupados() {
		return asientosOcupados;
	}

	public void setAsientosOcupados(int asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}

	public double getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public double getMinDuracion() {
		return minDuracion;
	}

	public void setMinDuracion(double minDuracion) {
		this.minDuracion = minDuracion;
	}

	/*TO STRING*/
	@Override
	public String toString() {
		return "Tren [tipo=" + tipo + ", referencia=" + referencia + ", asientosOcupados=" + asientosOcupados
				+ ", kmRecorridos=" + kmRecorridos + ", minDuracion=" + minDuracion + "]";
	}
	
	
	/*MÉTODOS*/
	/*trenLLeno(): este método devuelve un valor booleano que nos indica si el tren está o no lleno. La capacidad máxima
	de un tren es de 400 viajeros (este valor lo guardaremos en una constante para su tratamiento).*/
	
	public boolean trenLleno() {
		int maxPasajeros = 400;
		if(this.asientosOcupados>=maxPasajeros) {
			return true;
		}else {
			return false;
		}
	}
	
	/*obtenerVelocidadTotal(): este método nos devuelve la velocidad en Km/h del tren. Teniendo en cuenta que la
	duración del viaje viene expresada en minutos, la velocidad se obtiene de dividir los kilómetros recorridos entre la
	duración del viaje expresado en horas.*/

	public double obtenerVelocidadTotal() { 
		double velocidad =  (this.kmRecorridos/60)/this.minDuracion;
		return velocidad;
		
	}
}
