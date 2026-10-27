package ud04;

public class Perro {
	//ATRIBUTOS
	private String raza;
	private String color;
	private boolean ppp;
	private int numDientes;
	
	//CONSTRUCTOS
	
	//por defecto
	public Perro() {
		this.raza="";
		this.color="";
		this.ppp=false;
		this.numDientes=0;
	}
	//con todos
	public Perro(String raza, String color, boolean ppp, int numDientes) {
		this.raza=raza;
		this.color=color;
		this.ppp=ppp;
		this.numDientes=numDientes;
	}
	//raza
	public Perro(String raza) {
		this.raza=raza;
		this.color="";
		this.ppp=false;
		this.numDientes=0;
	}
	
	
	//getters y setters
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isPpp() {
		return ppp;
	}
	public void setPpp(boolean ppp) {
		this.ppp = ppp;
	}
	public int getNumDientes() {
		return numDientes;
	}
	public void setNumDientes(int numDientes) {
		this.numDientes = numDientes;
	}
	
	//to string - pestaña Source, opcion generar toString
	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", color=" + color + ", ppp=" + ppp + ", numDientes=" + numDientes + "]";
	}
	
	//MÉTODOS
	public boolean esPpp() {
		if(this.numDientes>20) {
			return true;
		}else {
			return false;
		}
	}
}
