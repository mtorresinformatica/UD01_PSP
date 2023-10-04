package proceso_padre_hijo2;

import java.io.*;
import java.util.Scanner;

/**
 * Crea un programa Java que visualice 5 veces la cadena que se le envía desde
 * los argumentos de main(). Si no se le envía ninguna cadena que muestre un
 * mensaje indicándolo y que finalice el programa con System.exit(1). 
 * A continuación, crea un segundo programa Java que introduzca por teclado una
 * cadena y ejecute el programa anterior para visualizar 5 veces esa cadena.
 *
 *
 * @author DAM
 */
public class Ejercicio2_ejecuta {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String cadena;
        System.out.print("Introduzca la cadena: ");
        cadena = sc.nextLine();

          String comando = "java proceso_padre_hijo2.Ejercicio2_parte1 "+cadena;
            ProcessBuilder pb = new ProcessBuilder(comando.split("\\s"));
            // se establece el directorio donde se encuentra el ejecutable
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
                    System.out.println("FINAL INCORRECTO...");
                    break;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }

    }

}
