''' -------------------- Caso 2-----------------------
    --------------------usuario: admin-----------------------
    --------------------password: 123-----------------------'''
#variables
user_admin = "admin"
password_admin = "123"
user = ""
password = ""
intentos = 0
autentificacion = 0
menu = 0
#Arrelgo guarda el codigo, nombre, autor, año de publicacion y estado del libro (prestado o en stock)
libros = [[0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""],
          [0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""]]
#Arreglo guarda el codigo del libro, nombre del usuario, fecha de prestamo(dd/mm/aaaa), fecha de devolucion(dd/mm/aaaa) y estado del libro (prestado o en stock)
prestamos = [[0, "", 0, 0, 0, 0, 0, 0, ""], [0, "", 0, 0, 0, 0, 0, 0, ""], [0, "", 0, 0, 0, 0, 0, 0, ""], [0, "", 0, 0, 0, 0, 0, 0, ""], [0, "", 0, 0, 0, 0, 0, 0, ""]]
codigo = 0
cantidad = 0
codigo_libro = 0
codigo_prestamo = 0
buscador = 0
dia_prestamo = ""
mes_prestamo = ""
año_prestamo = ""
dia_devolucion = ""
mes_devolucion = ""
año_devolucion = ""
nombre_usuario = ""
#funciones
def loggin(user, password):
    user = input("---Ingrese nombre de usuario: ")
    password = input("---Ingrese contraseña: ")
    if user == user_admin and password == password_admin:
        return True
    else:
        return False


