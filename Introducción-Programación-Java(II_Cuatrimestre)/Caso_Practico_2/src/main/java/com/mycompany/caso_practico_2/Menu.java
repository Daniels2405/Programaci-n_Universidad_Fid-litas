/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.caso_practico_2;
import java.util.Scanner;

/**
 *
 * @author daniel-2405
 */
public class Menu {
    private Gestion_Empleados gestionEmpleados = new Gestion_Empleados();
    private boolean salir = false;

    public Menu(){}

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        while (!salir) {
            System.out.println("======= Menú de Gestión de Empleados =======");
            System.out.println("1. Registrar Empleado");
            System.out.println("2. Mostrar Empleados");
            System.out.println("3. Buscar Empleado por ID");
            System.out.println("4. Modificar Empleado");
            System.out.println("5. Eliminar Empleado");
            System.out.println("0. Salir");
            System.out.println("============================================");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    gestionEmpleados.RegistrarEmpleado();
                    break;
                case 2:
                    gestionEmpleados.mostrarEmpleados();
                    break;
                case 3:
                    gestionEmpleados.buscarEmpleado();
                    break;
                case 4:
                    gestionEmpleados.modificarEmpleado();
                    break;
                case 5:
                    gestionEmpleados.eliminarEmpleado();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }
}
