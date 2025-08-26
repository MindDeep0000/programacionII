package inf121.prt1;
import java.util.Scanner;
/**
 * Clase TestEcuacionLineal (main)
 *
 * @author Joel Barrera Quispe
 * Version 1.0 27/08/2025
 */
public class TestEcuacionLineal {
    // Método principal
    public static void main(String[] args) {
        
        // Clase Scanner para entrada de datos atrvez de teclado.
        Scanner in = new Scanner(System.in);
        
        // Ingresar datos en la cadena "entrada", separados por un espacio.
        System.out.print("Ingresar a, b, c, d, f: ");
        String entrada = in.nextLine();

        /** 
         * obtenerValores() devuelve un vector de números con coma flotante que se 
         * almacenan en R, en el mismo orden en el que de ingresaron (entrada) y contados
         * empezando desde el 0.
        */
        float[] R = obtenerValores(entrada);
        
        /**
         * Creacion del objeto (cuadrada) atravez de la palabra reservada new.
         */
        EcuacionLineal cuadrada = new EcuacionLineal(R[0], R[1], R[2], R[3], R[4], R[5]);

        /**
         * el objeto cuadrada atravez del metodo (tieneSolucion()) devuelve
         * TRUE o FALSE, segun se de el caso de que la ecuacion enga solucion o no.
         */
        if (cuadrada.tieneSolucion()) {
            System.out.println("X: " + cuadrada.getX() + " Y: " + cuadrada.getY());
            /**
             * getX() calcula la solución para X.
             * getY() calcula la solución para Y.
             */
            
        } else {
            System.out.println("No tiene solucion");
            // Se muestra en pantalla que la ecuación no tiene solución.
        }              
        
        System.out.println("a, b, c, d, e, f"+cuadrada.toString());
    }
    
    /** obtenerValores(): float
     *  entrada: String
     *  devuelve : float R[] (vector de números en coma flotante)
     */
    public static float[] obtenerValores(String entrada) {
        // creación del vector de cadenas A, atravez de split que hace que la cadena se divida en diferentes partes cuando encuentre un espacio.
        String[] A = entrada.split(" ");
        
        // creación del vector R tipo flotante.
        float[] R = new float[A.length];
        
        // proceso de recorrido de ambos vectores, para convertir todos los valroes del vector A a tipo flotante en R
        for (int i = 0; i < R.length; i++) {
            R[i] = Float.parseFloat(A[i]);
        }
        return R;
    }
}
