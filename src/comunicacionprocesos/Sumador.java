package comunicacionprocesos;

/**
 *
 * @author DAM
 */
public class Sumador {

    /**
     * Método que permite sumar los números que hay entre un valor incial y otro
     * final
     * @param n1 parámetro que indica el número incial de la serie a sumar
     * @param n2 parámetro que indica el número final de la serie a sumar
     * @return el método devolverá un resultado entero con la suma de la serie
     */
    public static int sumar(int n1, int n2) {
        int resultado = 0;
        for (int i = n1; i <= n2; i++) {
            resultado = resultado + i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int n1 = Integer.parseInt(args[0]);
        int n2 = Integer.parseInt(args[1]);
        int resultado = sumar(n1, n2);
        System.out.println(resultado);
    }
}
