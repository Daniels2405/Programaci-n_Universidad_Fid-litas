# Tema: Programación en Python
#-------------------------Variables-------------------------
monto = 0
monto_total = 0
monto_mensual = 0
monto_promedio = 0
días = 1
días_total = 0
rep_datos = ""

#-------------------------Funciones-------------------------
def datos(monto, monto_total, días, días_total):
    print("Dia:", días)
    monto = int(input("Ingrese el monto gastado en transporte: "))
    monto_total += monto
    días_total += 1
    if días == 30:
        días = 1
    else:
        días += 1
    return monto_total, días, días_total
def calculo(monto_total, monto_mensual, monto_promedio, días, días_total):
    print(monto_total)
    print(días_total)
    print(días)
    monto_mensual = monto_total / días_total
    monto_promedio = monto_total / días
    print("El monto total gastado en transporte es de: ", monto_total)
    print("El monto mensual gastado en transporte es de: ", monto_mensual)
    print("El monto promedio gastado en transporte es de: ", monto_promedio)

#-------------------------Programa-------------------------
print ("Bienvenido al programa")
print("El programa calcula el monto mensual de gastos en transporte")
print("")
#Ingreso de datos
while rep_datos != "*":
    monto_total, días, días_total = datos(monto, monto_total, días, días_total)
    print("")
    rep_datos = input("Desea ingresar otro día?: s(dijite '+')/n(dijite '*'): ")
#Calculo de datos
monto_mensual = calculo(monto_total, monto_mensual, monto_promedio, días, días_total)
print("Gracias por usar el programa")