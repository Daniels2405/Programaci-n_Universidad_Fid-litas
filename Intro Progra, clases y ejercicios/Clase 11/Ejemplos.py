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
