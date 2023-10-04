package proceso_entrada_salida;

import java.io.*;
import java.util.Scanner;

 /**
 *
 * @author DAM
 */
public class Ejecuta {

	public static void main(String[] args) throws IOException {

		ProcessBuilder pb = new ProcessBuilder("java", "C:\\Users\\Manolo\\Documents\\NetBeansProjects\\UD1\\src\\proceso_entrada_salida\\EntradaSalida.java");

		// Salida a consola
		pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

		// La cadena esta en un fichero
		File fichero = new File("Datos.txt");
		pb.redirectInput(fichero);

		// salida de error a fichero
		File fErr = new File("Ferror.txt");
		pb.redirectError(fErr);

		// se ejecuta el proceso
		Process p = pb.start();

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

