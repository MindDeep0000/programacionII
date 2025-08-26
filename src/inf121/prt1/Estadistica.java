package inf121.prt1;
/**
 * Clase estadistica, que calcula la desviacion estandar y el promedio de una muestra dada.
 * 
 * @author Joel Barrera Quispe
 * Version 1.0 27/08/2025
 */

/** Declaracion de la clase estadistica */
public class Estadistica {
    /** declaracion de los atributos perteneientes a esta clase. */
    /** n: tamaño de la muestra, x[]: vector de valores pertenecientes a la muestra recogida. */
    private int n;
    public float[] x;
    
    /** creacion del constructor para la clase estadistica, n: es el tamaño de la muestra */
    public Estadistica(int n){
        this.n = n;
        this.x = new float[n];
    }
    /** metodo que recibe una cadena de valores que procesados dan como resultado un vector de datos 
     * en punto flotante.
     */
    public void extraerValores(String datos){
        String[] nums = datos.split(" ");
        
        for (int i = 0; i < x.length; i++) {
            x[i] = Float.parseFloat(nums[i]);
        }
    }
    /** calculo de la media o promdeio para saber cual es la medida de mayor tendencia. */
    public float promedio(){
        float media = 0;
        for (int i = 0; i < n; i++) {
            media+=x[i];
        } 
        
        return media/=n;
    }
    
    /** calculo de la desviacion estandar de una muestra que  proporciona una 
     * estimación de la dispersión de los datos en torno a la media de esa muestra.
     */
    public float desviacionEstandar(float promedio){
        float sumatoria = 0;
        
        for (int i = 0; i < n; i++) {
            sumatoria += (float) Math.pow((x[i] - promedio), 2);
        }
        sumatoria/=(n-1);
        sumatoria = (float) Math.sqrt(sumatoria);
        return sumatoria;
    }    
}

/**

* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
*                                                               *
*     VENTAJAS DE USAR LA PROGRAMACION ORIENTADA A OBJETOS      *
*                                                               *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *

PUNTOS CLAVE

1.-Reutilización de código
->  Es posible reutilizar bloques de código ya implementados, evitando escribir lo mismo varias veces.


2.-Mantenimiento más sencillo
->  Los programas orientados a objetos están mejor organizados en clases y objetos, lo que facilita localizar errores y corregirlos sin afectar otras partes del sistema.


3.-Modularidad
->  El código se divide en módulos (clases y objetos) que representan entidades reales, lo que mejora la organización y la comprensión del programa.


4.-Encapsulamiento y protección de datos
->  Los atributos de un objeto pueden protegerse mediante modificadores de acceso, evitando que se alteren de forma indebida y asegurando la integridad de los datos.


5.-Facilidad para resolver problemas complejos
->  Un problema grande puede dividirse en subproblemas más pequeños, representados en diferentes clases, lo que simplifica la solución.


6.-Flexibilidad con múltiples objetos
->  Se pueden crear varios objetos de la misma clase, cada uno con sus propios atributos y comportamientos, adaptándose a diferentes necesidades.


7.-Menor redundancia de datos
->  Mediante el uso de referencias (como la palabra clave this) se diferencia claramente entre los atributos de un objeto y los parámetros de un método, evitando duplicación y confusión.


8.-Polimorfismo
->  Permite que un mismo método tenga diferentes implementaciones según el objeto que lo use, aumentando la flexibilidad y adaptabilidad del programa.


9.-Escalabilidad
->  Los sistemas orientados a objetos pueden crecer fácilmente añadiendo nuevas clases o ampliando las existentes, sin necesidad de modificar todo el código.


10.-Reutilización en distintos proyectos
->  Una vez que se diseñan clases bien estructuradas, estas pueden ser exportadas y reutilizadas en futuros proyectos, reduciendo tiempos de desarrollo.

* 
*/