import signal
import time
def alarma(signum, frame):
    print("Tiempo terminado!")
signal.signal(signal.SIGALRM, alarma)
signal.alarm(3)
time.sleep(5)