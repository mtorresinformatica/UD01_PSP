package proceso_padre_hijo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Realiza un programa Java que admita argumentos desde main() y devuelva con
 * System.exit()los siguientes valores: 
 * Si el número de argumentos es menor de 1 debe devolver 1. 
 * Si el argumento es una cadena debe devolver 2. 
 * Si el argumento es un número entero menor que 0 debe devolver 3. 
 * En cualquier otra situación debe devolver 0. 
 * 
 * Realiza un segundo programa Java que ejecute al anterior.
 * Este segundo programa deberá mostrar en pantalla lo que pasa dependiendo del
 * valor devuelto al ejecutar el programa anterior.
 *
 * @author DAM
 */
public class Ejercicio1_ejecuta {

    public static void main(String[] args) throws IOException {


       // Establecemos los parámetros del objeto ProcessBuilder
        String comando = "java proceso_padre_hijo1.Ejercicio1_parte1 -4";
        ProcessBuilder pb = new ProcessBuilder(comando.split("\\s"));
        pb.directory(new File("build/classes"));
      
        // se ejecuta el proceso
        Process p = pb.start();

        try {
            InputStream er = p.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null) {
                System.out.println("ERROR >" + liner);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // COMPROBACION DE la salida del programa
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
            switch (exitVal) {
                case (0):
                    System.out.println("FINAL CORRECTO...");
                    break;
                case (1):
                    System.out.println("FALTA UN PARÁMETRO...");
                    break;
                case (2):
                    System.out.println("PARÁMETRO NO NUMERICO...");
                    break;
                case (3):
                    System.out.println("PARÁMETRO MENOR QUE 0...");
                    break;

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
