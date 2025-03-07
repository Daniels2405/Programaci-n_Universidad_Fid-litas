#--------------------------Variables---------------------------------------------
#Loggin
user_admin = "admin"
pass_admin = "admin"
user_personal = "personal"
pass_personal = "personal"
user = ""
password = ""
intentos = 1
#----Menu----
menu = 0
repetir_menu = 1
#Productos
computadora = 0
monitor = 0
celular = 0
alexa = 0
camara = 0
#precios
computadora_precio = 300000
monitor_precio = 150000
celular_precio = 200000
alexa_precio = 230000
camara_precio = 70000
#-------------------------Librerias----------------------------------------------
import sys


#-----------------------Programa--------------------------------------------------
print("Bienvenido al sistema de facturacion de Austin's Electronics")
user = input("Ingrese nombre de Usuario: ")
password = input("Ingrese contraseña: ")

#----------Inicio de sesion en caso de que coloque el usuario y contraseña incorrectos----------------
while user != (user_admin or user_personal) or password != (pass_admin or pass_personal):
        print("Usuario o contraseña incorrectos")
        intentos += 1
        print("Le quedan ", 4 - intentos, " intentos")
        user = input("Ingrese nombre de Usuario: ")
        password = input("Ingrese contraseña: ")
        if intentos == 3:
                print("Ha superado el numero de intentos permitidos")
                sys.exit()

#-------------------------Inicio de programa-----------------------------------------

print("Bienvenido al sistema de facturacion de Austin's Electronics")
print("Primero iniciaremos con el registro")
print("Por favor ingrese los siguientes datos")
nombre_cliente = input("Nombre: ")
apellido_cliente = input("Apellido: ")
cedula_cliente = input("Cedula: ")
telefono_cliente = input("Telefono: ")
correo_cliente = input("Correo: ")
direccion_cliente = input("Direccion: ")

#-------------------------Menu-------------------------------------
print("Se encuentra en el menu de Austin's Electronics")
print("Paquetes de productos dijite 1")
print("Productos dijite 2")
print("Historial dijite 3")
print("Facturacion dijite 4")
menu = int(input("Dijite el modulo al que desea ingresar: "))

#----------------------Seleccion al modulo a ingresar-----------------------------------

if menu == 1:
        print("Paquetes de productos")
elif menu == 2:
        print("Productos")
elif menu == 3:
        print("Historial")
elif menu == 4:
        print("Facturacion")
else:
        print("Opcion no valida")