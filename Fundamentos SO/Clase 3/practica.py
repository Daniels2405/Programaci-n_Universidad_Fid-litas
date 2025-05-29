from threading import Thread
import time
'''
def tarea():
    print("Hilo ejecutándose")
h1 = Thread(target=tarea)
h2 = Thread(target=tarea)
h1.start()
h2.start()
'''
def tarea(nombre):
    print(f"{nombre} iniciando...")
    time.sleep(2)
    print(f"{nombre} finalizado.")
h1 = Thread(target=tarea, args=("Hilo A",))
h2 = Thread(target=tarea, args=("Hilo B",))
h1.start()
h2.start()