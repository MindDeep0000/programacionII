"""
•   PYTHON
 * @author Joel Barrera Quispe
 * 8 de de septiembre de 2025
 * version 1.0
 * Clase Circulo2D 
"""
import math
class Circulo2D:
    # atributos centro(x,y) y radio  */
    def __init__(self, x=0, y=0, radio=1):
        self.centro_x = x
        self.centro_y = y
        self.radio = radio

    # @return the x
    def get_x(self):
        return self.centro_x

    # @return the y
    def get_y(self):
        return self.centro_y

    # @return the radio
    def get_radio(self):
        return self.radio

    #calcula el area del circulo
    def get_area(self):
        return math.pi * (self.get_radio() ** 2)

    #/** calcula el perimetro del circulo */
    def get_perimetro(self):
        return 2 * math.pi * self.radio

    #/** calcula si el punto dado esta dentro del conjunto de puntos de la circunferencia */
    def contiene(self, x, y):
        ecuacion = (x - self.get_x()) ** 2 + (y - self.get_y()) ** 2
        contiene = ecuacion < (self.radio ** 2)
        return contiene

    #/** calcula la diferencia entre centros de los circulos, los cuales no deben sobrepasar la diferencia entre los radios de los dos cirulos */
    def contiene_circulo(self, circulo):
        calculo = (self.get_x() - circulo.get_x()) ** 2 + (self.get_y() - circulo.get_y()) ** 2
        contener = calculo <= (self.get_radio() - circulo.get_radio())
        return contener

    #/** calcula la distancia entre puntos y devuelve true si es menor a la suma de los radios, lo contrario devuelve false */
    def sobrepone(self, circulo):
        contiene = ((self.get_x() - circulo.get_x()) ** 2 + (self.get_y() - circulo.get_y()) ** 2) ** 0.5
        sobrepone = contiene < (self.get_radio() + circulo.get_radio())
        return sobrepone

#/** instanciar el objeto c1, cuyos atributos principales son: centro(2,0) y radio = 1*/
c1 = Circulo2D(2, 0, 1)
#/** calcular el area del mismo circulo */
print("area:", c1.get_area())
#/** calcular el perimetro del circulo */
print("perimetro:", c1.get_perimetro())

#/** operacion contiene: verificar si P(2.5, 0) esta dentro del circulo instanciado */
print("contiene: P(2.5, 0)?", c1.contiene(2.5, 0))
#/** operacion contiene: verificar si el nuevo circulo con atributos: centro(2,0) y radio=0.5, esta dentro dentro del circulo c1*/
print("Contiene: Circulo2D(2, 0, 0.5)?", c1.contiene_circulo(Circulo2D(2, 0, 0.5)))
#/** operacion sobrepone: verificar si el nuevo circulo creado con atributos: c(0,0) y r=2, sobrepone al circulo c1 */
print("Sobrepone: Circulo2D(0, 0, 2)?", c1.sobrepone(Circulo2D(0, 0, 2)))