/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaevaluada1;

/**
 *
 * @author daniel
 */
public class Ejercicio3 {
    public static void main(String[] args) {
    //Uso de for: Crea una clase con un método main que imprima los números pares.
    System.out.println("Uso de for:");
    System.out.println("Números pares del 0 al 20:");
    //Se usa un ciclo for para imprimir los números pares del 0 al 20, que podria tener el rango que se desee y siempre imprimira los pares
    for (int i = 0; i <= 20; i++) {
        if (i % 2 == 0) {
            System.out.print(i + " ");
        }
    }
    }
}
