edades = []
i = 0
rep = ""
print("Bienvenido al programa de edades")
while rep != "*":
    edades.append(int(input("Ingrese la edad: ")))
    rep = input("Si desea salir ingrese *: ")
print("Las edades ingresadas son: ", edades)
