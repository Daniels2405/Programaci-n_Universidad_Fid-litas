/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase01;
import java.sql.Date;

/**
 *
 * @author daniel-2405
 */
public class Clase01 {
    private static final int MAXPERSONA = 30;

    public static void main(String[] args) {
        System.out.println("Opciones permitidas para el campo de Genero.");
        for (Genero opcionGenero: Genero.values()){
            System.out.println(opcionGenero.name());
        }

        Persona miPersona = new Persona("4-0270-0383","Daniel Barrientos Salas", "M", Date.valueOf("2005-12-14"));
        System.out.println(miPersona.toString());
    }
}
