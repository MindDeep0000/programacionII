package clases;
/**
 *
 * @author Joel Barrera Quispe
 * 8 de de septiembre de 2025
 * version 1.0
 * Clase TestCirculo2D 
 */
public class TestCirculo2D {
    /** metodo principal */
    public static void main(String[] args) {
        /** instanciar el objeto c1, cuyos atributos principales son: centro(2,0) y radio = 1*/
        Circulo2D c1 = new Circulo2D(2,0,1);
        /** calcular el area del mismo circulo */
        System.out.println("area: " + c1.getArea());
        /** calcular el perimetro del circulo */
        System.out.println("perimetro: " + c1.getPerimetro());
        
        /** operacion contiene: verificar si P(2.5, 0) esta dentro del circulo instanciado */
        System.out.println("contiene: P(2.5, 0)? " + c1.contiene(2.5,0));
        /** operacion contiene: verificar si el nuevo circulo con atributos: centro(2,0) y radio=0.5, esta dentro dentro del circulo c1*/
        System.out.println("Contiene: Circulo2D(2, 0, 0.5)? " + c1.contiene(new Circulo2D(2,0,0.5)));
        /** operacion sobrepone: verificar si el nuevo cuirculo creado con atributos: c(0,0) y r=2, sobrepone al circulo c1 */
        System.out.println("Sobrepone: Circulo2D(0, 0, 2)? " + c1.sobrepone(new Circulo2D(0, 0, 2)));
        
    }
}
