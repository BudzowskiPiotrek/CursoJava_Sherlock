package examenTrimestral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conector {
	private static final String URL = "jdbc:mysql://localhost:3306/sherlock";
	private static final String USUARIO = "root";
	private static final String CONTRASENA = "";

	private static Connection conn = null;

	// CONECTOR VACIO PARA TENER CONTROL, TAMBIEN LO PODRIA INICAILIZAR CON METODO
	// CONECTAR DIRECTAMENTE, PERO ME APRECE ASI MEJOR
	public Conector() {
	}

	public void conectar() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
				System.out.println("Conexión a base de datos de Sherlock holmes lista.");
			} catch (SQLException e) {
				System.out.println("Error al conectar a la base de datos");
			}
		}
	}

	// METODO PARA DESCONECTAR, Y LE PREGUNTE SI QUEIRE EL SYSOUT QUE LE INFORME QUE
	// BASE SE HA DESONECTADO
	public void desconectar() {
		conn = null;
		if (conn == null) {
			System.out.println("Conexión a base de datos de Sherlock holmes apagada");
		}
	}

	// PARTE DE CODIGO SQL QUE LUEGO SE INGRESA EN EL METODO INGRESAR DATOS
	public int anadirDetective(String nombre, String especialidad) {
		int resultado = -1;
		String sql = "INSERT INTO detective (nombre,especialidad) VALUES ('" + nombre + "','" + especialidad + "')";
		resultado = ingresarDatos(sql);
		return resultado;
	}

	// ESTE METODO ES COMO UNA BASE, COMO SIEMPRE ES LO MISMO SOLO PONGO POR FUERA
	// EL CODIGO SQL
	public int ingresarDatos(String sql) {
		int resultado = -1;
		if (conn != null) {
			try (Statement aux = conn.createStatement()) {
				resultado = aux.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("Error");
			}
		} else {
			System.out.println("No se pudo establecer la conexión a la base de datos.");
		}
		return resultado;
	}

	// METODO QUE SACA DATOS CORESPONDIENTES QUE SE PIDE PARA EL METODO DEL MAIN
	public List<Caso> listarCasosBD(int tipo) {
		List<Caso> lista = new ArrayList<>();
		if (conn != null) {
			String sql = "SELECT caso.*, sospechoso.nombre AS SNombre, detective.nombre AS DNombre "
					+ "FROM caso LEFT JOIN detective ON caso.id= detective.id LEFT JOIN sospechoso ON caso.id=sospechoso.id "
					+ "WHERE caso.resuelto=" + tipo;
			try (Statement aux = conn.createStatement(); ResultSet res = aux.executeQuery(sql)) {
				while (res.next()) {
					int id = res.getInt("id");
					String titulo = res.getString("titulo");
					String descripcion = res.getString("descripcion");
					LocalDate fecha = LocalDate.parse(res.getString("fecha_apertura"));
					boolean resuelto = res.getBoolean("resuelto");

					String sospechoso = res.getString("SNombre");
					if (tipo == 0) {
						sospechoso = "N/A";
					}
					String detective = res.getString("DNombre");

					lista.add(new Caso(id, titulo, descripcion, resuelto, fecha, sospechoso, detective));

				}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		} else {
			System.out.println("La conexión está cerrada o no disponible.");
		}
		return lista;

	}

	// METODO PARA SABER SI ES CULPABLE, MIRA SI HAY REGISTRO QUE CUMPLE CON LOS DOS
	// PARAMETROS, SI ES ASI PUES CAMBIA CASO A RESUELTO
	public int saberSiEsCulpable(int idCaso, int culpable) {
		int resultado = -1;
		if (conn != null) {
			String sql = "SELECT * FROM caso WHERE id=" + idCaso + " and sospechoso_id=" + culpable;
			try (Statement aux = conn.createStatement(); ResultSet res = aux.executeQuery(sql)) {
				if (res.next()) {
					resultado = 1;
					sql = "UPDATE caso SET resuelto=1 WHERE id=" + idCaso;
					ingresarDatos(sql);
				} else {

				}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		} else {
			System.out.println("La conexión está cerrada o no disponible.");
		}
		return resultado;

	}

	// METODO PARA SABER PELIGROSIDAD Y QUE ARMA SE UTILIZO EN UN CASO DADO
	public String saberArmaPeligrosidad(int id) {
		String cadena = null;
		if (conn != null) {
			String sql = "SELECT * FROM sospechoso WHERE id=" + id;
			try (Statement aux = conn.createStatement(); ResultSet res = aux.executeQuery(sql)) {
				if (res.next()) {

					int peligrosidad = res.getInt("nivel_peligrosidad");
					String arma = res.getString("arma");

					cadena = "En este caso el sospechoso tiene un nivel de criminalidad: " + peligrosidad
							+ " y utilizo el arma: " + arma;
				} else {
					cadena = "En este caso el sospechoso tiene un nivel de criminalidad: desconocida y utilizo el arma: desconocida";
				}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		} else {
			System.out.println("La conexión está cerrada o no disponible.");
		}
		return cadena;
	}

	// METODO PARA LSITAR LOS SOSPECHOSOSO
	public List<Sospechoso> listarSospechosos() {
		List<Sospechoso> lista = new ArrayList<>();
		if (conn != null) {
			String sql = "SELECT * FROM sospechoso";
			try (Statement aux = conn.createStatement(); ResultSet res = aux.executeQuery(sql)) {
				while (res.next()) {
					int id = res.getInt("id");
					String nombre = res.getString("nombre");
					int peligrosidad = res.getInt("nivel_peligrosidad");
					String arma = res.getString("arma");

					lista.add(new Sospechoso(id, arma, peligrosidad, arma));
				}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		} else {
			System.out.println("La conexión está cerrada o no disponible.");
		}
		return lista;
	}

	// METODO PARA LISTA LAS ESPECIALIDADES
	public List<String> listarEspecialidades() {
		List<String> lista = new ArrayList<>();
		if (conn != null) {
			String sql = "SELECT DISTINCT especialidad FROM detective";
			try (Statement aux = conn.createStatement(); ResultSet res = aux.executeQuery(sql)) {
				while (res.next()) {
					String especialidad = res.getNString("especialidad");
					lista.add(especialidad);

				}
			} catch (SQLException e) {
				System.out.println("Error");
			}
		} else {
			System.out.println("La conexión está cerrada o no disponible.");
		}
		return lista;
	}

}
