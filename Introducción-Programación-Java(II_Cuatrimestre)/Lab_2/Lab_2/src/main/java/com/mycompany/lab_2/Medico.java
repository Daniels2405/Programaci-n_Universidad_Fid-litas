/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_2;

/**
 *
 * @author daniel
 */
public class Medico {
    //Atributos del medico
    private String name;
    private Especialidad especialidad;


    //Constructor
    protected Medico(String name, Especialidad especialidad){
        this.name = name;
        this.especialidad = especialidad;
    }

    //get de name y especialidad
    public String getname(){
        return name;
    }
    public Especialidad getepecialidad(){
        return especialidad;
    }

}
