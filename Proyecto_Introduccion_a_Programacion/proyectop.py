#--------------------------Proyecto Introduccion a la programación-----------------------------------------
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
paquete = 0
repetir_paquete = 1
producto = 0
repetir_producto = 1
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
print("----------Bienvenido al sistema de facturacion de Austin's Electronics----------")
user = input("Ingrese nombre de Usuario: ")
password = input("Ingrese contraseña: ")

#----------Inicio de sesion en caso de que coloque el usuario y contraseña incorrectos----------------
while user != (user_admin or user_personal) or password != (pass_admin or pass_personal):
        print("|Usuario o contraseña incorrectos|")
        intentos += 1
        print("|Le quedan ", 4 - intentos, " intentos|")
        user = input("Ingrese nombre de Usuario: ")
        password = input("Ingrese contraseña: ")
        if intentos == 3:
                print("|¡Ha superado el numero de intentos permitidos!|")
                sys.exit()

#-------------------------Inicio de programa-----------------------------------------

print("-----Bienvenido al sistema de facturacion de Austin's Electronics-----")
print("--Primero iniciaremos con el registro--")
print("--Por favor ingrese los siguientes datos--")
nombre_cliente = input("Nombre: ")
apellido_cliente = input("Apellido: ")
cedula_cliente = input("Cedula: ")
telefono_cliente = input("Telefono: ")
correo_cliente = input("Correo: ")
direccion_cliente = input("Direccion: ")

#-------------------------Menu-------------------------------------
while repetir_menu == 1:
        print("-----Se encuentra en el menu de Austin's Electronics-----")
        print("--Paquetes de productos dijite 1--")
        print("--Productos dijite 2--")
        print("--Historial dijite 3--")
        print("--Facturacion dijite 4--")
        menu = int(input("Dijite el modulo al que desea ingresar: "))   
        #----------------------Seleccion al modulo a ingresar-----------------------------------   
        # Paquetes     
        if menu == 1:
                while repetir_paquete == 1:
                        print("Paquetes")
                        print("---Selecione el paquete que desea dijitando el numero---")
                        print("Paquete 1: 1 Computadora, 1 Monitor, 1 Alexa | $578000 ya aplicado un descuento del 15%")
                        print("Paquete 2: 1 camara, 1 celular | $229500 ya aplicando el descuento del 15%")
                        print("Paquete 3: 1 computadora, 1 monitor | 382500 aplicando el descuento del 15%")
                        print("Paquete 4: 1 celular, 1 alexa | 365500 aplicando el descuento del 15%")
                        paquete = int(input("Dijite el paquete: "))
                        if paquete == 1:
                                computadora += 1
                                monitor += 1
                                alexa += 1
                                print("Paquete 1 agregado correctamente")
                        elif paquete == 2:
                                camara += 1
                                celular += 1
                                print("Paquete 2 agregado correctamente")
                        elif paquete == 3:
                                computadora += 1
                                monitor += 1
                                print("Paquete 3 agregado correctamente")
                        elif paquete == 4:
                                celular += 1
                                alexa += 1
                                print("Paquete 4 agregado correctamente")
                        else:
                                print("Opcion no valida")
                        repetir_paquete = int(input("Si desea agregar otro paquete dijite 1, si desea salir al menu elija 2: "))
        #Productos
        elif menu == 2:
                while repetir_producto == 1:
                        print("Productos")
                        print("---Selecione el producto que desea dijitando el numero---")
                        print("--Computadora: $300000--")
                        print("--Monitor: $150000--")
                        print("--Celular: $200000--")
                        print("--Alexa: $230000--")
                        print("--Camara: $70000--")
                        producto = int(input("Dijite el producto: "))
                        if producto == 1:
                                computadora += 1
                                print("Computadora agregada")
                        elif producto == 2:
                                monitor += 1
                                print("Monitor agregado")
                        elif producto == 3:
                                celular += 1
                                print("Celular agregado")
                        elif producto == 4:
                                alexa += 1
                                print("Alexa agregado")
                        elif producto == 5:
                                camara += 1
                                print("Camara agregada")
                        else:
                                print("Opcion no valida")
                        repetir_producto = int(input("Si desea agregar otro producto dijite 1, si desea salir al menu elija 2: "))
        #Historial
        elif menu == 3:
                print("Historial")
        #Facturacion
        elif menu == 4:
                print("Facturacion")
                sys.exit()
        else:
                print("Opcion no valida")
        
        repetir_menu = int(input("Si desea agregar otro producto dijite 1, si desea ir a la facturación 2: "))

print("Fin")