package proceso_entrada_salida;

import java.io.*;

/**
 *
 * @author DAM
 */
public class EntradaSalida {

    public static void main(String[] args) {
        String texto = "";

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        try {

            while (!texto.equals("*")) {
                System.out.print("Introduce una cadena (* para terminar): ");
                texto = br.readLine();
                System.out.println("Cadena introducida: " + texto);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //otra forma
        /*
			Scanner sc = new Scanner(System.in);
			try {
				while (!texto.equals("*")) {
					System.out.printf("Introduce una cadena (* para terminar): ");
					texto = sc.nextLine();
					System.out.println("Cadena introducida: "+texto);
					
				}
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
         */
    }

}
