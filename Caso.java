package examenTrimestral;

import java.time.LocalDate;

public class Caso {
	private int id;
	private String titulo;
	private String descripcion;
	private LocalDate fecha;
	private String sospechoso;
	private String detective;
	private boolean resuelto;

	// CONSTRUCTOR PARA CREAR UN NUEVO METODO QUE DIRECTAMENTE CREA LA FECHA CON
	// DATA DE SU CREACION
	public Caso(int id, String titulo, String descripcion, boolean resuelto, String sospechoso, String detective) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = LocalDate.now();
		this.sospechoso = sospechoso;
		this.detective = detective;
		this.resuelto = resuelto;
	}

	// Y OTRO CONSTRUCTOR CON CUAL SE PUEDE OBTENER LA FECHA
	public Caso(int id, String titulo, String descripcion, boolean resuelto, LocalDate fecha, String sospechoso,
			String detective) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.sospechoso = sospechoso;
		this.detective = detective;
		this.resuelto = resuelto;
	}

	public String getSospechoso() {
		return sospechoso;
	}

	public void setSospechoso(String sospechoso) {
		this.sospechoso = sospechoso;
	}

	public String getDetective() {
		return detective;
	}

	public void setDetective(String detective) {
		this.detective = detective;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isResuelto() {
		return resuelto;
	}

	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}

	@Override
	public String toString() {
		return "Caso{id=" + id + ", titulo='" + titulo + "', descripcion='" + descripcion + "', fecha=" + fecha
				+ ", resuelto=" + resuelto + ", sospechoso=" + sospechoso + ", detective=" + detective + "}";
	}

}
