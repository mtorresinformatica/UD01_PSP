/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package process;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author DAM
 */
public class ejemplo1 {
    
    public static void main(String[] args) throws Exception {

      ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\notepad.exe");
      // Effectively launch the process
      Process p = pb.start();
      // Check is process is alive or not
      boolean alive = p.isAlive();
        System.out.println(alive);
      // Wait for the process to end for 10 seconds.
      if (p.waitFor(10, TimeUnit.SECONDS)) {
          System.out.println("Process has finished");
      } else {
          System.out.println("Timeout. Process hasn't finished");
      }
      // Force process termination.
      p.destroy();
      // Check again if process remains alive
      alive = p.isAlive();
      System.out.println(alive);
      // Get the process exit value
        int status = p.exitValue(); 
        System.out.println(status);
   }
}
