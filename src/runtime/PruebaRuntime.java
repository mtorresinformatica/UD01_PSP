
package runtime;

import java.io.IOException;

/**
 * Ejecutar un programa externo desde Java con el método
 * Runtime.getRuntime().exec().
 *
 * @author DAM
 */
public class PruebaRuntime {

    public static void main(String[] args) throws IOException, InterruptedException {

        Process proceso = Runtime.getRuntime().exec("notepad");

        int codigoRetorno = proceso.waitFor();
        System.out.println("Fin de la ejecución: " + codigoRetorno);
    }

}
