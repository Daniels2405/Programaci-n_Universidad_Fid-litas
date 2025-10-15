/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaevaluada1;
import java.util.Scanner;
/**
 *
 * @author daniel
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        //Uso de switch: Crea una clase con un método main que identifique un planeta a partir de una letra.
        System.out.println("Uso de switch:");
        Scanner scanner = new Scanner(System.in);
        //Se pide que ingrese la letra inicial del planeta
        System.out.print("Ingrese la letra inicial del planeta (M, V, T, J, S, U, N): ");
        String letra = scanner.nextLine().toUpperCase(); //Se usa mayusculas para evitar errores
        //Se usa switch para identificar el planeta
        switch (letra) {  
            case "M":
                System.out.println("Marte");
                break;
            case "V":
                System.out.println("Venus");
                break;
            case "T":
                System.out.println("Tierra");
                break;
            case "J":
                System.out.println("Júpiter");
                break;
            //Aunque el ejercicio solo pide jupiter, se agregan los demas planetas para completar el sistema solar,
            //Ya que se utiliza la misma logica
            case "S":
                System.out.println("Saturno");
                break;
            case "U":
                System.out.println("Urano");
                break;
            case "N":
                System.out.println("Neptuno");
                break;
            //Caso por defecto si no coincide con ninguna letra se imprime un mensaje que el planeta no es reconocido
            default:
                System.out.println("Planeta no reconocido");
                break;
        }
    }
}
