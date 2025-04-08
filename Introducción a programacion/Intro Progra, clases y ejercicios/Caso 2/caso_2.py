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
libros = [[0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""],
          [0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""], [0, "", "", "", ""]]
codigo = 0
cantidad = 0
codigo_prestamo = 0
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
            print(cantidad)
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
            for i in range (0, len(libros)):
                if libros[i][1] != "":
                    print("---Codigo: ", libros[i][0])
                    print("---Nombre: ", libros[i][1])
                    print("---Autor: ", libros[i][2])
                    print("---Año de publicacion: ", libros[i][3])
                    print("---Estado: ", libros[i][4])
                    print("")
        if menu == 3:
            print ("----------Registrar prestamo de libro----------")
            print("Ingrese el codigo del libro que desea prestar: ")
            codigo_prestamo = int(input("Codigo: "))
            for i in range (0, len(libros)):
                if libros[i][1] != "":
                    if libros[i][0] == codigo_prestamo:
                        if libros[i][4] == "Stock":
                            libros[i][4] = "Prestado"
                            print("El libro ha sido prestado")
                            print("---Codigo: ", libros[i][0])
                            print("---Nombre: ", libros[i][1])
                            print("---Autor: ", libros[i][2])
                        else:
                            print("El libro se encuentra prestado")
                    else:
                        print("El libro no se encuentra disponible")
        if menu == 4:
            print ("----------Registrar devolucion de libro----------")
            print("Ingrese el codigo del libro que desea devolver: ")
            codigo_prestamo = int(input("Codigo: "))
            for i in range (0, len(libros)):
                if libros[i][1] != "":
                    if libros[i][0] == codigo_prestamo:
                        if libros[i][4] == "Prestado":
                            libros[i][4] = "Stock"
                            print("El libro ha sido devuelto")
                            print("---Codigo: ", libros[i][0])
                            print("---Nombre: ", libros[i][1])
                            print("---Autor: ", libros[i][2])
                        else:
                            print("El libro no se encuentra en stock")
                    else:
                        print("El libro no se encuentra disponible")
else:
    print("Gracias por usar el sistema de la libreria")    

