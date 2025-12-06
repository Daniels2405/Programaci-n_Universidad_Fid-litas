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
public class Gestion_Empleados {
    private Empleado[] empleados = new Empleado[100];

    //Constructor vacio
    public Gestion_Empleados() {}

    //Metodo para registrar empleado
    public void RegistrarEmpleado() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < empleados.length; i++) {
            if (i < empleados.length && empleados[i] == null) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(i+1);
                System.out.print("Imgrese el nombre del empleado: ");
                empleado.setNombre(sc.next());
                System.out.print("Ingrese el primer apellido del empleado: ");
                String primerApellido = sc.next();
                System.out.print("Ingrese el segundo apellido del empleado: ");
                String segundoApellido = sc.next();
                empleado.setApellidos(new String[]{primerApellido, segundoApellido});
                System.out.print("Ingrese la cédula del empleado: ");
                empleado.setCedula(sc.next());
                System.out.print("Ingrese la edad del empleado: ");
                empleado.setEdad(sc.nextInt());
                sc.nextLine();
                System.out.print("Ingrese el puesto del empleado: ");
                empleado.setPuesto(sc.nextLine());
                System.out.print("Ingrese el departamento del empleado: ");
                empleado.setDepartamentoTrabajo(sc.nextLine());
                System.out.print("Ingrese el salario del empleado: ");
                empleado.setSalario (sc.nextDouble());
                sc.nextLine();
                System.out.print("Ingrese el teléfono del empleado: ");
                empleado.setTelefono(sc.nextLine());
                System.out.print("Ingrese el email del empleado: ");
                empleado.setEmail(sc.nextLine());
                System.out.print("Ingrese la dirección de vivienda del empleado: ");
                empleado.setDireccion(sc.nextLine());
                System.out.print("Ingrese la nacionalidad del empleado: ");
                empleado.setNacionalidad(sc.nextLine());
                empleados[i] = empleado;
                System.out.println("Empleado registrado exitosamente.");
                break;
            } else {
                System.out.println("No se pueden registrar más empleados, capacidad máxima alcanzada.");
            }
        }
    }

    //Metodo para mostrar empleados
    public void mostrarEmpleados() {
        for (int i = 0; i < empleados.length; i++){
            if (empleados[i] != null){
                System.out.println("Empleado ID: " + empleados[i].getIdEmpleado());
                System.out.println("Nombre: " + empleados[i].getNombre());
                System.out.println("Apellidos: " + String.join(" ", empleados[i].getApellidos()));
                System.out.println("Cédula: " + empleados[i].getCedula());
                System.out.println("Edad: " + empleados[i].getEdad());
                System.out.println("Puesto: " + empleados[i].getPuesto());
                System.out.println("Departamento de Trabajo: " + empleados[i].getDepartamentoTrabajo());
                System.out.println("Salario: " + empleados[i].getSalario());
                System.out.println("Teléfono: " + empleados[i].getTelefono());
                System.out.println("Email: " + empleados[i].getEmail());
                System.out.println("Dirección: " + empleados[i].getDireccion());
                System.out.println("Nacionalidad: " + empleados[i].getNacionalidad());
                System.out.println("-------------------------------");
                System.out.println("");
            }
        }
    }

    //Metodo para buscar empleado por ID
    public int buscarEmpleado() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el ID del empleado a buscar: ");
        int idEmpleado = sc.nextInt();
        boolean encontrado = false;
        for (int i = 0; i < empleados.length; i++) {
            if (empleados[i] != null && empleados[i].getIdEmpleado() == idEmpleado) {
                System.out.println("Empleado ID: " + empleados[i].getIdEmpleado());
                System.out.println("Nombre: " + empleados[i].getNombre());
                System.out.println("Apellidos: " + String.join(" ", empleados[i].getApellidos()));
                System.out.println("Cédula: " + empleados[i].getCedula());
                System.out.println("Edad: " + empleados[i].getEdad());
                System.out.println("Puesto: " + empleados[i].getPuesto());
                System.out.println("Departamento de Trabajo: " + empleados[i].getDepartamentoTrabajo());
                System.out.println("Salario: " + empleados[i].getSalario());
                System.out.println("Teléfono: " + empleados[i].getTelefono());
                System.out.println("Email: " + empleados[i].getEmail());
                System.out.println("Dirección: " + empleados[i].getDireccion());
                System.out.println("Nacionalidad: " + empleados[i].getNacionalidad());
                System.out.println("-------------------------------");
                System.out.println("");
                encontrado = true;
                return i;
            }
        }
        if (!encontrado) {
            System.out.println("Empleado con ID " + idEmpleado + " no encontrado.");
        }
        return -1;
    }

    
    public void modificarEmpleado(){
        Scanner sc = new Scanner(System.in);
        int indice = buscarEmpleado();
        boolean salir = false;
        if (indice != -1) {
            while (!salir) {
                System.out.println("Seleccione el campo a modificar:");
                System.out.println("1. Nombre");
                System.out.println("2. Apellidos");
                System.out.println("3. Cédula");
                System.out.println("4. Edad");
                System.out.println("5. Puesto");
                System.out.println("6. Despartamento de Trabajo");
                System.out.println("7. Salario");
                System.out.println("8. Teléfono");
                System.out.println("9. Email");
                System.out.println("A. Dirección");
                System.out.println("B. Nacionalidad");
                System.out.println("0. Salir");
                String opcion = sc.next();
                switch (opcion) {
                    case "1":
                        System.out.print("Ingrese el nuevo nombre: ");
                        String nuevoNombre = sc.next();
                        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                            empleados[indice].setNombre(nuevoNombre);
                            System.out.println("Nombre actualizado correctamente.");
                            break;
                        } else {
                            System.out.println("Nombre no válido.");
                            break;
                        }

                    case "2":
                        System.out.print("Ingrese el primer apellido: ");
                        String primerApellido = sc.next();
                        System.out.print("Ingrese el segundo apellido: ");
                        String segundoApellido = sc.next();
                        if (!primerApellido.isEmpty() && !segundoApellido.isEmpty()) {
                            empleados[indice].setApellidos(new String[]{primerApellido, segundoApellido});
                            System.out.println("Apellidos actualizados correctamente.");
                        } else {
                            System.out.println("Apellidos no válidos.");
                        }
                        break;
                    
                    case "3":
                        System.out.print("Ingrese la nueva cédula: ");
                        String nuevaCedula = sc.next();
                        if (!nuevaCedula.isEmpty()) {
                            empleados[indice].setCedula(nuevaCedula);
                            System.out.println("Cédula actualizada correctamente.");
                        } else {
                            System.out.println("Cédula no válida.");
                        }
                        break;
                    
                    case "4":
                        System.out.print("Ingrese la nueva edad: ");
                        int nuevaEdad = sc.nextInt();
                        if (nuevaEdad > 0) {
                            empleados[indice].setEdad(nuevaEdad);
                            System.out.println("Edad actualizada correctamente.");
                        } else {
                            System.out.println("Edad no válida.");
                        }
                        break;
                    
                    case "5":
                        System.out.print("Ingrese el nuevo puesto: ");
                        String nuevoPuesto = sc.next();
                        if (!nuevoPuesto.isEmpty()) {
                            empleados[indice].setPuesto(nuevoPuesto);
                            System.out.println("Puesto actualizado correctamente.");
                        } else {
                            System.out.println("Puesto no válido.");
                        }
                        break;
                    
                    case "6":
                        System.out.print("Ingrese el nuevo departamento: ");
                        String nuevoDepartamento = sc.next();
                        if (!nuevoDepartamento.isEmpty()) {
                            empleados[indice].setDepartamentoTrabajo(nuevoDepartamento);
                            System.out.println("Departamento actualizado correctamente.");
                        } else {
                            System.out.println("Departamento no válido.");
                        }
                        break;
                    
                    case "7":
                        System.out.print("Ingrese el nuevo salario: ");
                        double nuevoSalario = sc.nextDouble();
                        if (nuevoSalario >= 0) {
                            empleados[indice].setSalario(nuevoSalario);
                            System.out.println("Salario actualizado correctamente.");
                        } else {
                            System.out.println("Salario no válido.");
                        }
                        break;
                    
                    case "8":
                        System.out.print("Ingrese el nuevo teléfono: ");
                        String nuevoTelefono = sc.next();
                        if (!nuevoTelefono.isEmpty()) {
                            empleados[indice].setTelefono(nuevoTelefono);
                            System.out.println("Teléfono actualizado correctamente.");
                        } else {
                            System.out.println("Teléfono no válido.");
                        }
                        break;
                    
                    case "9":
                        System.out.print("Ingrese el nuevo email: ");
                        String nuevoEmail = sc.next();
                        if (!nuevoEmail.isEmpty()) {
                            empleados[indice].setEmail(nuevoEmail);
                            System.out.println("Email actualizado correctamente.");
                        } else {
                            System.out.println("Email no válido.");
                        }
                        break;
                    
                    case "A":
                        System.out.print("Ingrese la nueva dirección: ");
                        String nuevaDireccion = sc.next();
                        if (!nuevaDireccion.isEmpty()) {
                            empleados[indice].setDireccion(nuevaDireccion);
                            System.out.println("Dirección actualizada correctamente.");
                        } else {
                            System.out.println("Dirección no válida.");
                        }
                        break;
                    
                    case "B":
                        System.out.print("Ingrese la nueva nacionalidad: ");
                        String nuevaNacionalidad = sc.next();
                        if (!nuevaNacionalidad.isEmpty()) {
                            empleados[indice].setNacionalidad(nuevaNacionalidad);
                            System.out.println("Nacionalidad actualizada correctamente.");
                        } else {
                            System.out.println("Nacionalidad no válida.");
                        }
                        break;
                    
                    case "0":
                        System.out.println("Saliendo del menú de modificación...");
                        salir = true;
                        break;
                    
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        }
    }

    //Metodo para eliminar empleado
    public void eliminarEmpleado() {
        Scanner sc = new Scanner(System.in);
        int indice = buscarEmpleado();
        if (indice != -1) {
            System.out.print("¿Está seguro de que desea eliminar este empleado? (s/n): ");
            String confirmacion = sc.next().toLowerCase();
            if (confirmacion.equals("s")) {
                empleados[indice] = null;
                System.out.println("Empleado eliminado correctamente.");
            } else {
                System.out.println("Operación cancelada.");
            }
        }
    }
}
