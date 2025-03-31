#--------------------------Proyecto Introduccion a la programación-----------------------------------------
#--------------------------Variables---------------------------------------------
#Loggin
user_admin = 0
pass_admin = 0
user_personal = 1
pass_personal = 1
user = ""
password = ""
intentos = 1
users = [["admin", "personal"], ["admin", "personal"]] #Lista de usuarios y contraseñas
#Datos del cliente
cliente = ["", "", "", "", "", ""]
#----Menu----
menu = 0
repetir_menu = 1
paquete = 0
repetir_paquete = 1
producto = 0
repetir_producto = 1
#Productos
computadora = 0
monitor = 1
celular = 2
alexa = 3
camara = 4
productos = [[300000, 0], [150000, 0], [200000, 0], [230000, 0], [70000, 0]] #Representan el precio y la cantidad de cada producto
#precios
computadora_precio = 300000
monitor_precio = 150000
celular_precio = 200000
alexa_precio = 230000
camara_precio = 70000
#Facturacion
ahorro = 0
subtotal = 0
iva = 0
total = 0
#-------------------------Librerias----------------------------------------------
import sys


#-----------------------Programa--------------------------------------------------
print("----------Bienvenido al sistema de facturacion de Austin's Electronics----------")
user = input("Ingrese nombre de Usuario: ")
password = input("Ingrese contraseña: ")

#----------Inicio de sesion en caso de que coloque el usuario y contraseña incorrectos----------------
while user != (users[0][0] or users[0][1]) or password != (user[1][0] or users[1][1]):
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
cliente[0] = input("Nombre: ")
cliente[1] = input("Apellido: ")
cliente[2] = input("Cedula: ")
cliente[3] = input("Telefono: ")
cliente[4] = input("Correo: ")
cliente[5] = input("Direccion: ")
print("")
print("Se registro: ", cliente)
print("")
print("-----Datos registrados correctamente-----")
print("")

#-------------------------Menu-------------------------------------
while repetir_menu == 1:
        print("-----Se encuentra en el menu de Austin's Electronics-----")
        print("--Paquetes de productos dijite | 1 |--")
        print("--Productos dijite | 2 |--")
        print("--Historial dijite | 3 |--")
        print("--Facturacion dijite | 4 |--")
        menu = int(input("Dijite el modulo al que desea ingresar: "))
        print("")   
        #----------------------Seleccion al modulo a ingresar-----------------------------------   
        # Paquetes     
        if menu == 1:
                while repetir_paquete == 1:
                        print("Paquetes")
                        print("---Selecione el paquete que desea dijitando el numero---")
                        print("Paquete | 1 |: 1 Computadora, 1 Monitor, 1 Alexa | $578000 ya aplicado un descuento del 15%")
                        print("Paquete | 2 |: 1 camara, 1 celular | $229500 ya aplicando el descuento del 15%")
                        print("Paquete | 3 |: 1 computadora, 1 monitor | 382500 aplicando el descuento del 15%")
                        print("Paquete | 4 |: 1 celular, 1 alexa | 365500 aplicando el descuento del 15%")
                        paquete = int(input("Dijite el paquete: "))
                        if paquete == 1:
                                computadora += 1
                                monitor += 1
                                alexa += 1
                                print("Paquete 1 agregado correctamente")
                                ahorro = (computadora_precio + monitor_precio + alexa_precio) * 0.15
                        elif paquete == 2:
                                camara += 1
                                celular += 1
                                print("Paquete 2 agregado correctamente")
                                ahorro = (camara_precio + celular_precio) * 0.15
                        elif paquete == 3:
                                computadora += 1
                                monitor += 1
                                print("Paquete 3 agregado correctamente")
                                ahorro = (computadora_precio + monitor_precio) * 0.15
                        elif paquete == 4:
                                celular += 1
                                alexa += 1
                                print("Paquete 4 agregado correctamente")
                                ahorro = (celular_precio + alexa_precio) * 0.15
                        else:
                                print("Opcion no valida")
                        repetir_paquete = int(input("Si desea agregar otro paquete dijite | 1 |, si desea salir al menu elija | 2 |: "))
        #Productos
        elif menu == 2:
                while repetir_producto == 1:
                        print("Productos")
                        print("---Selecione el producto que desea dijitando el numero---")
                        print("--| 1 | Computadora: $300000--")
                        print("--| 2 | Monitor: $150000--")
                        print("--| 3 | Celular: $200000--")
                        print("--| 4 | Alexa: $230000--")
                        print("--| 5 | Camara: $70000--")
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
                        repetir_producto = int(input("Si desea agregar otro producto dijite | 1 |, si desea salir al menu elija | 2 |: "))
        #Historial
        elif menu == 3:
                print("Historial")
                print("El cliente: ", nombre_cliente, apellido_cliente, " Tiene los siguientes productos:")
                print("Computadoras: ", computadora)
                print("Monitores: ", monitor)
                print("Celulares: ", celular)
                print("Alexas: ", alexa)
                print("Camaras: ", camara)
                print("Con un subTotal de $", computadora * computadora_precio + monitor * monitor_precio + celular * celular_precio + 
                      alexa * alexa_precio + camara * camara_precio)
        #Facturacion
        elif menu == 4:
                computadora_precio *= computadora
                monitor_precio *= monitor
                celular_precio *= celular
                alexa_precio *= alexa
                camara_precio *= camara
                print("Facturacion")
                print("Nombre: ----", nombre_cliente, "----")
                print("Apellido: ----", apellido_cliente, "----")
                print("Cedula: ----", cedula_cliente, "----")
                print("Telefono: ----", telefono_cliente, "----")
                print("Correo: ----", correo_cliente, "----")
                print("Direccion: ----", direccion_cliente, "----")
                print("| Computadoras: ", computadora, " | Precio: $", computadora_precio, " |")
                print("| Monitores: ", monitor, " | Precio: $", monitor_precio, " |")
                print("| Celulares: ", celular, " | Precio: $", celular_precio, " |")
                print("| Alexas: ", alexa, " | Precio: $", alexa_precio, " |")
                print("| Camaras: ", camara, " | Precio: $", camara_precio, " |")
                subtotal = computadora_precio + monitor_precio + celular_precio + alexa_precio + camara_precio
                print("Subtotal: $", subtotal)
                print("Ahorro en paquetes: $", ahorro)
                iva = subtotal * 0.13
                print("IVA: $", iva)
                total = subtotal + iva - ahorro
                print("Total: $", total)
                print("Al total a pagar se aplicara un descuento del 25%")
                total = total * 0.75
                print("Total a pagar con descuento: $", total)
                print("")
                print("Gracias por su compra")
                sys.exit()
        else:
                print("Opcion no valida")
        print("")
        repetir_menu = int(input("Si desea volver al menu principal dijite | 1 |, si desea cerrar el programa | 2 |: "))
        print("")

print("")
print("Gracias por visitarnos")