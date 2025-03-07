#Variables
userAdmin = "admin"
passAdmin = "admin"
user_personal = "personal"
pass_personal = "personal"
user = ""
password = ""
intentos = 1
#Librerias
import sys
#Programa
print("Bienvenido al sistema de facturacion de Austin's Electronics")
user = input("Ingrese nombre de Usuario: ")
password = input("Ingrese contraseña: ")

while user != (userAdmin or user_personal) or password != (passAdmin or pass_personal):
        print("Usuario o contraseña incorrectos")
        intentos += 1
        print("Le quedan ", 4 - intentos, " intentos")
        user = input("Ingrese nombre de Usuario: ")
        password = input("Ingrese contraseña: ")
        if intentos == 3:
                print("Ha superado el numero de intentos permitidos")
                sys.exit()
print("Bienvenido al sistema de facturacion de Austin's Electronics")