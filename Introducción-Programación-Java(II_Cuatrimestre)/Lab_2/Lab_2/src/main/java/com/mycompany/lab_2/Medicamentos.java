/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_2;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Medicamentos {
    //Atributos para el medicamento
    private String name;
    private String cantidad;
    private String time;

    //set para los atributos del medicamento
    public void setMedicamento(){
        System.out.println("--------Informacion de los medicamentos--------");
        //nombre
        Scanner nameScanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del medicamento: ");
        name = nameScanner.next();

        //La cantidad que debe ingerir
        Scanner cantScanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad que debe ingerir el paciente: ");
        cantidad = cantScanner.next();

        //Cada cuanto tiempo el paciente tiene que ingerir el medicamento
        Scanner timeScanner = new Scanner(System.in);
        System.out.print("Ingrese cada cuanto tiempo el paciente tiene que ingerir el medicamento: ");
        time = timeScanner.next();
    }

    public String getName(){
        return name;
    }
    public String getCant(){
        return cantidad;
    }
    public String getTime(){
        return time;
    }



}
