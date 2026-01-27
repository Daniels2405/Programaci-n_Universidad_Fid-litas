/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana01;

/**
 *
 * @author daniel-2405
 */
public class Semana01 {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.nombre = "Daniel";
        persona1.setEdad(20);
        persona1.saludar();
        persona1.setNombre("Axel");
        persona1.setEdad(25);
        persona1.saludar();
        System.out.println(persona1.getNombre());
    }
}
