'''--------------------------Proyecto Introduccion a la programación-----------------------------------------
-------------------------- Inventario y Facturación de Tienda Electrónicos--------------------------

-------------------------- Desarrollado por:--------------------------------------------------------
-------------------------- 1. Andrés Avendaño Jiménez------------------------------------------------------
-------------------------- 2. Tania Araya Villalta----------------------------------------------------
-------------------------- 3. Daniel Barrientos Salas----------------------------------------------------
-------------------------- 4. Ángel Franco Hernández----------------------------------------------------

-------------------------- Datos de inicio de seccion------------------------------------------------
-------------------------- 1. Usuario: admin----------------------------------------------------
-------------------------- 2. Contraseña: admin----------------------------------------------------
-------------------------- 3. Usuario: personal----------------------------------------------------
-------------------------- 4. Contraseña: personal----------------------------------------------------
'''
#--------------------------Variables---------------------------------------------
#Loggin
user = ""
password = ""
intentos = 0
users = [["admin", "admin"], ["personal", "personal"]]
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
productos = [["Computadora", 300000, 0], ["Monitor", 150000, 0], ["Celular", 200000, 0], 
             ["Alexa", 230000, 0], ["Camara", 70000, 0]] #Representan el precio y la cantidad de cada producto
#Facturacion
ahorro = 0
subtotal = 0
iva = 0
total = 0
#-------------------------Librerias----------------------------------------------
import sys
#-------------------------Funciones---------------------------------------------
def login(user, password):
        user = input("Ingrese nombre de Usuario: ")
        password = input("Ingrese contraseña: ")
        if user == users[0][0] and password == users[0][1]:
                return True
        elif user == users[1][0] and password == users[1][1]:
                return True
        else:
                return False

def historial(cliente, productos):
        print("Historial")
        print("El cliente: ", cliente[0], cliente[1], " Tiene los siguientes productos:")
        print("Computadoras: ", productos[0][2])
        print("Monitores: ", productos[1][2])
        print("Celulares: ", productos[2][2])
        print("Alexas: ", productos[3][2])
        print("Camaras: ", productos[4][2])
        print("Con un subTotal de $", 
                  productos[0][2] * productos[0][1] + 
                  productos[1][2] * productos[1][1] + 
                  productos[2][2] * productos[2][1] + 
                  productos[3][2] * productos[3][1] + 
                  productos[4][2] * productos[4][1])
#-----------------------Programa--------------------------------------------------
print("----------Bienvenido al sistema de facturacion de Austin's Electronics----------")
print("----------Por favor inicie sesion----------")
#----------Inicio de sesion en caso de que coloque el usuario y contraseña incorrectos----------------
while login(user, password) == False:
        print("")
        print("Usuario o contraseña incorrectos")
        print("Intentos restantes: ", 3 - intentos)
        intentos += 1
        print("")
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
print("-----Datos registrados correctamente-----")
print("")

#-------------------------Menu-------------------------------------
while repetir_menu == 1:
        print("-----Se encuentra en el menu de Austin's Electronics-----")
        print("--Paquetes de productos dijite | 1 |--")
        print("--Productos dijite | 2 |--")
        print("--Historial dijite | 3 |--")
        print("--Facturacion dijite | 4 |--")
        print("--Salir dijite | 0 |--")
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
                                        productos[0][2] += 1  # Computadora
                                        productos[1][2] += 1  # Monitor
                                        productos[3][2] += 1  # Alexa
                                        print("Paquete 1 agregado correctamente")
                                        ahorro += (productos[0][1] + productos[1][1] + productos[3][1]) * 0.15
                        elif paquete == 2:
                                        productos[4][2] += 1  # Camara
                                        productos[2][2] += 1  # Celular
                                        print("Paquete 2 agregado correctamente")
                                        ahorro += (productos[4][1] + productos[2][1]) * 0.15
                        elif paquete == 3:
                                        productos[0][2] += 1  # Computadora
                                        productos[1][2] += 1  # Monitor
                                        print("Paquete 3 agregado correctamente")
                                        ahorro += (productos[0][1] + productos[1][1]) * 0.15
                        elif paquete == 4:
                                        productos[2][2] += 1  # Celular
                                        productos[3][2] += 1  # Alexa
                                        print("Paquete 4 agregado correctamente")
                                        ahorro += (productos[2][1] + productos[3][1]) * 0.15
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
                                productos[0][2] += 1
                                print("Computadora agregada")
                        elif producto == 2:
                                productos[1][2] += 1
                                print("Monitor agregado")
                        elif producto == 3:
                                productos[2][2] += 1
                                print("Celular agregado")
                        elif producto == 4:
                                productos[3][2] += 1
                                print("Alexa agregado")
                        elif producto == 5:
                                productos[4][2] += 1
                                print("Camara agregada")
                        else:
                                print("Opcion no valida")
                        repetir_producto = int(input("Si desea agregar otro producto dijite | 1 |, si desea salir al menu elija | 2 |: "))
        #Historial
        elif menu == 3:
                historial(cliente, productos)
        #Facturacion
        elif menu == 4:
                computadora_precio = productos[0][1] * productos[0][2]
                monitor_precio = productos[1][1] * productos[1][2]
                celular_precio = productos[2][1] * productos[2][2]
                alexa_precio = productos[3][1] * productos[3][2]
                camara_precio = productos[4][1] * productos[4][2]
                print("Facturacion")
                for i in cliente:
                        print("---|", i, "|---")
                print("| Computadoras: ", productos[0][2], " | Precio: $", computadora_precio, " |")
                print("| Monitores: ", productos[1][2], " | Precio: $", monitor_precio, " |")
                print("| Celulares: ", productos[2][2], " | Precio: $", celular_precio, " |")
                print("| Alexas: ", productos[3][2], " | Precio: $", alexa_precio, " |")
                print("| Camaras: ", productos[4][2], " | Precio: $", camara_precio, " |")
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
        #Salir
        elif menu == 0:
                print("Gracias por visitarnos")
                sys.exit()
        else:
                print("Opcion no valida")
        print("")

print("")
print("Gracias por visitarnos")