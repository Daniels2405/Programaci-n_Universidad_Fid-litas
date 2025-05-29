from threading import Thread
import time
x = 0 # Memoria compartida
def sumar(valor):
    global x
    actual = x
    time.sleep(1) # Simula tiempo de procesamiento
    x = actual + valor
    print(f"Nuevo valor de x: {x}")
Thread(target=sumar, args=(1,)).start()
Thread(target=sumar, args=(2,)).start()
Thread(target=sumar, args=(3,)).start()