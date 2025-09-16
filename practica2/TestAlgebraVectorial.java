
package teoria1;

/**
 * Clase TestAlgebraLineal, para realizar operaciones entre vectores
 * @author Joel Barrera Quispe
 * 15 de septiembre de 2025
 */
public class TestAlgebraVectorial {
    public static void main(String[] args) {
        double[] vA = {1.0, 0.0, 0.0};
        double[] vB = {0.0, 1.0, 0.0};
        /**
         * Instanciar los objetos A y B con numeros de elementos y el arreglo.
         */
        AlgebraVectorial A = new AlgebraVectorial(3, vA, "A");
        AlgebraVectorial B = new AlgebraVectorial(3, vB, "B");
        
        /** 
         * Mostrar los elementos del vector A y B
         */
        System.out.println(A.toString() );
        
        System.out.println( B.toString() );
        
        if(A.Dim(B)){ //Vecrificar que los vecttores sean de la misma dimenssion
            /**
             * Se realizan operaciones entre vectores
             */
            System.out.println("|a + b| = |a - b| ? - - -> " + A.perpendicular(false, B));
            System.out.println("|a - b| = |b - a| ? - - -> " + A.perpendicular("vector", B));
            System.out.println("a * b = 0 entonces son perpendiculares: a * b = " + A.perpendicular(B));
            System.out.println("|a + b|^2 = |a|^2 + |b|^2 ? - - -> " + A.perpendicular(B, "vector"));
            System.out.println("Existe un r tal que a = rb sea cierto ?: " + A.paralela(B));
            System.out.println("|a x b = 0| ? - - -> " + A.paralela(B, false));
            System.out.println("La proyeccion de A sobre B es: " + A.Proyeccion_de_a_sobre_b(B).toString());
            System.out.println("La componente de A sobre B es: " + A.Componente_de_a_en_b(B));
        }else{
            System.out.println("Las dimensiones no son iguales");
        }
    }
}
