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
public class Paciente {
    //Atributos del paciente
    private String name;  //Se coloca como final para evitar que se llegue a modificar en un  futuro
    private int age;
    private String id;
    private HistoriaClinica historiaClinica;

    //Constructor de Paciente
    protected Paciente(String name, int age, String id){ //Se le coloca el parametro de name, age y id para que sea necesa
        this.name = name;
        this.age = age;
        this.id = id;
    }

    //Set para la historia clinica
    public void setHistoriaClinica(){
        System.out.println("----Informacion de la historia clinica del paciente----");
        Scanner antecedentesScanner = new Scanner(System.in);
        System.out.print("Ingrese los antecedentes: ");
        var antecedentes = antecedentesScanner.next();
        Scanner sintomasScanner = new Scanner(System.in);
        System.out.print("Ingrese los sintomas del paciente: ");
        var sintomas = sintomasScanner.next();
        Scanner diagnosticoScanner = new Scanner(System.in);
        System.out.print("Ingrese el diagnostico del paciente: ");
        var diagnostico = diagnosticoScanner.next();
        this.historiaClinica = new HistoriaClinica(antecedentes, sintomas, diagnostico);
    }

    //get para cada uno de los atributos
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getid(){
        return id;
    }
    public HistoriaClinica getHistoriaClinica(){
        return historiaClinica;
    }

}
