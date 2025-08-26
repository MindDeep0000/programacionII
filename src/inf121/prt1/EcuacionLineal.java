package inf121.prt1;

/**
 * Clase EcuacionLineal, cuyo objetivo es calcular los valores de sus soluciones
 * x, y.
 *
 * @author Joel Barrera Quispe Version 1.0 27/08/2025
 *
 */
public class EcuacionLineal {
    /** Atributos principales de la clase EcuacionLineal */

    private float a, b, c, d, e, f;

    /*Construye un objeto de la clase EcuacionLineal*/
    public EcuacionLineal(float a, float b, float c, float d, float e, float f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    /* Retorna verdadero o false si la ecuacion tiene solucin */
    public boolean tieneSolucion() {
        float restriccion = (a * d - b * c);
        boolean condicion = (restriccion != 0) ? true : false;
        return condicion;
    }

    /*Retorna una solucion de la ecuación para X*/
    public float getX() {
        return (float) Math.floor((c * d - b * f) / (a * d - b * c));
    }

    /*Retorna una solucion de la ecuación para Y*/
    public float getY() {
        return (float) Math.floor((a * f - e * c) / (a * d - b * c));
    }

    /* Devuelve una cadena (que contiene valores de los atributos del objeto) */
    public String toString() {
        return String.format("%.1f %.1f %.1f %.1f %.1f %.1f", this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
