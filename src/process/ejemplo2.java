/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import java.io.IOException;
import java.util.Scanner;

/**
 * Crea un programa que ejecute varios comandos (notepad, calc, comandos shell)
 * uno detrás de otro, de forma secuencial y haz que tu programa obtenga el
 * código de finalización de cada uno de ellos. Para cada programa imprime el
 * nombre y su código de finalización.
 *
 * Prueba a poner aplicaciones que no existan o comandos con parámetros
 * incorrectos.
 *
 * ¿Qué hace Netbeans si pones System.exit(10) para acabar tu programa?. Fíjate
 * en la consola. ¿Qué hace Netbeans si pones System.exit(0) para acabar tu
 * programa.? Cuál es entonces el valor por defecto?
 *
 * @author DAM
 */
public class ejemplo2 {

    public static void main(String[] args) throws IOException {
        do {
            // Código para pedir un programa/comando a ejecutar
            Scanner teclado = new Scanner(System.in);
            System.out.println("Introduce el programa / comando que quieres ejecutar (intro para acabar): ");
            String comando = teclado.nextLine();

            if (comando.equals("")) {
                System.exit(0);
            }

            try {
                // Preparamos el entorno de ejecución del proceso
                // Como no sabemos el contenido del comando, forzamos su conversión
                // a una lista para que no haya problemas con su ejecución
                ProcessBuilder pb = new ProcessBuilder(comando.split("\\s"));

                // Lanzamos el proceso hijo
                Process p = pb.start();

                // Esperamos a que acabe para recoger el valor de salida
                int exitValue = p.waitFor();

                if (exitValue == 0) {
                    System.out.println("El comando " + pb.command().toString() + " ha finalizado bien");
                } else {
                    System.out.println("El comando " + pb.command().toString() + " ha finalizado con errores. Código (" + exitValue + ")");
                }

            } catch (InterruptedException | IOException ex) {
                System.err.println(ex.getLocalizedMessage());
                ex.printStackTrace();
            }
        } while (true);
    }

}
