package inf121.prt1;
/** importar la libreria estandar Scanner la más usada para entrada de datos en java. */
import java.util.Scanner;
/**
 * Clase TestEcuacionLineal cuyo objetico principal ee encontrar las raices de la ecuacion cuadratica.
 *
 * @author Joel Barrera Quispe
 * 
 * Version 1.0 27/08/2025
 */
public class TestEcuacionCuadratica {
    /* clase principal */
    public static void main(String[] args) {
        /* Clase Scanner para la entrada de datos */
        Scanner leer = new Scanner(System.in);
        
        /* Creación del vector de números reales de tamaño 3 */
        double [] R = new double[3];
        
        /** entrada de datos procesados, los cuales se guardan en el vector R */
        
        do {
            System.out.print("Ingresar a, b, c: ");
            String entrada = leer.nextLine();
            
            if( (entrada.split(" ")).length == 3){
                /** Método obtenerValores() para procesar la entrada */
                R = obtenerValores(entrada);
            }
            
        } while(R[0] == 0);

        /** creación del objeto ec1 (usando la palabra new) de la clase EcuacionCuadratica */
        EcuacionCuadratica ec1 = new EcuacionCuadratica(R[0], R[1], R[2]);
        
        /** ec1 atravez del método getDiscriminante() calcula si es posible calcular las raices de la ecuacion */
        
        if(ec1.getDiscriminante()>0){
            // para el caso getDicriminante() > 0
            /** getRaiz1() y getRaiz2() calcula los valores de las 2 soluciones reales. */
            
            double x1 = ec1.getRaiz1();
            double x2 = ec1.getRaiz2();
            
            System.out.println("r1: " + ec1.toString(x1) + "  r2: " + ec1.toString(x2));
        }else if (ec1.getDiscriminante()==0){
            /** si getDiscriminante()=0 se tiene una unica solución que puede ser x1 o x2
             * esta se muestra en pantalla.
             */
            System.out.println("r: " + ec1.getRaiz1());
        } else {
            /** Si la discriminante es egativa, entonces se muestra en pantalla la advertenia. */
            System.out.println("Sin soluciones reales");
        }
        
    }
    
    /** obtenerValores() convierte la cadena "entrada" ingresada por teclado
     *  en un vector de números reales.
     */
    public static double[] obtenerValores(String entrada) {
        String[] A = entrada.split(" ");
        double[] R = new double[A.length];
        for (int i = 0; i < R.length; i++) {
            R[i] = Double.parseDouble(A[i]);
        }

        return R;
    }
}
