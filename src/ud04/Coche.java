package ud04;

public class Coche {
	//atributos
	public String material;
	public String color;
	public String direccion;
	public int ruedas;
	public int volante;
	public int pasajeros;
	
	//métodos
	public void moverHaciaDelante() {
		this.direccion="HaciaDelante";
	}
	public void moverHaciaAtras() {
		this.direccion="HaciaAtras";
	}
	public void cambiarColor(String c) {
		this.color=c;
	}
	public void quitarRueda() {
		this.ruedas--;
	}
	public boolean estaLleno() {
		if (this.pasajeros>=5) {
			return true;
		}else{
			return false;
		}
	}
}
