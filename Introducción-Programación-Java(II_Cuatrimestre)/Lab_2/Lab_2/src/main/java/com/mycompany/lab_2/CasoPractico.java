/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab_2;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class CasoPractico {

    public static void main(String[] args) {
        //Inicio del programa
        System.out.println("--------Bienvenido al Sistema de Recetas Médicas de la CCSS--------");
        var Receta1 = new Receta();
        Receta1.setReceta();
        //Para que se genere un espacio en la terminal que separe el ingreso de datos con la salida
        System.out.println("");
        System.out.println("");

        //Inicio de la salida de datos
        System.out.println("==== Registro de Paciente CCSS ====");
        //Paciente
        System.out.println("Nombre: " + Receta1.getPaciente().getName());
        System.out.println("Edad: " + Receta1.getPaciente().getAge());
        System.out.println("Cédula: " + Receta1.getPaciente().getid());
        //Historia clinica
        System.out.println("== Historia Clínica ==");
        System.out.println("Antecedentes: " + Receta1.getPaciente().getHistoriaClinica().getAntecedentes());
        System.out.println("Antecedentes: " + Receta1.getPaciente().getHistoriaClinica().getSintomas());
        System.out.println("Antecedentes: " + Receta1.getPaciente().getHistoriaClinica().getDiagnostico());
        //Receta Medica
        System.out.println("== Receta Generada ==");
        //System.out.println(""); //El ID
        System.out.println("Paciente: " + Receta1.getPaciente().getName() +
                            " (Cédula: " + Receta1.getPaciente().getid() + 
                            ", Edad: " + Receta1.getPaciente().getAge());
        System.out.println("Dr. " + Receta1.getMedico().getname() +
                            " - Especialidad: " + Receta1.getMedico().getepecialidad());
        System.out.println("Medicamentos:");
        System.out.println(" -" + Receta1.getMedicamentos().getName() +
                            " -" + Receta1.getMedicamentos().getCant() +
                            " cada " + Receta1.getMedicamentos().getTime());
        
    }
}
