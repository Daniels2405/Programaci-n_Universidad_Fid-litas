#Variables
userAdmin = "admin"
passAdmin = "admin"
user_personal = "personal"
pass_personal = "personal"
import sys
#Programa
print("Bienvenido al sistema de facturacion de Austin's Electronics")
user = input("Ingrese nombre de Usuario: ")
password = input("Ingrese contraseña: ")

while user != (userAdmin or user_personal) or password != (passAdmin or pass_personal):
        print("Usuario o contraseña incorrectos")
        user = input("Ingrese nombre de Usuario: ")
        password = input("Ingrese contraseña: ")
        if user == "a":
                sys.exit()
