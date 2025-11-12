/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_introduccion_java;
import java.time.LocalDateTime;
import com.mycompany.proyecto_introduccion_java.Clases.*;
import com.mycompany.proyecto_introduccion_java.Controlador.SistemaLaboratorio;
/**
 *
 * @author daniel
 */
public class Proyecto_Introduccion_Java {

    public static void main(String[] args) {
        //Se crea el sistema de laboratorio
        SistemaLaboratorio SistemaCPV = new SistemaLaboratorio(
            "CPV Labs",
            new Laboratorio[10],
            new Paciente[100],
            new ParametroReferencia[50]);
        //Se crean los laboratorios y se agregan al sistema
        Laboratorio lab1 = new Laboratorio(
            "Lab Central", 
            "3-101-458962", 
            "200 metros al sur de la plaza de Mercedes norte", 
            "8892-2334",
            "CPVCentral@CPVCR.com");
        Laboratorio lab2 = new Laboratorio(
            "Lab Alajuela",
            "3-102-458963",
            "300 metros al este del parque central de Alajuela",
            "2431-5678",
            "CPVAlajuela@CPVCR.com"
            );
            SistemaCPV.setLaboratorios(lab1);
            SistemaCPV.setLaboratorios(lab2);
        //Se inicia el programa con un menu principal con el que se ejecutara el sistema de laboratorios
        
    }

    public boolean Login(){
        return true;
    }

    public void mostrarMenuPrincipal(){
        
    }
}
