#-------------------------Arreglos-------------------------
arreglo = ['juan', 'pedro', 'maria', 'luis', 'ana']
print(arreglo)
print(arreglo[0]) #imprime el primer elemento del arreglo
print(arreglo[-1]) #imprime el último elemento del arreglo
arreglo[0] = 'jose' #cambia el primer elemento del arreglo
print(arreglo)
#-------------------------Recorrer un arreglo-------------------------
edades = [20, 30, 40, 50, 60]
for i in edades:
    print(i)
print("")

#-------------------------Recorrer un arreglo con índices-------------------------
for i in range(len(edades)):
    print(edades[i])
print("")

#-------------------------while y indices en los arreglos-------------------------
i = 0
while i < len(edades):
    print(edades[i])
    i += 1