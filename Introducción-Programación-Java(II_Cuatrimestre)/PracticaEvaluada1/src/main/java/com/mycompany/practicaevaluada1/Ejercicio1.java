/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicaevaluada1;
import java.util.Scanner;
/**
 *
 * @author daniel
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        // Uso de if y else: Crea una clase con un método main que evalúe la calificación de un estudiante.
        System.out.println("Uso de if y else:");
        Scanner scanner = new Scanner(System.in);
        //Se pide que ingrese la nota
        System.out.print("Ingrese la nota del estudiante: ");
        int nota = scanner.nextInt();
        //Variable para almacenar la calificación
        String calificacion = "";
        //Se evalua la nota y se asigna la calificacion que corresponde
        if (nota >= 90) {
            calificacion = "A";
        } else if (nota >= 80) {
            calificacion = "B";
        } else if (nota >= 70) {
            calificacion = "C";
        } else if (nota >= 60) {
            calificacion = "D";
        } else {
            calificacion = "F";
        }
        //Se imprime la calificación
        System.out.println("La calificación es: " + calificacion);
    }
}
