/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana9;
import java.util.Scanner;
/**
 *
 * @author daniel
 */
public class Semana9 {

    public static void main(String[] args) {
        Estudiantes ArraEstudiante[] = new Estudiantes[5];

        for (int i = 0; i < ArraEstudiante.length; i++) {
            System.out.println("Estudiante #" + (i+1));
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el nombre del estudiante: ");
            String nombre = scanner.next();
            scanner = new Scanner(System.in);
            System.out.print("Ingrese los apellidos del estudiante: ");
            String apellidos = scanner.next();
            scanner = new Scanner(System.in);
            System.out.print("Ingrese la cedula del estudiante: ");
            int cedula = scanner.nextInt();
            ArraEstudiante[i] = new Estudiantes(cedula, nombre, apellidos);
            System.out.println("-------------------------------------------");
        }
        
        for (int i = 0; i < ArraEstudiante.length; i++) {
            System.out.println("Estudiante #" + (i + 1));
            System.out.println("Nombre: " + ArraEstudiante[i].getNombre());
            System.out.println("Apellidos: " +ArraEstudiante[i].getApellidos());
            System.out.println("Cedula: " + ArraEstudiante[i].getCedula());;
            System.out.println("-------------------------------------------");
        }
    }
}
