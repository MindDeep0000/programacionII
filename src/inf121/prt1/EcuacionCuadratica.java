package inf121.prt1;

/**
 * Clase EcuacionCuadratica, sirve para calcular las raices de la ecuación cuadratica 
 * cuyos parametros son los valores a, b y c.
 * 
 * @author Joel Barrera Quispe
 * Vesrion 1.0 27/08/2025
 * 
 */
public class EcuacionCuadratica {
    /** Atributos (a, b, c) de la clase EcuacionCuadratica tipo Double*/
    private double a, b, c;
    
    /** creacion de constructor para un objeto de la clase EcuacionCuadratica */
    public EcuacionCuadratica(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    /** double getDiscriminante() para calcular si es posible obtener
     * soluciones reales.
     */
    public double getDiscriminante(){
        return (b*b) - (4*a*c);
    }
    
    /** Método para calcular la raiz X1 de la ecuación. */
    public double getRaiz1(){
        double r1;
        r1 = ( -b + Math.sqrt( (b*b) - (4*a*c)) ) / (2*a);
        return r1;
    }
    
    /** Método para calcular la raiz X2 de la ecuación. */
    public double getRaiz2(){
        double r2;
        r2 = ( -b - Math.sqrt( (b*b) - (4*a*c)) ) / (2*a);
        return r2;
    }
    /** Metodo para procesar dato tipo double y devolver un numero con 4 decimales  */
    public String toString(double e){
        return String.format("%.4f", e);
    }
}
