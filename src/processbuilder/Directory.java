/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package processbuilder;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author DAM
 */
public class Directory {
    
    public static void main(String[] args) throws IOException {
        // Prepare the command
        String command;
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            command = "cmd -c dir";
        } else {
            command = "sh -c ls";
        }
        
        // Prepare the process and launch it
        ProcessBuilder commander = new ProcessBuilder(command.split("\\s"));
        
        //1st - Default working directory
        System.out.println("Working directory: " + commander.directory());
        System.out.println("user.dir variable: " + System.getProperty("user.dir"));
        
        //2nd - Set the user.dir
        System.setProperty("user.dir", System.getProperty("user.home"));
        System.out.println("Working directory: " + commander.directory());
        System.out.println("user.dir variable: " + System.getProperty("user.dir"));
        
        // 3rd - Change the working directory
        commander.directory(new File(System.getProperty("user.home")));
        System.out.println("Working directory: " + commander.directory().toString());
        System.out.println("user.dir variable: " + System.getProperty("user.dir"));
        
        commander.start();        
    }
}
