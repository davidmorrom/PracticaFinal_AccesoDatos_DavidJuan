package Apartado_2;
import java.io.Serializable;

public class Pais implements Serializable {

	private String nombre;
	private String presidente;
	private int pib;
	private double gini;

	public Pais() {
	}

	public Pais(String nombre, String presidente, int pib, double gini) {
		this.nombre = nombre;
		this.presidente = presidente;
		this.pib = pib;
		this.gini = gini;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPresidente() {
		return presidente;
	}

	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public double getGini() {
		return gini;
	}

	public void setGini(double gini) {
		this.gini = gini;
	}
	
	@Override
	public String toString() {
	    return "Pais{" +
	        "nombre='" + nombre + '\'' +
	        ", presidente='" + presidente + '\'' +
	        ", pib=" + pib +
	        ", gini=" + gini +
	        '}';
	}

}