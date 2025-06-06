package examenTrimestral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basicos {

	// CLASE BASICOS APRA NO ENSUCIAR EL MAIN, MAS COMODA Y AHORRA TIEMPO DISPONE DE DOS METODOS
	// LEER ENTEROS :
	public static int leerEnteros(String pregunta) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numero = 0;
		boolean valido = false;

		while (!valido) {
			try {
				System.out.println(pregunta + " ");
				numero = Integer.parseInt(br.readLine());
				valido = true;
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
		}
		return numero;
	}
	
	// LEER CADENAS:
	public static String leerCadenas(String pregunta) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cadena = null;
		boolean valido = false;

		while (!valido) {
			try {
				System.out.println(pregunta + " ");
				cadena = br.readLine();
				valido = true;
			} catch (IOException  e) {
				e.printStackTrace();
			}
		}
		return cadena;
	}
}
