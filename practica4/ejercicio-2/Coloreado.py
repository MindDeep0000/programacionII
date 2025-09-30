# Las líneas `from abc import ABC, abstractmethod`, `import math` y `import random` son módulos de importación en Python.
from abc import ABC, abstractmethod
import math
import random


# La clase `Coloreado` es una clase base abstracta con un método abstracto `comoColorear`.
# En python no existe la interfaz, pero ABC crea una clase abstracta
# que es lo mas parecido a una interfaz en python
class Coloreado(ABC):
    @abstractmethod
    def comoColorear(self):
        pass


# Esta clase de Python define un objeto `Figura` que se puede colorear e incluye métodos abstractos para calcular el área y el perímetro.
class Figura(ABC):
    def __init__(self, color):
        self.__color = color
    # nuevo color
    def setColor(self, nuevo):
        self.__color = nuevo
    # obtener el color correspondiente
    def getColor(self):
        return self.__color
    # obtener los datos del color de la figura.
    def __str__(self):
        return f"color: {self.__color}\narea: {round(self.getArea(), 2)}\nperimetro: {round(self.getPerimetro(), 2)}"
    
    @abstractmethod
    def getArea(self):
        """
        La función anterior define un método abstracto `getArea` que debe ser implementado por las subclases.
        """
        pass

    @abstractmethod
    def getPerimetro(self):
        """
        La función anterior es un método abstracto en Python que define una firma de método para calcular el perímetro de una figura.
        """
        pass


# La clase `Cuadrado` representa una forma cuadrada con métodos para calcular su área y perímetro, así como un método para describir cómo colorear sus lados.
class Cuadrado(Figura, Coloreado):
    # contrcutor principal
    def __init__(self, color, lado):
        super().__init__(color)
        self.__lado = lado

    # calculo del area del cuadrado
    def getArea(self):
        return (self.__lado) ** 2

    # calculo del area del cuadrado
    def getPerimetro(self):
        return 4 * (self.__lado)

    # sobreescribe el metodo heredado de la clase padre 'Figura'
    def comoColorear(self):
        return f"Colorear los cuatro lados de color: {super().getColor()}"



# La clase `Circulo` representa un círculo con métodos para calcular su área, perímetro.
class Circulo(Figura):
    # constructor principal
    def __init__(self, color, radio):
        super().__init__(color)
        self.__radio = radio

    # calcular area
    def getArea(self):
        return math.pi * (self.__radio) ** 2

    # calcular periimetro
    def getPerimetro(self):
        return 2 * (math.pi) * (self.__radio)

# Esta clase Python llamada Test contiene un método estático llamado main.
class Test:
    @staticmethod
    def main():
        Figuras = []
        for i in range(5):

            # El fragmento de código `randomico = random.randint(1,2)` genera un entero aleatorio entre 1 y 2 inclusive.
            randomico = random.randint(1, 2)
            if randomico == 1:
                l_lado = random.randint(1, 10)
                Figuras.append(Cuadrado("Rojo", l_lado))
            else:
                l_radio = random.randint(1, 10)
                Figuras.append(Circulo("Verde", l_radio))
        # itera sobre cada objeto de la lista `Figuras` y realiza las siguientes acciones para
        # cada objeto:
        for fig in Figuras:
            if isinstance(fig, Cuadrado):
                print("cuadrado: ")
                print(fig.comoColorear())
                print(fig.__str__())
            else:
                print("circulo: ")
                print(fig.__str__())

# llamada al metodo 'main'
Test.main()
