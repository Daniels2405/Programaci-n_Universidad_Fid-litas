#--------variables------------
#Arreglos
grupo1 =[["", 0], ["", 0],["", 0], ["", 0], ["", 0]]
grupo2 =[["", 0], ["", 0],["", 0], ["", 0], ["", 0]]
grupo3 =[["", 0], ["", 0],["", 0], ["", 0], ["", 0]]
grupo4 =[["", 0], ["", 0],["", 0], ["", 0], ["", 0]]
#Promedios
promedio_grupo1 = 0
promedio_grupo2 = 0
promedio_grupo3 = 0
promedio_grupo4 = 0
promedio_total = 0
#Aprovados
aprobados_grupo1 = 0
aprobados_grupo2 = 0
aprobados_grupo3 = 0
aprobados_grupo4 = 0
nota_mayor = 0
nota_menor = 100
#--------Programa------------
print("Bienvenido al programa de notas para alumnos de ingles")
print("A continucación agregue los nombres y notas de los alumnos")
#Notas y nombres de alumnos
print("------Grupo 1--------")
for i in range(5):
    print("------|Alumno #", i+1, "| grupo 1 |")
    grupo1[i][0] = input("Ingrese el nombre del alumno: | ")
    grupo1[i][1] = int(input("Ingrese la nota del alumno: | "))
    print("")

print("------Grupo 2--------")
for i in range(5):
    print("------|Alumno ", i+1, "| grupo 2 |")
    grupo2[i][0] = input("Ingrese el nombre del alumno: | ")
    grupo2[i][1] = int(input("Ingrese la nota del alumno: | "))
    print("")

print("------Grupo 3--------")
for i in range(5):
    print("------|Alumno ", i+1, "| grupo 3 |")
    grupo3[i][0] = input("Ingrese el nombre del alumno: | ")
    grupo3[i][1] = int(input("Ingrese la nota del alumno: | "))
    print("")

print("------Grupo 4--------")
for i in range(5):
    print("------|Alumno ", i+1, "| grupo 4 |")
    grupo4[i][0] = input("Ingrese el nombre del alumno: | ")
    grupo4[i][1] = int(input("Ingrese la nota del alumno: | "))
    print("")

#--------Calculo de promedios------------
#Promedio total
for i in range(5):
    promedio_total += grupo1[i][1]
    promedio_total += grupo2[i][1]
    promedio_total += grupo3[i][1]
    promedio_total += grupo4[i][1]
print("Promedio total: ", promedio_total / 20)
print("")

#Promedio de cada grupo
for i in range(5):
    promedio_grupo1 += grupo1[i][1]
    promedio_grupo2 += grupo2[i][1]
    promedio_grupo3 += grupo3[i][1]
    promedio_grupo4 += grupo4[i][1]
print("Promedio grupo 1: ", promedio_grupo1 / 5)
print("Promedio grupo 2: ", promedio_grupo2 / 5)
print("Promedio grupo 3: ", promedio_grupo3 / 5)
print("Promedio grupo 4: ", promedio_grupo4 / 5)
print("")

#--------Alumnos aprobados y nota mayor y menor------------
for i in range(5):
    #grupo1
    if grupo1[i][1] >= 80:
        aprobados_grupo1 += 1
    if grupo1[i][1] > nota_mayor:
        nota_mayor = grupo1[i][1]
    if grupo1[i][1] < nota_menor:
        nota_menor = grupo1[i][1]
    #grupo2
    if grupo2[i][1] >= 80:
        aprobados_grupo2 += 1
    if grupo2[i][1] > nota_mayor:
        nota_mayor = grupo2[i][1]
    if grupo2[i][1] < nota_menor:
        nota_menor = grupo2[i][1]
    #grupo3
    if grupo3[i][1] >= 80:
        aprobados_grupo3 += 1
    if grupo3[i][1] > nota_mayor:
        nota_mayor = grupo3[i][1]
    if grupo3[i][1] < nota_menor:
        nota_menor = grupo3[i][1]
    #grupo4
    if grupo4[i][1] >= 80:
        aprobados_grupo4 += 1
    if grupo4[i][1] > nota_mayor:
        nota_mayor = grupo4[i][1]
    if grupo4[i][1] < nota_menor:
        nota_menor = grupo4[i][1]
print("El porcentaje de alumnos aprovados en el grupo 1 es :", (aprobados_grupo1 / 5) * 100, "%")
print("El porcentaje de alumnos aprovados en el grupo 2 es :", (aprobados_grupo2 / 5) * 100, "%")
print("El porcentaje de alumnos aprovados en el grupo 3 es :", (aprobados_grupo3 / 5) * 100, "%")
print("El porcentaje de alumnos aprovados en el grupo 4 es :", (aprobados_grupo4 / 5) * 100, "%")
print("")
print("La nota mayor es: ", nota_mayor)
print("La nota menor es: ", nota_menor)
print("")