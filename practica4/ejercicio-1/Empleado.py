# importar la libreria para la creacion de clases y metodos abstractos
from abc import ABC, abstractmethod


# Clase abstracta
# Esta clase de Python define una clase base abstracta para un empleado con un atributo de nombre y un método abstracto para calcular el salario mensual.



class Empleado(ABC):
    """
        # La clase `Empleado` se define con un método abstracto `__init__` que inicializa un objeto empleado con un atributo de nombre.
    """
    def __init__(self, nombre):
        self._nombre = nombre

    @abstractmethod
        
    def calcularSalarioMensual(self):
        """
            Esta función es un método abstracto en Python que calcula el salario mensual.
        """
        pass

    def __str__(self):
        return f"nombre: {self._nombre} salario: {self.calcularSalarioMensual()}"


# Extiende la clase empleado
# La clase `EmpleadoTiempoCompleto` representa a un empleado a tiempo completo con un método para calcular el salario mensual.
class EmpleadoTiempoCompleto(Empleado):
    # constrcutor principal
    def __init__(self, nombre, salarioAnual):
        super().__init__(nombre)
        self.__salarioAnual = salarioAnual

    def calcularSalarioMensual(self):
        return self.__salarioAnual / 12

    # def __str__(self):
    #     """
    #     La función devuelve una cadena que representa un objeto con su nombre y salario mensual.
    #     """
    #     return f"nombre: {self._nombre} salario: {self.calcularSalarioMensual()}"


class EmpleadoTiempoHorario(Empleado):
    def __init__(self, nombre, horas_trabajadas, tarifa_hora):
        """
            La función inicializa un objeto con atributos para el nombre, las horas trabajadas y la tarifa por hora.
        """
        super().__init__(nombre)
        self.__horas_trabajadas = horas_trabajadas
        self.__tarifa_hora = tarifa_hora

    def calcularSalarioMensual(self):
        """
        La función calcula el salario mensual basándose en las horas trabajadas y la tarifa por hora.
        """
        return self.__horas_trabajadas * self.__tarifa_hora

    # def __str__(self):
    #     """
    #     La función devuelve una cadena que representa un objeto con su nombre y salario mensual.
    #     """
    #     return f"nombre: {self._nombre} salario: {self.calcularSalarioMensual()}"


class App:
    @staticmethod
    def main():
        # arreglo de tipo empleados
        empleados = []

        # Esta parte del código es un bucle que se itera tres veces para recopilar datos de entrada de los empleados que trabajan a tiempo completo.
        for i in range(3):

            while True:
                nombre, s_anual = input(
                    f"Ingrese los datos del empleado a tiempo completo - {i+1}: "
                ).split(" ")
                d_anual = float(s_anual)
                if d_anual > 0 and nombre != "":
                    empleados.append(EmpleadoTiempoCompleto(nombre, d_anual))
                    break

        # Esta parte del código es un bucle que se itera dos veces para recopilar datos de entrada de los empleados que trabajan a tiempo parcial.
        for i in range(2):
            while True:
                nombre, t_hora, h_trabajo = input(
                    f"Ingrese los datos del empleado a tiempo horario - {i+1}: "
                ).split(" ")
                d_t_hora = float(t_hora)
                d_h_trabajo = float(h_trabajo)
                if d_t_hora > 0 and d_h_trabajo > 0 and nombre != "":
                    empleados.append(
                        EmpleadoTiempoHorario(nombre, d_t_hora, d_h_trabajo)
                    )
                    break

        # iteracion sobre el arreeglo para mostrar informacion de cada empleado.
        for i in range(len(empleados)):
            print(empleados[i].__str__())

# llamada al metodo principal de la clase APP
App.main()


"""
    Viernes examen a las 
"""