# importar libreria random para generar numeros aleatorios
from random import randrange
import random

class Juego: # Clase juego
    # constructor principal
    def __init__(self, numeroDeVidas, record, nombre):
        # atributos numeroDeVidas y record de tipo entero
        self.__numeroDeVidas=numeroDeVidas
        self.__record = record
        self.__nombre = nombre
    # metodo para reiniciar toda la partida
    def reiniciarPartida(self):
        
        self.__record = 0

    # Aumentar el record en 1 cda vez que se gane una partida
    def actualizaRecord(self):
        self.__record = self.__record+1

    # Metodo para quitar vida cuando se pieraa una partida
    def quitaVida(self):
        self.__numeroDeVidas = self.__numeroDeVidas - 1
        if(self.__numeroDeVidas>0):
            return True
        return False
    # metodo para mostrar los datos cambiantes del objeto
    def getRecord(self):
        return f"{self.__nombre} -> partidas ganadas: {self.__record} numero de vidas: {self.__numeroDeVidas}"

# Hereda los metodos y atributos de la clase Juego
class juegoAdivinaNumero(Juego):
    # constructor ptincipal
    # atributos principales numeroAadivinar
    # metodos heredados de la clase principal numeroDeVidas
    def __init__(self, numeroDeVidas, record, nombre):
        # Llamado al constructor de la clase padre
        super().__init__(numeroDeVidas, record, nombre)
        self._numeroAadivinar = 0
    # metodo que valida que el numero ingresado por el usuario este entre 0 y 10
    def validaNumero(self, numero):
        if (numero>=0 and numero<=10):
            return True
        print("VALOR INESPERADO 'elegir numero entre 0 y 10'")
        return False
    # generar numero aleatorio
    def setNumeroAadivinar(self):
        numeroAleatorio = random.randint(1,10)
        self._numeroAadivinar = numeroAleatorio
    
    # todo metodo debe ser llamado con la palabra super() para ser usado
    # metodo que inicia una partida del juego
    def juega(self):
        # llamada al metodo reiniciarPartida() de la clase padre 
        super().reiniciarPartida()
        
        # generar numeroAleatorio
        self.setNumeroAadivinar()
        
        # inicia la partida
        while True:
            # se ingresa un numero por el usuario
            numeroIngresado = int(input("Adivina el numero: "))

            # se valida que el numero este entre 0 y 10
            if(self.validaNumero(numeroIngresado)):
                # Verificar que el numero ingresado sea el mismo que el numero a adivinar
                if(self._numeroAadivinar == numeroIngresado):
                    # Si se gana la partida y se actualiza el record del jugador en 1
                    print("Acertaste!!!! :D")
                    print("")
                    # actualizar el record en +1
                    super().actualizaRecord()
                    # salir del bucle y salir del metodo
                    break
                else:
                    # Quitar una vida 
                    if(super().quitaVida()):
                        # dar pistas de que numero elegir 'mayor o menor'
                        if(numeroIngresado>self._numeroAadivinar):
                            print("elige un numero mas pequeño")
                        else:
                            print("elige un numero mas grande")
                        print("   - - - intenta denuevo - - -   ")
                        print("")
                    else:
                        # si el numero de vida es 0 entonces el juego acaba
                        print("perdite :(")
                        print("")
                        # salir del bucle y salir del metodo
                        break



# clase JuegoAdivinapar
# hereda todos los metodos y atributos de la clase juegoAdivinaNumero
# Para usar cualquier metodo de la clas padre o superclase debe ser referenciado atravez
# de la palabra super
class JuegoAdivinaPar(juegoAdivinaNumero):
    # constructor principal
    # atributos heredados numeroDeVidas: int, numeroAadivinar: int, nombre: int
    # no existe ningun atributo propio que lo diferencie por ahora
    def __init__(self, numeroDeVidas, record, nombre):
        # llamada del constructor principal
        super().__init__(numeroDeVidas, record, nombre)
    # valida que el numero ingresado por el usuario sea par
    def validaNumero(self, valor):
        if(valor%2==0 and (valor>=0 and valor<=10)):
            return True
        print("Error valor inesperado IMPAR")
        return False
    # generar numero aleatorio par
    def setNumeroAadivinar(self):
        numeroAleatorioPar = random.randrange(0, 10, 2)
        
        self._numeroAadivinar = numeroAleatorioPar
# clase JuegoAdivinaImpar
# hereda todos los metodos y atributos de la clase juegoAdivinaNumero
# Para usar cualquier metodo de la clas padre o superclase debe ser referenciado atravez
# de la palabra super

class JuegoAdivinaImpar(juegoAdivinaNumero):
    # constructor principl
    def __init__(self, numeroDeVidas, record, nombre):
        super().__init__(numeroDeVidas, record, nombre)
    # valida que el numero sea impar
    def validaNumero(self, valor):
        if(valor%2!=0 and (valor>=0 and valor<=10)):
            return True
        print("Error valor inesperado PAR")
        return False
    # generar numero aleatorio impar
    def setNumeroAadivinar(self):
        numeroAleatorio = random.randrange(1, 10, 2)
        self._numeroAadivinar = numeroAleatorio

# clase aplicacion
class Aplicacion():
    @staticmethod
    # metodo main para crear las 3 instacnias para
    # juegoAdivinaNumero, JuegoAdivinaPar, JuegoAdivinaImpar
    def main():

        print("* * * * * * * * * * * * *")
        print("* JUEGO ADIVINAR NUMERO *")
        print("* * * * * * * * * * * * *")

        # crear instancia de la clase juegoAdivinaNumero
        juego1 = juegoAdivinaNumero(3, 0, "jugador1")

        juego1.juega() #jugar

        # ver los datos del jugador que jugo la partida
        print(juego1.getRecord())
        
        print("* * * * * * * * * * * * * * *")
        print("* JUEGO ADIVINAR NUMERO PAR *")
        print("* * * * * * * * * * * * * * *")

        # crear instancia de la clase JuegoAdivinaPar
        juego2 = JuegoAdivinaPar(3, 0, "jugador2")

        juego2.juega() # juega

        # ver los datos del jugador que jugo la partida
        print(juego2.getRecord())

        print("* * * * * * * * * * * * * * * *")
        print("* JUEGO ADIVINAR NUMERO IMPAR *")
        print("* * * * * * * * * * * * * * * *")

        # crear instancia de la clase JuegoAdivinaImpar
        juego3 = JuegoAdivinaImpar(3, 0,"jugador3")

        juego3.juega() # juega

        # ver los datos del jugador que jugo la partida
        print(juego3.getRecord())

Aplicacion.main()