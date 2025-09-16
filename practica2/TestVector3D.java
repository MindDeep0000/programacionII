package teoria1;

/**
 *
 * @author Joel Barrera Quispe
 * Veresion 1.0 15 de septiembre de 2025
 */
public class TestVector3D {
    public static void main(String[] args) {
        Vector3D A = new Vector3D(1, 0, 0);
        Vector3D B = new Vector3D(0, 1, 0);

        System.out.println("A = " + A);
        System.out.println("B = " + B);

        System.out.println("A + B = " + A.sumar(B));
        System.out.println("2 * A = " + A.multiplicarPorEscalar(2));
        System.out.println("||A|| = " + A.norma());
        System.out.println("A * B = " + A.productoEscalar(B));
        System.out.println("A x B = " + A.productoVectorial(B));
    }
}
