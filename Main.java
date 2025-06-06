package examenTrimestral;

import java.util.List;

public class Main {
	// CREO EL CONECTOR POR FUERA
	public static Conector conector = new Conector();

	public static void main(String[] args) {
		// ARANCO LA CONECION CON LA CLASE CONECTORA lo podria tambien auto invocar el
		// metodo en constructor pero asi me gusta mas
		conector.conectar();
		menuPrincipal();
	}

	// METODO CON MENU PRINCIPAL
	private static void menuPrincipal() {
		int opcion = 0;
		while (opcion != 7) {
			textoMenu();
			opcion = Basicos.leerEnteros("Selecciona una opcion:");
			menuSwitch(opcion);
		}

	}

	// METODO QUE CONTIENE EL TEXTO DE MENU PRINCIPAL
	private static void textoMenu() {
		System.out.println("1. Listar Especialidades");
		System.out.println("2. Añadir detectives");
		System.out.println("3. Listar Sospechosos");
		System.out.println("4. Listar Casos Resuletos");
		System.out.println("5. Listar Casos Pendientes");
		System.out.println("6. Resolver Casos pendientes");
		System.out.println("7. Salir");
	}

	// METODO CON EL SWITCH DE LA APP
	private static void menuSwitch(int opcion) {
		switch (opcion) {
		case 1:
			listarEspecialidades();
			break;
		case 2:
			anadirDetectives();
			break;
		case 3:
			listarSospechosos();
			break;
		case 4:
			listarCasos(1);
			break;
		case 5:
			listarCasos(0);
			break;
		case 6:
			resolverCaso();
			break;
		case 7:
			conector.desconectar(); // COMO ES SOLO UNA LINE NO CREO SU PROPIO METODO
			break;

		default:
			System.out.println("Entrada invalida, vuelve a intentar");
			break;
		}

	}

	// METODO DE LSITAR ESPECIALIDADES
	private static void listarEspecialidades() {
		System.out.println("Especialidades de la agencia:");
		List<String> lista = conector.listarEspecialidades();
		for (String s : lista) {
			System.out.println(s);
		}
	}

	// METODO PARA AÑADIR DETECTIVES
	private static void anadirDetectives() {
		String nombre = Basicos.leerCadenas("Ingrese nombre del detective:");
		String especialidad = Basicos.leerCadenas("Ingrese especialidad del detective");
		if (conector.anadirDetective(nombre, especialidad) > 0) {
			System.out.println("Detective insertado correctamente");
		} else {
			System.out.println("No se pudo intertar el detective");
		}
	}

	// METODO PARA LISTAR SOSPECHOSOS
	private static void listarSospechosos() {
		System.out.println("Lista de Sospechosos");
		List<Sospechoso> lista = conector.listarSospechosos();
		for (Sospechoso s : lista) {
			System.out.println(s.toString());
		}
	}

	// METODO PARA LSITAR CASOS
	private static void listarCasos(int tipo) {
		if (tipo == 0) {
			System.out.println("Casos no Resueltos:");
		} else {
			System.out.println("Casos Resueltos:");
		}
		List<Caso> lista = conector.listarCasosBD(tipo);
		for (Caso c : lista) {
			System.out.println(c.toString());
		}
	}

	// METODO PARA RESOLVER CASO
	private static void resolverCaso() {
		System.out.println("A continuacion se muestran los casos no resueltos:\n");
		listarCasos(0);
		int elecion = Basicos.leerEnteros("Indique el id del saco que quieres resolver");
		System.out.println(conector.saberArmaPeligrosidad(elecion) + "\n");
		listarSospechosos();
		int elecionDos = Basicos.leerEnteros("Dime cual es el culpable");
		if (conector.saberSiEsCulpable(elecion, elecionDos) == 1) {
			System.out.println("Enorabuena has resuelto el caso. Eres digno sucesor de Sherlock");
			System.out.println("Actualizacion realizada con exito ya nos quedan menos casos pendientes");
		} else {
			System.out.println("No es el, mala suerte");
		}
	}
}
