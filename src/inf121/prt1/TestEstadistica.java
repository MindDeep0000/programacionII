package inf121.prt1;

/**
 * Clase Estadistica (main)
 *
 * @author Joel Barrera Quispe Version 1.0 27/08/2025
 */

/**
 * importar la libreria estandar de entrada de datos Scanner.
 */
import java.util.Scanner;

public class TestEstadistica {

    /**
     * Clase main
     */
    public static void main(String[] args) {
        /**
         * Instanciar un objeto de la clase Scanner
         */
        Scanner leer = new Scanner(System.in);
        
        String entrada;

        /**
         * Ingresar datos de la muestra solo deben ser 10 por el momento
         */
        do {
            System.out.print("Ingresar 10 numeros: ");
            entrada = leer.nextLine();
        } while (entrada.split(" ").length > 10);

        int tamanio = entrada.split(" ").length;

        /**
         * Instanciar un objeto de la clase estadistica
         */
        Estadistica desv_muestra = new Estadistica(tamanio);

        /**
         * Convertir datos de la cadena de entrada a numeros de tipo reales
         * (double)
         */
        desv_muestra.extraerValores(entrada);

        /**
         * calcular el promedio de la muestra insertada
         */
        float promedio = desv_muestra.promedio();

        /**
         * Calcular la desviacion estandar muestral de la muestra insertada y
         * mostrar todo en pantalla
         */
        System.out.println("promedio: " + promedio);
        System.out.println("Desviacion estandar: " + desv_muestra.desviacionEstandar(promedio));
    }
}
