package inf121.prt1;
/** Importar la libreria de entrada estandar Scanner */
import java.util.Scanner;
/**
 * Calculo del promedio y desviacion estandar de la muestra, usando programacion estructural.
 * 
 * @author Joel Barrera Quispe
 * Version 1.0 27/03/2025
 */
public class CalculoEstadistico {
    /** Clase main (principal) */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        String entrada;
        
        /** Ingresar los datos en una cadena que por el momento son solo 10*/
        do {
            System.out.print("Ingresar 10 numeros: ");
            entrada = leer.nextLine();
        } while (entrada.split(" ").length > 10);
        
        
        /** Convertir los datos a numeros reales y luego guardarlos en un vector de numeros */
        float[] datos = vectorDeValores(entrada);
        
        /** Calcular el promedio. Sabiendo el tamaño de los datos y el vector de datos */
        float promedio = promedio(datos.length, datos);
        System.out.println("Promedio: " + promedio);
        
        /** Aqui se calcula la desviacion estandar usando el dato anterior del promedio, el vector de datos y su longitud */
        System.out.println("Desviacion estandar: " + desviacionEstandar(datos.length, datos, promedio));
        
        /**
         * OBS:
         * Esto solo se realiza una vez. Para la siguiente vez aique borrar todo y emezar denuevo.
         * Si hay un error en cualquier calculo se ezpandira a todos los metodos, ya que el siguiente depende del anterior.
         * Las variables no se guardan solo se ingresan y se procesan.
         * La formula es entrada y salida no hay más proceso interno extra, todo se puede ver con claridad.
         * Es lo mismo pero mas barato.
         */
        
    }
    /** Convierte los valores de cadena a tipo punto flotante */
    public static float[] vectorDeValores(String valores){
        String[] nums = valores.split(" ");
        float[] reales = new float[nums.length];
        
        for (int i = 0; i < reales.length; i++) {
            reales[i] = Float.parseFloat(nums[i]);
        }
        
        return reales;
    }
    /** Calcula el promedio de la muestra dada, devuelve un dato con coma flotante */
    public static float promedio(int n, float[] x){
        float media = 0;
        for (int i = 0; i < n; i++) {
            media+=x[i];
        } 
        
        return media/=n;
    }
    /** Calcula la desviacion estandar de la muestra */
    /** S = sumatoria (i=1 hasta n) (xi - promedio) / n-1 todo en raiz cuadrada*/
    public static float desviacionEstandar(int n, float[] x, float promedio){
        float sumatoria = 0;
        
        for (int i = 0; i < n; i++) {
            sumatoria += (float) Math.pow((x[i] - promedio), 2);
        }
        sumatoria/=(n-1);
        sumatoria = (float) Math.sqrt(sumatoria);
        return sumatoria;
    }
    
}
