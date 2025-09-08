package clases;

/**
 *
 * @author Joel Barrera Quispe
 * 8 de de septiembre de 2025
 * version 1.0
 * Clase Circulo2D 
 */
public class Circulo2D {
    /** atributos centro(x,y) y radio  */
    private double x, y, radio;
    
    /** constructor por default */
    public Circulo2D(){
        this.x = 0;
        this.y = 0;
        this.radio = 1;
    }
    /** constructor con parametros especificados */
    public Circulo2D(double x, double y, double radio){
        this.x = x;
        this.y = y;
        this.radio = radio;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @return the radio
     */
    public double getRadio() {
        return radio;
    }
    
    
    /** calcula el area del circulo */
    public double getArea(){
        return Math.PI * Math.pow(this.getRadio(), 2);
    }
    
    /** calcula el perimetro del circulo */
    public double getPerimetro(){
        return 2* Math.PI * this.radio;
    }
    
    
    /** calcula si el punto dado esta dentro del conjunto de puntos de la circunferencia */
    public boolean contiene(double x, double y){
        double ecuacion = Math.pow( ( x - this.getX() ), 2 ) + Math.pow( ( y - this.getY() ), 2 );
        boolean contiene = (ecuacion < Math.pow(this.radio, 2)) ? true : false;
        return contiene;
    }
    
    
    /** calcula la diferencia entre centros de los circulos, los cuales no deben sobrepasar la diferencia enntre los radios de los dos cirulos */
    public boolean contiene(Circulo2D circulo){
        double calculo = Math.pow( ( (this.getX() - circulo.getX() ) )  ,  2 ) + Math.pow( ( this.getY() - circulo.getY() ) , 2);
        
        boolean contener = ( calculo <= ( this.getRadio() - circulo.getRadio() ) )?true:false;
        
        return contener;
    }
    
    /** calcula la distancia entre puntos y devuelve true si es menor a la suma de los radios, lo contrario devuelve false */
    public boolean sobrepone(Circulo2D circulo){
        double contiene = Math.sqrt( Math.pow( ( this.getX() - circulo.getX() ) , 2)  + Math.pow( ( this.getY() - circulo.getY() ) , x) );
        boolean sobrepone = (contiene < (this.getRadio() + circulo.getRadio())) ? true: false;
        return sobrepone;        
    }
}
