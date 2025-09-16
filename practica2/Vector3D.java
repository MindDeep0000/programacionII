package teoria1;

/**
 * Clase Vector3D
 * Representa un vector en el espacio tridimensional.
 * 
 * @author Joel Barrera Quispe
 * @version 1.0
 */
public class Vector3D {
    private double x;
    private double y;
    private double z;

    /**
     * Constructor del vector 3D
     */
    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Suma de vectores: A + B
     */
    public Vector3D sumar(Vector3D v){
        return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    /**
     * Multiplicación por un escalar: r * A
     */
    public Vector3D multiplicarPorEscalar(double r){
        return new Vector3D(this.x * r, this.y * r, this.z * r);
    }

    /**
     * Norma o magnitud del vector: ||A|| = sqrt(x² + y² + z²)
     */
    public double norma(){
        return Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
    }

    /**
     * Producto escalar: A · B = x1x2 + y1y2 + z1z2
     */
    public double productoEscalar(Vector3D v){
        return this.x*v.x + this.y*v.y + this.z*v.z;
    }

    /**
     * Producto vectorial: A × B
     * Formula: (y1z2 - z1y2, z1x2 - x1z2, x1y2 - y1x2)
     */
    public Vector3D productoVectorial(Vector3D v){
        double cx = this.y * v.z - this.z * v.y;
        double cy = this.z * v.x - this.x * v.z;
        double cz = this.x * v.y - this.y * v.x;
        return new Vector3D(cx, cy, cz);
    }

    /**
     * Representación del vector
     */
    @Override
    public String toString(){
        return "(" + this.x + ", " + this.y + ", " + this.z + ")";
    }
}

