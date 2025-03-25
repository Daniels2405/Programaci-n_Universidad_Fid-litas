'''#-------------Don carlos-------------
tienda_carlos = [["día 1", "día 2", "día 3"], [0, 0, 0], [0, 0, 0], [0, 0, 0]]
print("Bienvenido al programa de ventas de Don Carlos")
i = 0
j = 0
for i in range (3):
    print("Ingrese las ventas del día", i+1)
    for j in range (3):
        print("Ingrese las ventas de la tienda", j+1, "del día ", i+1)
        tienda_carlos[j+1][i] = int(input("Ventas: "))

print("Las ventas de Don Carlos son: ", tienda_carlos)
'''

'''#-------------Notas de estudiantes-------------
estudiantes = [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
print("Bienvenido al programa de notas de estudiantes")
i = 0
j = 0
for i in range (5):
    print("Ingrese las notas del estudiante numero", i + 1)
    for j in range (4):
        print("Ingrese la nota de la actividad", j + 1)
        estudiantes[i][j] = int(input("Nota: "))
print("Las notas de los estudiantes son: ", estudiantes)
'''
#------------microbus----------------
Asientos = [[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0], [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0], [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0], [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]]
print("Bienvenido al programa de reservas de microbus")
i = 0
j = 0
rep = 0
while rep == 0:
    print ("Ingrese el horario en cual desea reservar")
    print ("1. 6:00 am")
    print ("2. 8:00 am")
    print ("3. 10:00 am")
    print ("4. 12:00 pm")
    horario = int(input("Horario: "))
    if horario == 1:
        print("Ingrese el asiento que desea reservar de 20 disponibles")
        Asiento = int(input("Asiento: "))
        Asientos[0][Asiento - 1] = 1
    elif horario == 2:
        print("Ingrese el asiento que desea reservar de 20 disponibles")
        Asiento = int(input("Asiento: "))
        Asientos[1][Asiento - 1] = 1
    elif horario == 3:
        print("Ingrese el asiento que desea reservar de 20 disponibles")
        Asiento = int(input("Asiento: "))
        Asientos[2][Asiento - 1] = 1
    elif horario == 4:
        print("Ingrese el asiento que desea reservar de 20 disponibles")
        Asiento = int(input("Asiento: "))
        Asientos[3][Asiento -1] = 1
    print("Desea hacer otra reserva?")
    print("1. Si")
    print("2. No")
    rep = int(input("Respuesta: "))
print("Las reservas son: ", Asientos)
