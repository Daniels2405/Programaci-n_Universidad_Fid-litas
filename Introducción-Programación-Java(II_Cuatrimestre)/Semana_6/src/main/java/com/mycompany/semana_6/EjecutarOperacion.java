/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.semana_6;
import java.util.Scanner;
/**
 *
 * @author daniel
 */
public class EjecutarOperacion {

    public static void main(String[] args) {
        //Parte 2
        var estudiante = new Estudiantes();
        estudiante.setNombre("Daniel");
        estudiante.setApellido("Barrientos");
        estudiante.setCorreo("dn@gmail.com");
        estudiante.setEdad(18);
        estudiante.setTelefono("2390932");
        
        estudiante.mostrarInfo(estudiante.getNombre(), estudiante.getApellido(), estudiante.getCorreo());
        
        //Parte 3
        var estudiante2 = new Estudiantes(40249034, 20, "87149157");
        estudiante2.setNombre("Leo");
        System.out.println(estudiante2.obtenerInfo());
        
        
    }
}
