package teoria1;

/**
 * Clase AlgebraVectorial
 *
 * @author Joel Barrera Quispe
 * version 1.0 15 de agosto de 2025
 */
public class AlgebraVectorial {

    /**
     * Atributos de un vector: publicos Estos son numeros los cuales pueden ser
     * modificados para hacer operaciones diferentes.
     */
    public int x; //nro de elementos
    public double[] vector; //vector de numeros reales
    private String nombre;
    /**
     * Constructor principal
     */
    public AlgebraVectorial(int x, double[] vector) {
        this.x = x;
        this.vector = vector;
    }
    /**
     * Constructor que añade parametro nombre
     */
    
    public AlgebraVectorial(int x, double[] vector, String nombre){
        this.x = x;
        this.vector = vector;
        this.nombre = nombre;
    }

    /**
     * Metodo que verifica la igualdad de dimensiones de dos vectores
     */
    public boolean Dim(AlgebraVectorial B) {
        if (this.x == B.x) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para calcular la norma de un vector N
     */
    public double norma() {
        double suma = 0;
        for (int i = 0; i < this.vector.length; i++) {
            suma += Math.pow(this.vector[i], 2);
        }
        return Math.sqrt(suma);
    }

    /**
     * Metodo para calcular la norma de un vector N elevado a una potencia !!!
     * Este metodo solo sirve por ahora para potencia 2
     */
    public double norma(int potencia) {
        double suma = 0;
        for (int i = 0; i < this.vector.length; i++) {
            suma += Math.pow(this.vector[i], 2);
        }
        return suma;
    }

    /**
     * Suma de vectores. Devuelve otro vector, que es la resultante de ambos. Su
     * valor esta dado por: a + b = (a1 + b1, a2 + b2, a3 + b3)
     */
    public AlgebraVectorial sumaVectorial(AlgebraVectorial O) {
        double[] V = new double[O.vector.length];
        AlgebraVectorial S = new AlgebraVectorial(O.x, V);
        for (int i = 0; i < O.vector.length; i++) {
            S.vector[i] = this.vector[i] + O.vector[i];
        }
        return S;
    }

    /**
     * Resta de vectores. Devuelve otro vector, correspondiente a la resta de
     * ambos, cuya formula esta dada por. a - b = (a1 - b1, a2 - b2, a3 - b3)
     */
    public AlgebraVectorial restaVectorial(AlgebraVectorial O) {
        double[] V = new double[O.vector.length];
        AlgebraVectorial S = new AlgebraVectorial(O.x, V);
        for (int i = 0; i < O.vector.length; i++) {
            S.vector[i] = this.vector[i] - O.vector[i];
        }
        return S;
    }

    /**
     * Multiplicacion de vectores, cuya formula esta dada por: a · b = a1b1 +
     * a2b2 + a3b3 El valor devuelto es un real.
     */
    public int mutiplicVectorial(AlgebraVectorial O) {
        int suma = 0;
        for (int i = 0; i < O.vector.length; i++) {
            suma += this.vector[i] * O.vector[i];
        }
        return suma;
    }

    /**
     * multiploDe: Verificar si el vector es multiplo del otro, esto se logra si
     * el valor r es un factor comun de a. Lo que indica que el vector B es
     * multiplo de A lo que como resultado indica que A es paralelo a B.
     */
    public boolean multiploDe(AlgebraVectorial O) {
        double r = this.vector[0] / O.vector[0];
        for (int i = 1; i < O.vector.length; i++) {
            if (O.vector[i] != 0) {
                if ((this.vector[i] / O.vector[i]) != r) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * multipliEscalarPor: Metodo que realiza la multiplicacion de un numero
     * real con cada uno de las componentes de B. Su forma esta dada por: ra =
     * (r ∗ a1, r ∗ a2, r ∗ a3)
     */
    public void multipliEscalarPor(double r) {
        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] = r * vector[i];
        }
    }

    /**
     * |a + b| = |a − b| Verifica si el vector A es perpendicular a B Devuelve
     * un valor booleano segun sea el caso verdadero o falso de la igualdad
     * anterior. (tipo) es una parametro que sirve para diferenciar al metodo.
     *
     */
    public boolean perpendicular(boolean tipo, AlgebraVectorial B) {
        if (!tipo) {
            double suma = this.sumaVectorial(B).norma();
            double resta = this.restaVectorial(B).norma();
            return (suma == resta) ? true : false;
        }
        return tipo;
    }

    /**
     * |a − b| = |b − a| Verificar si el vector A es perpendicular a B Devuelve
     * un mensaje 'perpendicular' o 'no perpendicular', segun se da igualdad
     * anterior. tipo: String, la variable se ha aumentado para diferenciar un
     * metodo de otro, asi la sobrecarga sera valida.
     */
    public String perpendicular(AlgebraVectorial B, String tipo) {
        if (tipo.equalsIgnoreCase("vector")) {
            double resta1 = this.restaVectorial(B).norma();
            double resta2 = B.restaVectorial(this).norma();

            return (resta1 == resta2) ? "Son perpendiculares o ortogonales" : "No son perpendiculares o ortogonales";
        }
        return null;
    }

    /**
     * a · b = 0
     * Verificar si el vector A es vector a B. Devuelve el valor de la operacion
     * anterior. Sera 0 si son perpendiculares y !=0 si no lo son.
     */
    public double perpendicular(AlgebraVectorial B) {
        return this.mutiplicVectorial(B);
    }

    /**
     * : |a + b|^2 = |a|^2 + |b|^2 Verificar la igualdad anterior. Para
     * verificar si A es perpendicular a B. x: int, es una variable para
     * diferenciar al metodo de los demas, aunque su valor puede ser cualquiera,
     * pero no tiene un uso.
     */
    public boolean perpendicular(String tipo, AlgebraVectorial B) {
        if (tipo.equalsIgnoreCase("vector")) {
            double sumVec = this.sumaVectorial(B).norma(2);
            double sumaReal = this.norma(2) + B.norma(2);

            return (sumVec == sumaReal) ? true : false;
        }
        return false;
    }

    /**
     * paralela: Verifica si el vector A es paralelo a B multiploDe: Devuelve
     * verdadero si es que existe un r tal que cumpla: a = rb Y falso si no
     * existe ningun r.
     */
    public boolean paralela(AlgebraVectorial B) {

        if (this.multiploDe(B)) {
            return true;
        }
        return false;
    }

    /**
     * paralela: Verifica si se cumple la igualdad: |a × b = 0| producto
     * vectorial En este caso use una forma un poco menos dificil de
     * decodificar, pero la igualdad se cumple igualmente. La forma que use fue:
     * sqrt ( |A|^2 * |B|^2 - (A*B)^2 ) f: int, es como un valor fantasma para
     * diferenciar los metodos de otros. Solo sirve para hacer cumplir la
     * sobrecarga.
     */
    public String paralela(AlgebraVectorial B, boolean tipo) {
        if (!tipo) {
            double nA = this.norma(2);
            double nB = B.norma(2);
            double nAB = Math.pow((this.mutiplicVectorial(B)), 2);

            double igualdad = Math.sqrt((nA * nB) - nAB);

            if (igualdad == 0) {
                return "Los vectores son paralelos";
            }
            return "Los vectores no son paralelos";
        }
        return null;
    }

    /**
     * Proyeccion_de_a_sobre_b: Devuelve el vector que proyecta su sombra sobre
     * el vector B, tiene caracteristicas como las componentes del vector.
     */

    public AlgebraVectorial Proyeccion_de_a_sobre_b(AlgebraVectorial B) {
        double cociente = (this.mutiplicVectorial(B)) / B.norma(2);

        this.multipliEscalarPor(cociente);

        return B;
    }

    /**
     * Componente_de_a_en_b: Devuelve un valor para que indica el modulo y la
     * direccion del vector hallado anteriormente
     */
    public double Componente_de_a_en_b(AlgebraVectorial B) {
        if(B.norma()!=0){
            double modulo = this.mutiplicVectorial(B) / B.norma();
            return modulo;
        }
        return -1;
    }
    /**
     * Mostrar los atributos de un objeto anteriormente añadidos.
     */
    
    public String toString(){
        String muestra = "[ ";
        for (int i = 0; i < this.x; i++) {
            muestra+=Double.toString(this.vector[i]);
            muestra+=" ";
        }
        return this.nombre + "="+ muestra+"]";
    }

}
