package comunicacionprocesos;

import java.io.File;

/**
 *
 * @author DAM
 */
public class Lanzador {

    /**
     * Método que permite lanzar el proceso de la clase Sumador
     *
     * @param n1 parámetro que indica el número incial de la serie a sumar
     * @param n2 parámetro que indica el número final de la serie a sumar
     * @param ficheroResultado parámetro que indica el fichero donde se guardará
     * el resultado de la operación de sumar los números que hay entre n1 y n2
     */
    public void lanzarSumador(Integer n1, Integer n2, String ficheroResultado) {
        String clase = "comunicacionprocesos.Sumador";
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder(
                    "java",
                    clase,
                    n1.toString(),
                    n2.toString());
            pb.directory(new File("build/classes"));
            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(ficheroResultado));
            pb.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Lanzador l = new Lanzador();
        l.lanzarSumador(1, 5, "resultado1.txt");
        l.lanzarSumador(6, 10, "resultado2.txt");
        System.out.println("Ok");
    }
}
