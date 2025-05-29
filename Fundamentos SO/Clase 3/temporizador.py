import signal
import time
# Paso 1: Definir lo que pasará cuando se dispare la alarma
def temporizador_activado(signum, frame):
    print("\n🚨 ¡Se acabó el tiempo!")
# Paso 2: Registrar la función con la señal SIGALRM
signal.signal(signal.SIGALRM, temporizador_activado)
# Paso 3: Activar el temporizador para 5 segundos
signal.alarm(5)
# Paso 4: Simular trabajo del programa
print("⏳ Esperando durante 5 segundos...")
time.sleep(10)
print("✅ El programa continuó después del temporizador.")