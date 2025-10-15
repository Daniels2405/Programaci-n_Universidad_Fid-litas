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
    public Medicamentos(String name, String cantidad, String time){
        this.name = name;
        this.cantidad = cantidad;
        this.time = time;
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
