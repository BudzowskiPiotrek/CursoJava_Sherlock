package examenTrimestral;

public class Sospechoso {
	private int id;
	private String nombre;
	private int peligrosidad;
	private String arma;

	public Sospechoso(int id, String nombre, int peligrosidad, String arma) {
		this.id = id;
		this.nombre = nombre;
		setPeligrosidad(peligrosidad);
		this.arma = arma;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeligrosidad() {
		return peligrosidad;
	}

	public void setPeligrosidad(int peligrosidad) {
		if (peligrosidad < 0) {
			this.peligrosidad = 0;
		} else if (peligrosidad > 10) {
			this.peligrosidad = 10;
		} else
			this.peligrosidad = peligrosidad;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	@Override
	public String toString() {
		return "Sospechoso{id='" + id + "', nombre='" + nombre + "', peligrosidad='" + peligrosidad + "', arma='" + arma
				+ "'}";
	}

}