#programa
print("Bienvenido al sistema de la libreria")
print("Ingrese su nombre de usuario y contraseña para acceder al sistema")
if loggin(user, password) == True:
    print("")
    print("Bienvenido al sistema de la libreria")
    while menu != 5:
        print("Se encuentra en el menu principal")
        print("|1. Registrar libro|")
        print("|2. Catalogo de libros|")
        print("|3. Registrar prestamo de libro|")
        print("|4. Registrar devolucion de libro|")
        print("|5. Salir|")
        print("")
        menu = int(input("Ingrese la opcion deseada: "))
        if menu == 1:
            print("----------Registrar libro----------")
            codigo += 1
            libros [cantidad][0] = codigo 
            libros [cantidad][1] = input("Ingrese el nombre del libro: |")
            libros [cantidad][2] = input("Ingrese el autor del libro: |")
            libros [cantidad][3] = input("Ingrese el año de publicacion del libro: |")
            libros [cantidad][4] = "Stock"
            cantidad += 1
            for i in range (0, len(libros)):
                if libros[i][1] != "":
                    print("---Codigo: ", libros[i][0])
                    print("---Nombre: ", libros[i][1])
                    print("---Autor: ", libros[i][2])
                    print("---Año de publicacion: ", libros[i][3])
                    print("---Estado: ", libros[i][4])
                    print("")
        if menu == 2:
            print("------------Catalogo de libros------------")
            print("Que libros desea ver?")
            print("----1. Todos los libros-----")
            print("----2. Libros disponibles-----")
            print("----3. Libros prestados")
            print("----4. buscar libro por nombre----")
            print("----5. buscar libro por codigo----")
            print("")
            buscador = int(input("Ingrese la opcion deseada: "))
            if buscador == 1:
                for i in range (0, len(libros)):
                    if libros[i][1] != "":
                        print("---Codigo: ", libros[i][0])
                        print("---Nombre: ", libros[i][1])
                        print("---Autor: ", libros[i][2])
                        print("---Año de publicacion: ", libros[i][3])
                        print("---Estado: ", libros[i][4])
                        print("")
            elif buscador == 2:
                for i in range (0, len(libros)):
                    if libros[i][1] != "":
                        if libros[i][4] == "Stock":
                            print("---Codigo: ", libros[i][0])
                            print("---Nombre: ", libros[i][1])
                            print("---Autor: ", libros[i][2])
                            print("---Año de publicacion: ", libros[i][3])
                            print("---Estado: ", libros[i][4])
                            print("")
            elif buscador == 3:
                for i in range (0, len(libros)):
                    if libros[i][1] != "":
                        if libros[i][4] == "Prestado":
                            print("---Codigo: ", libros[i][0])
                            print("---Nombre: ", libros[i][1])
                            print("---Autor: ", libros[i][2])
                            print("---Año de publicacion: ", libros[i][3])
                            print("---Estado: ", libros[i][4])
                            print("")
            elif buscador == 4:
                nombre_libro = input("Ingrese el nombre del libro que desea buscar: ")
                for i in range (0, len(libros)):
                    if libros[i][1] != "":
                        if libros[i][1] == nombre_libro:
                            print("---Codigo: ", libros[i][0])
                            print("---Nombre: ", libros[i][1])
                            print("---Autor: ", libros[i][2])
                            print("---Año de publicacion: ", libros[i][3])
                            print("---Estado: ", libros[i][4])
                            print("")
                        else:
                            print("El libro no se encuentra disponible")
            elif buscador == 5:
                codigo_libro = int(input("Ingrese el codigo del libro que desea buscar: "))
                for i in range (0, len(libros)):
                    if libros[i][1] != "":
                        if libros[i][0] == codigo_libro:
                            print("---Codigo: ", libros[i][0])
                            print("---Nombre: ", libros[i][1])
                            print("---Autor: ", libros[i][2])
                            print("---Año de publicacion: ", libros[i][3])
                            print("---Estado: ", libros[i][4])
                            print("")
                        else:
                            print("El libro no se encuentra disponible")
            else:
                print("Opcion no valida")   
        if menu == 3:
            print ("----------Registrar prestamo de libro----------")
            print("Ingrese el codigo del libro que desea prestar: ")
            codigo_libro = int(input("Codigo: "))
            print("Ingrese el nombre del usuario que solicita el prestamo: ")
            nombre_usuario = input("Nombre: ")
            print("Ingrese la fecha de prestamo: ")
            dia_prestamo = int(input("Dia: "))
            mes_prestamo = int(input("Mes: "))
            año_prestamo = int(input("Año: "))
            print("Ingrese la fecha de devolucion asignada: ")
            dia_devolucion = int(input("Dia: "))
            mes_devolucion = int(input("Mes: "))
            año_devolucion = int(input("Año: "))
            for i in range (0, len(libros)):
                if libros[i][1] != "":
                    if libros[i][0] == codigo_libro:
                        if libros[i][4] == "Stock":
                            libros[i][4] = "Prestado"
                            print("El libro ha sido prestado")
                            print("---Codigo: ", libros[i][0])
                            print("---Nombre: ", libros[i][1])
                            print("---Autor: ", libros[i][2])
                            for i in range (0, len(prestamos)):
                                if prestamos[i][1] == "":
                                    prestamos[i][0] = codigo_libro
                                    prestamos[i][1] = nombre_usuario
                                    prestamos[i][2] = dia_prestamo
                                    prestamos[i][3] = mes_prestamo
                                    prestamos[i][4] = año_prestamo
                                    prestamos[i][5] = dia_devolucion
                                    prestamos[i][6] = mes_devolucion
                                    prestamos[i][7] = año_devolucion
                                    prestamos[i][8] = "Prestado"
                                    break
                        else:
                            print("El libro se encuentra prestado")
                    else:
                        print("El libro no se encuentra disponible")
        if menu == 4:
            print ("----------Registrar devolucion de libro----------")
            print("Ingrese el codigo del libro que desea devolver: ")
            codigo_libro = int(input("Codigo: "))
            print("Ingrese la fecha de devolucion: ")
            dia_devolucion = int(input("Dia: "))
            mes_devolucion = int(input("Mes: "))
            año_devolucion = int(input("Año: "))
            for i in range (0, len(libros)):
                if libros[i][1] != "":
                    if libros[i][0] == codigo_libro:
                        if libros[i][4] == "Prestado":
                            libros[i][4] = "Stock"
                            print("El libro ha sido devuelto")
                            print("---Codigo: ", libros[i][0])
                            print("---Nombre: ", libros[i][1])
                            print("---Autor: ", libros[i][2])
                            for i in range (0, len(prestamos)):
                                if prestamos[i][0] == codigo_libro:
                                    if prestamos[i][7] <= año_devolucion:
                                        if prestamos[i][6] <= mes_devolucion:
                                            if prestamos[i][5] < dia_devolucion:
                                                print("El libro ha sido devuelto fuera de fecha")
                                                print("El usuario: ", prestamos[i][1])
                                                print("Debe pagar una multa de: ", 0.5 * (dia_devolucion - prestamos[i][5]), "dolares")
                                            else:
                                                print("El libro ha sido devuelto a tiempo")
                                                print("No tiene multa")
                                        else:
                                            print("El libro ha sido devuelto a tiempo")
                                            print("No tiene multa")
                                    else:
                                        print("El libro ha sido devuelto a tiempo")
                                        print("No tiene multa")
                                    break
                            prestamos[i][0] = 0
                            prestamos[i][1] = ""
                            prestamos[i][2] = 0
                            prestamos[i][3] = 0
                            prestamos[i][4] = 0
                            prestamos[i][5] = 0
                            prestamos[i][6] = 0
                            prestamos[i][7] = 0
                            prestamos[i][8] = ""
                            break
                        else:
                            print("El libro no se encuentra en stock")
                    else:
                        print("El libro no se encuentra disponible")
else:
    print("Gracias por usar el sistema de la libreria")    

