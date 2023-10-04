/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processbuilder;

import java.io.IOException;
import java.util.Scanner;

/**
 * Usando la línea de comandos, pide al usuario qué acción quiere realizar
 * (apagar, reiniciar o suspender) y cuánto tiempo quiere dejar antes de
 * realizar la acción de apagado del sistema..
 *
 * La aplicación tiene que preparar el comando correcto para la selección que
 * haya hecho el usuario y para el sistema operativo en el que la esté
 * ejecutando.
 *
 * Muestra por consola el resultado del método ProcessBuilder.command() de forma
 * legible.
 *
 * @author DAM
 */
public class Shutdowner {

    public static void main(String[] args) throws IOException {
        // Ask for the required information to prepare the command
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Select your option (s-shutdown / r-reboot / h-hibernate): ");
        String shutdownOption = keyboard.nextLine();

        System.out.print("How much seconds will the command wait to be run? (0 means immediately): ");
        String shutdownTime = keyboard.nextLine();

        // Prepare the command
        String command;
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            command = "C:/Windows/System32/shutdown /" + shutdownOption + " /t " + shutdownTime;
        } else {
            command = "shutdown -" + shutdownOption + " -t " + shutdownTime;
        }

        // Prepare the process and launch it
        ProcessBuilder shutdowner = new ProcessBuilder(command.split("\\s"));
        shutdowner.start();

        // Show the command to be run
        System.out.print("El comando a ejecutar es:  ");
        for (String commandPart : shutdowner.command()) {
            System.out.print(commandPart + " ");
        }
        System.out.println("");
    }

}
