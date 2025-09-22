# importar libreria random para generar numeros aleatorios
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

    # Aumentar el record en +1 cda vez que se gane una partida
    def actualizaRecord(self):
        self.__record = self.__record+1

    # Metodo para quitar vida en -1 cuando se pierda una partida
    def quitaVida(self):
        self.__numeroDeVidas = self.__numeroDeVidas - 1
        if(self.__numeroDeVidas>0):
            return True
        return False
    
    # metodo para mostrar los datos cambiantes del jugador
    def getRecord(self):
        return f"{self.__nombre} -> partidas ganadas: {self.__record} numero de vidas: {self.__numeroDeVidas}"

# Hereda los metodos y atributos de la clase Juego
class juegoAdivinaNumero(Juego):
    # constructor ptincipal
    # atributos principales numeroAadivinar
    # metodos heredados de la clase principal numeroDeVidas
    def __init__(self, numeroDeVidas, record, nombre):
        # Llamado al constructor de la clase padre atravez de super
        super().__init__(numeroDeVidas, record, nombre)
        self.__numeroAadivinar = 0
    
    # metodo que inicia una partida del juego
    def juega(self):
        # llamada al metodo reiniciarPartida() de la clase padre para borrar reiniciar record
        super().reiniciarPartida()

        # genera aleatorio
        self.setNumeroAadivinar()

        # inicia la partida
        while True:
            # se ingresa un numero por el usuario
            numeroIngresado = int(input("Adivina el numero: "))
            
            

            # Verificar que el numero ingresado sea el mismo que el numero a adivinar
            if(self.__numeroAadivinar == numeroIngresado):
                # Si se gana la partida y se actualiza el record del jugador en 1
                print("Acertaste!!!! :D")
                print("")
                super().actualizaRecord()
                break
            else:
                # Quitar una vida 
                if(super().quitaVida()):
                    # dar pistas de que numero elegir 'mayor o menor'
                    if(numeroIngresado>self.__numeroAadivinar):
                        print("elige un numero mas pequeño")
                    else:
                        print("elige un numero mas grande")
                    print("   - - - intenta denuevo - - -   ")
                    print("")
                else:
                    # si el numero de vida es 0 entonces el juego acaba
                    print("perdite :(")
                    print("")
                    break
    # metodo para generar numero aleatorio
    def setNumeroAadivinar(self):
        numeroAleatorio = random.randint(1,10)
        self.__numeroAadivinar = numeroAleatorio

# clase aplicacion que crea instancias para juegoAdivinaPartida
class Aplicacion:
    # declarar un metodo que static que pertenece a la clase
    @staticmethod
    def main():
        
        # crear una instancia del juego "juegoAdivinaNumero"
        jugador1 = juegoAdivinaNumero(5, 0, "jugador1") # numeroDeVidas, record, nombre, numeroAadivinar

        # Se inicia el metodo juega para jugador1
        jugador1.juega()
        
        # mostrar record del jugador
        print(jugador1.getRecord())

        # se reincia la partida para terminar el juego
        jugador1.reiniciarPartida()
        
# llamad al metodo main de la clase aplicacion        
Aplicacion.main()

