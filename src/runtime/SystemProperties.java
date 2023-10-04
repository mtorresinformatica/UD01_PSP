/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package runtime;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Properties;

/**
 * Usando métodos de las clases System y Runtime hacer un programa que muestre
 * todas las propiedades establecidas en el sistema operativo y sus valores.
 * memoria total, memoria libre, memoria en uso y los procesadores disponibles
 *
 * @author DAM
 */
public class SystemProperties {

    public static void main(String[] args) {

        long freeMemory = Runtime.getRuntime().freeMemory();
        long availableMemory = Runtime.getRuntime().totalMemory();
        long usedMemory = availableMemory - freeMemory;


// Show system information
// Memory will be shown in MBytes formatted with 2-decimal places
        DecimalFormat megabytes = new DecimalFormat("#.00");
        System.out.println("Available memory in JVM(Mbytes): "
                + megabytes.format((double) availableMemory / (1024 * 1024)));
        System.out.println("Free memory in JVM(Mbytes): "
                + megabytes.format((double) freeMemory / (1024 * 1024)));
        System.out.println("Used memory in JVM(Mbytes): "
                + megabytes.format((double) usedMemory / (1024 * 1024)));

        System.out.println("Processors in the system: "
                + Runtime.getRuntime().availableProcessors());

        /**
         * * System.getProperties() usage **
         */
// Show each pair of property:value from System properties
// 1st. As a lambda expression using anonymous classes
        System.getProperties().forEach((k, v) -> System.out.println(k + " => " + v));

// 2nd. As a Map.entrySet 
        for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("> " + key + " => " + val);
        }

// 3rd. As a Map.keySet
        for (Object key : System.getProperties().keySet().toArray()) {
            System.out.println(">> " + key + ":" + System.getProperty(key.toString()));
        }

// Other methods found by students, based on a Properties object methods.
        Properties prop = System.getProperties();
        for (String propName : prop.stringPropertyNames()) {
            System.out.println(propName + ":" + System.getProperty(propName));
        }

// Or directly to the console using 
        prop.list(System.out);

    }

}
